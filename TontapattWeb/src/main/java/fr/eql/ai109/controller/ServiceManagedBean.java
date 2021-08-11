package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ServiceIBusiness;
import fr.eql.ai109.tontapatt.entity.CancellationReason;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.PaymentMethod;
import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;
import fr.eql.ai109.tontapatt.entity.RefusalReason;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbService")
@SessionScoped
public class ServiceManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ServiceIBusiness business;

	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	@ManagedProperty(value = "#{mbField}")
	private FieldManagedBean selectedFieldBean;

	@ManagedProperty(value = "#{mbShearingOffer}")
	private ShearingOfferManagedBean selectedOfferBean;

	private Service service;

	private Set<Service> connectedBreederServices;

	private Set<Service> connectedOwnerServices;

	private LocalDate startDate;

	private LocalDate endDate;

	private LocalDateTime equipmentSetupDate;

	private LocalDateTime equipmentUninstallDate;

	private LocalDateTime herdSetupDate;

	private LocalDateTime herdUninstallDate;

	private LocalDateTime prematureCancellationDate;

	private Double price;

	private LocalDateTime refusalDate;

	private LocalDateTime requestDate;

	private LocalDateTime validationDate;

	private CancellationReason cancellationReason;

	private Field field;

	private PaymentMethod paymentMethod;

	private PrematureCancellationReason prematureCancellationReason;

	private RefusalReason refusalReason;

	private ShearingOffer shearingOffer;

	@PostConstruct
	public void init() {
		connectedBreederServices = business.getAllByOfferBreeder(connectedUser);
		connectedOwnerServices = business.getAllByFieldOwner(connectedUser);
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

}
