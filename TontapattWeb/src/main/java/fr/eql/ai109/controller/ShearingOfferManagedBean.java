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
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbShearingOffer")
@SessionScoped
public class ShearingOfferManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShearingOfferIBusiness business;
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private Set<ShearingOffer> connectedUserOffers;

	private Set<ShearingOffer> connectedUserExpiredOffers;

	private Set<ShearingOffer> connectedUserInProgress;

	private ShearingOffer shearingOffer;
	
	private String address;
	
	private Integer animalCount;
	
	private Double animalDailyPrice;
	
	private LocalDateTime creationDate;
	
	private String description;
	
	private LocalDateTime endDate;
	
	private Integer maxTravelDistance;
	
	private String name;
	
	private LocalDateTime startDate;
	
	private Race race;
	
	private ZipCodeCity city;

	@PostConstruct
	public void init() {
		connectedUserOffers = business
				.getShearingOffersOfConnectedUser(connectedUser);
		connectedUserExpiredOffers = business
				.getExpiredShearingOffersOfConnectedUser(connectedUser);
		connectedUserInProgress = business
				.getInProgressShearingOffersOfConnectedUser(connectedUser);
	}
	
	public String createOffer() {
		shearingOffer.setCreationDate(LocalDateTime.now());
		shearingOffer.setAddress(address);
		shearingOffer.setAnimalCount(animalCount);
		shearingOffer.setAnimalDailyPrice(animalDailyPrice);
		shearingOffer.setDescription(description);
		shearingOffer.setEndDate(endDate);
		shearingOffer.setMaxTravelDist(maxTravelDistance);
		shearingOffer.setName(name);
		shearingOffer.setStartDate(startDate);
		shearingOffer.setBreeder(connectedUser);
		shearingOffer.setRace(race);
		shearingOffer.setZipCodeCity(city);
		shearingOffer = business.add(shearingOffer);
		return "/shearingOfferCreationDone.xhtml?faces-redirect=true";
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public Set<ShearingOffer> getConnectedUserOffers() {
		return connectedUserOffers;
	}

	public void setConnectedUserOffers(Set<ShearingOffer> connectedUserOffers) {
		this.connectedUserOffers = connectedUserOffers;
	}

	public Set<ShearingOffer> getConnectedUserExpiredOffers() {
		return connectedUserExpiredOffers;
	}

	public void setConnectedUserExpiredOffers(
			Set<ShearingOffer> connectedUserExpiredOffers) {
		this.connectedUserExpiredOffers = connectedUserExpiredOffers;
	}

	public Set<ShearingOffer> getConnectedUserInProgress() {
		return connectedUserInProgress;
	}

	public void setConnectedUserInProgress(
			Set<ShearingOffer> connectedUserInProgress) {
		this.connectedUserInProgress = connectedUserInProgress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(Integer animalCount) {
		this.animalCount = animalCount;
	}

	public Double getAnimalDailyPrice() {
		return animalDailyPrice;
	}

	public void setAnimalDailyPrice(Double animalDailyPrice) {
		this.animalDailyPrice = animalDailyPrice;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getMaxTravelDistance() {
		return maxTravelDistance;
	}

	public void setMaxTravelDistance(Integer maxTravelDistance) {
		this.maxTravelDistance = maxTravelDistance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public ZipCodeCity getCity() {
		return city;
	}

	public void setCity(ZipCodeCity city) {
		this.city = city;
	}

}
