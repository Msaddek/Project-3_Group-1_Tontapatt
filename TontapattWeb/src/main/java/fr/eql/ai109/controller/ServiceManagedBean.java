package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.eql.ai109.ibusiness.ServiceIBusiness;
import fr.eql.ai109.tontapatt.entity.CancellationReason;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.entity.PaymentMethod;
import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;
import fr.eql.ai109.tontapatt.entity.RefusalReason;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable, CalculationVariables {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ServiceIBusiness business;

	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private FieldManagedBean selectedFieldBean;

	@ManagedProperty(value = "#{mbShearingOffer}")
	private ShearingOfferManagedBean selectedOfferBean;

	private Service service;

	private Set<Service> connectedBreederServices;

	private Set<Service> connectedOwnerServices;

	private Set<Service> connectUserPendingServices;

	private Set<Service> connectUserInProgressServices;

	private Set<Service> connectUserCancelledServices;

	private Set<Service> connectUserFinishedServices;

	private LocalDate startDate;

	private LocalDate endDate;

	private LocalDateTime equipmentSetupDate;

	private LocalDateTime equipmentUninstallDate;

	private LocalDateTime herdSetupDate;

	private LocalDateTime herdUninstallDate;

	private LocalDateTime prematureCancellationDate;

	private Double price;

	private Integer requiredAnimalCount;

	private LocalDateTime refusalDate;

	private LocalDateTime requestDate;

	private LocalDateTime validationDate;

	private CancellationReason cancellationReason;

	private Field field;

	private ShearingOffer offer;

	private PaymentMethod paymentMethod;

	private PrematureCancellationReason prematureCancellationReason;

	private RefusalReason refusalReason;

	private ShearingOffer shearingOffer;

	private GrassHeight grassHeight;

	@PostConstruct
	public void init() {
		connectedBreederServices = business.getAllByOfferBreeder(connectedUser);
		connectedOwnerServices = business.getAllByFieldOwner(connectedUser);
		connectUserCancelledServices = business
				.getAllCancelledServicesOfConnectedUser(connectedUser);
		connectUserFinishedServices = business
				.getAllFinishedServicesOfConnectedUser(connectedUser);
		connectUserInProgressServices = business
				.getAllInProgressServicesOfConnectedUser(connectedUser);
		connectUserPendingServices = business
				.getAllPendingServicesOfConnectedUser(connectedUser);
	}

	public String selectOffer() {

		return "/selectedOffer.xhtml?faces-redirect=true";
	}
	
	public String selectService(Service selectedService) {
		service = selectedService;
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String createServiceRequest() {
		String forward = "/services.xhtml?faces-redirect=true";
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyyMMddHHmmssSS");
		Service newService = new Service();
		newService.setRequestDate(LocalDateTime.now());
		newService.setStartDate(startDate);
		newService.setEndDate(endDate);
		newService.setShearingOffer(offer);
		newService.setField(field);
		newService.setDistance(offer.getDistance());
		newService.setPrice(price);

		newService.setPaymentMethod(paymentMethod);
		newService.setGrassHeight(grassHeight);
		newService.setRequiredAnimalCount(requiredAnimalCount);
		newService.setInvoiceNumber(
				"PRST-" + LocalDateTime.now().format(formatter));
		service = business.add(newService);
		init();
		return forward;
	}

	public String validateServiceRequest() {
		service.setValidationDate(LocalDateTime.now());
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String cancelServiceRequest() {
		service.setCancellationDate(LocalDateTime.now());
		service.setCancellationReason(cancellationReason);
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String refuseServiceRequest() {
		service.setRefusalDate(LocalDateTime.now());
		service.setRefusalReason(refusalReason);
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String cancelServicePrematurely() {
		service.setPrematureCancellationDate(LocalDateTime.now());
		service.setPrematureCancellationReason(prematureCancellationReason);
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String setupEquipment() {
		service.setEquipmentSetupDate(LocalDateTime.now());
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String uninstallEquipment() {
		service.setEquipmentUninstallDate(LocalDateTime.now());
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String setupHerd() {
		service.setHerdSetupDate(LocalDateTime.now());
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public String uninstallHerd() {
		service.setHerdUninstallDate(LocalDateTime.now());
		service = business.update(service);
		init();
		return "/selectedService.xhtml?faces-redirect=true";
	}

	public Long calculateServiceNumberOfDays() {
		return ChronoUnit.DAYS.between(startDate, endDate);
	}

	public Integer calculateRequiredAnimalNumber() {
		requiredAnimalCount = (int) (field.getArea()
				/ (calculateServiceNumberOfDays() * SURFACE_ANIMAL_JOUR));
		return requiredAnimalCount;
	}

	public Double calculateTotalAnimalPrice() {
		return calculateServiceNumberOfDays() * requiredAnimalCount
				* offer.getAnimalDailyPrice();
	}

	public Double calculateTravelDistancePrice() {
		return offer.getDistance() * TRUCK_CONSUMPTION_PRICE * 2;
	}

	public Double calculateInterventionPrice() {
		Integer interventionsNumber = (int) (calculateServiceNumberOfDays()
				/ 2);
		return offer.getDistance() * 2 * CAR_CONSUPTION_PRICE
				* interventionsNumber;
	}

	public Double calculateVATPrice() {
		return (calculateTotalAnimalPrice() + calculateTravelDistancePrice()
				+ calculateInterventionPrice()) * VAT;
	}

	public Double calculatePrice() {
		price = calculateTotalAnimalPrice() + calculateTravelDistancePrice()
				+ calculateInterventionPrice() + calculateVATPrice();
		return price;
	}

	public Double calculatePriceForOfferList(ShearingOffer shearingOffer) {
		Integer interventionsNumber = (int) (calculateServiceNumberOfDays()
				/ 2);
		Double priceWithoutVAT = (calculateServiceNumberOfDays()
				* requiredAnimalCount * shearingOffer.getAnimalDailyPrice())
				+ (shearingOffer.getDistance() * TRUCK_CONSUMPTION_PRICE * 2)
				+ (shearingOffer.getDistance() * 2 * CAR_CONSUPTION_PRICE
						* interventionsNumber);
		return priceWithoutVAT * VAT + priceWithoutVAT;

	}

	public String selectedFieldtAsJson() {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(field);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public Integer newPendingService() {
		return business.getAllPendingServicesOfConnectedBreeder(connectedUser)
				.size();
	}

	public String notificationVisibility() {
		if (business.getAllPendingServicesOfConnectedBreeder(connectedUser)
				.isEmpty()) {
			return "notification-hidden";
		} else {
			return "notification-visible";
		}
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public FieldManagedBean getSelectedFieldBean() {
		return selectedFieldBean;
	}

	public void setSelectedFieldBean(FieldManagedBean selectedFieldBean) {
		this.selectedFieldBean = selectedFieldBean;
	}

	public ShearingOfferManagedBean getSelectedOfferBean() {
		return selectedOfferBean;
	}

	public void setSelectedOfferBean(
			ShearingOfferManagedBean selectedOfferBean) {
		this.selectedOfferBean = selectedOfferBean;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Set<Service> getConnectUserPendingServices() {
		return connectUserPendingServices;
	}

	public void setConnectUserPendingServices(
			Set<Service> connectUserPendingServices) {
		this.connectUserPendingServices = connectUserPendingServices;
	}

	public Set<Service> getConnectUserInProgressServices() {
		return connectUserInProgressServices;
	}

	public void setConnectUserInProgressServices(
			Set<Service> connectUserInProgressServices) {
		this.connectUserInProgressServices = connectUserInProgressServices;
	}

	public Set<Service> getConnectUserCancelledServices() {
		return connectUserCancelledServices;
	}

	public void setConnectUserCancelledServices(
			Set<Service> connectUserCancelledServices) {
		this.connectUserCancelledServices = connectUserCancelledServices;
	}

	public Set<Service> getConnectUserFinishedServices() {
		return connectUserFinishedServices;
	}

	public void setConnectUserFinishedServices(
			Set<Service> connectUserFinishedServices) {
		this.connectUserFinishedServices = connectUserFinishedServices;
	}

	public Set<Service> getConnectedBreederServices() {
		return connectedBreederServices;
	}

	public void setConnectedBreederServices(
			Set<Service> connectedBreederServices) {
		this.connectedBreederServices = connectedBreederServices;
	}

	public Set<Service> getConnectedOwnerServices() {
		return connectedOwnerServices;
	}

	public void setConnectedOwnerServices(Set<Service> connectedOwnerServices) {
		this.connectedOwnerServices = connectedOwnerServices;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getEquipmentSetupDate() {
		return equipmentSetupDate;
	}

	public void setEquipmentSetupDate(LocalDateTime equipmentSetupDate) {
		this.equipmentSetupDate = equipmentSetupDate;
	}

	public LocalDateTime getEquipmentUninstallDate() {
		return equipmentUninstallDate;
	}

	public void setEquipmentUninstallDate(
			LocalDateTime equipmentUninstallDate) {
		this.equipmentUninstallDate = equipmentUninstallDate;
	}

	public LocalDateTime getHerdSetupDate() {
		return herdSetupDate;
	}

	public void setHerdSetupDate(LocalDateTime herdSetupDate) {
		this.herdSetupDate = herdSetupDate;
	}

	public LocalDateTime getHerdUninstallDate() {
		return herdUninstallDate;
	}

	public void setHerdUninstallDate(LocalDateTime herdUninstallDate) {
		this.herdUninstallDate = herdUninstallDate;
	}

	public LocalDateTime getPrematureCancellationDate() {
		return prematureCancellationDate;
	}

	public void setPrematureCancellationDate(
			LocalDateTime prematureCancellationDate) {
		this.prematureCancellationDate = prematureCancellationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getRequiredAnimalCount() {
		return requiredAnimalCount;
	}

	public void setRequiredAnimalCount(Integer requiredAnimalCount) {
		this.requiredAnimalCount = requiredAnimalCount;
	}

	public ServiceIBusiness getBusiness() {
		return business;
	}

	public void setBusiness(ServiceIBusiness business) {
		this.business = business;
	}

	public LocalDateTime getRefusalDate() {
		return refusalDate;
	}

	public void setRefusalDate(LocalDateTime refusalDate) {
		this.refusalDate = refusalDate;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDateTime getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(LocalDateTime validationDate) {
		this.validationDate = validationDate;
	}

	public CancellationReason getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(CancellationReason cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public ShearingOffer getOffer() {
		return offer;
	}

	public void setOffer(ShearingOffer offer) {
		this.offer = offer;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PrematureCancellationReason getPrematureCancellationReason() {
		return prematureCancellationReason;
	}

	public void setPrematureCancellationReason(
			PrematureCancellationReason prematureCancellationReason) {
		this.prematureCancellationReason = prematureCancellationReason;
	}

	public RefusalReason getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(RefusalReason refusalReason) {
		this.refusalReason = refusalReason;
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

	public GrassHeight getGrassHeight() {
		return grassHeight;
	}

	public void setGrassHeight(GrassHeight grassHeight) {
		this.grassHeight = grassHeight;
	}

}
