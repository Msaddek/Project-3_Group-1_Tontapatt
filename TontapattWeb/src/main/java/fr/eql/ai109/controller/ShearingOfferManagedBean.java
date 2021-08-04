package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.OfferWithdrawalReason;
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbShearingOffer")
@SessionScoped
public class ShearingOfferManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShearingOfferIBusiness business;
	private ShearingOffer shearingOffer;
	
	private String name;
	
	private String address;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private String description;
	
	private Integer animalCount;
	
	private Integer maxTravelDist;
	
	private Double animalDailyPrice;
	
	private LocalDateTime withdrawalDate;
	
	private Double distance;
	
	private OfferWithdrawalReason offerWithdrawalReason;
	
	private Race race;
	
	private ZipCodeCity zipCodeCity;
	
//	public Set<ShearingOffer> fetchUserOffers(){
//		return business.findOffersByUser(connectedUser);
//	}
//	
//	@ManagedProperty(value = "#{mbUser}")
//	private User connectedUser;
//	private Set<ShearingOffer> offers;
//	
//	@PostConstruct()
//	public void init() {
//		offers = business.findOffersByUser(connectedUser);
//	}
	
	public String createShearingOffer () {
		String forward;
		
		ShearingOffer newOffer = new ShearingOffer();
		
		newOffer.setName(name);
		newOffer.setAddress(address);
		newOffer.setCreationDate(LocalDateTime.now());
		newOffer.setDescription(description);
		newOffer.setAnimalCount(animalCount);
		newOffer.setMaxTravelDist(maxTravelDist);
		newOffer.setStartDate(startDate);
		newOffer.setEndDate(endDate);
		newOffer.setRace(race);
		
		
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(Integer animalCount) {
		this.animalCount = animalCount;
	}

	public Integer getMaxTravelDist() {
		return maxTravelDist;
	}

	public void setMaxTravelDist(Integer maxTravelDist) {
		this.maxTravelDist = maxTravelDist;
	}

	public Double getAnimalDailyPrice() {
		return animalDailyPrice;
	}

	public void setAnimalDailyPrice(Double animalDailyPrice) {
		this.animalDailyPrice = animalDailyPrice;
	}

	public LocalDateTime getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(LocalDateTime withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public OfferWithdrawalReason getOfferWithdrawalReason() {
		return offerWithdrawalReason;
	}

	public void setOfferWithdrawalReason(OfferWithdrawalReason offerWithdrawalReason) {
		this.offerWithdrawalReason = offerWithdrawalReason;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public ZipCodeCity getZipCodeCity() {
		return zipCodeCity;
	}

	public void setZipCodeCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
	}

//	public User getConnectedUser() {
//		return connectedUser;
//	}
//
//	public void setConnectedUser(User connectedUser) {
//		this.connectedUser = connectedUser;
//	}
//
//	public Set<ShearingOffer> getOffers() {
//		return offers;
//	}
//
//	public void setOffers(Set<ShearingOffer> offers) {
//		this.offers = offers;
//	}

	
}
