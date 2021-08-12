package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbRating")
@SessionScoped
public class RatingManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RatingIBusiness business;
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private Rating rating;

	private Set<Rating> shearingOfferRatings;

	private Set<Rating> fieldRatings;

	public void recoverAllShearingOfferRatings(ShearingOffer selectedOffer) {
		shearingOfferRatings = business.getAllBySearingOffer(selectedOffer, connectedUser);
	}
	
	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Set<Rating> getShearingOfferRatings() {
		return shearingOfferRatings;
	}

	public void setShearingOfferRatings(Set<Rating> shearingOfferRatings) {
		this.shearingOfferRatings = shearingOfferRatings;
	}

	public Set<Rating> getFieldRatings() {
		return fieldRatings;
	}

	public void setFieldRatings(Set<Rating> fieldRatings) {
		this.fieldRatings = fieldRatings;
	}

}
