package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
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
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private Set<ShearingOffer> connectedUserOffers;

	private Set<ShearingOffer> connectedUserExpiredOffers;

	private Set<ShearingOffer> connectedUserInProgress;

	private ShearingOffer shearingOffer;
	
	

	@PostConstruct
	public void init() {
		connectedUserOffers = business
				.getShearingOffersOfConnectedUser(connectedUser);
		connectedUserExpiredOffers = business
				.getExpiredShearingOffersOfConnectedUser(connectedUser);
		connectedUserInProgress = business
				.getInProgressShearingOffersOfConnectedUser(connectedUser);
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

}
