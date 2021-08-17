package fr.eql.ai109.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.Service;
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

	public String feedback;

	private LocalDateTime rating_date;

	private Integer ratingLevel;

	private Service selectedService;

	public String rateService() {
		String forward = "/selectedService.xhtml?faces-redirect=true";
		Rating newRating = new Rating();
		newRating.setFeedback(feedback);
		newRating.setEvaluator(connectedUser);
		newRating.setService(selectedService);
		newRating.setRatingLevel(ratingLevel);
		newRating.setRatingDate(LocalDateTime.now());
		rating = business.add(newRating);
		return forward;
	}

	public Set<Rating> allRatingsByService() {
		return business.getAllbyService(selectedService);
	}

	public Set<Rating> recoverAllShearingOfferRatings(
			ShearingOffer selectedOffer) {
		return shearingOfferRatings = business
				.getAllByShearingOffer(selectedOffer);
	}
	
	public String ratingOfShearingOffer(ShearingOffer selectedOffer) {
		Double offerRating = 0.0;
		shearingOfferRatings = recoverAllShearingOfferRatings(selectedOffer);
		for (Rating r : shearingOfferRatings) {
			offerRating += r.getRatingLevel();
		}
		offerRating = offerRating / shearingOfferRatings.size();
		DecimalFormat df = new DecimalFormat("#.#");
		
		return ((offerRating).isNaN() ? "0" : df.format(offerRating));
	}
	public Set<Rating> recoverAllFieldRatings(Field selectedField) {
		return fieldRatings = business.getAllByField(selectedField);
	}
	
	public String ratingOfField(Field selectedField) {
		Double fieldRating = 0.0;
		fieldRatings = recoverAllFieldRatings(selectedField);
		for (Rating r : shearingOfferRatings) {
			fieldRating += r.getRatingLevel();
		}
		fieldRating = fieldRating / fieldRatings.size();
		DecimalFormat df = new DecimalFormat("#.#");
		return df.format(fieldRating).toString();
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

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getRating_date() {
		return rating_date;
	}

	public void setRating_date(LocalDateTime rating_date) {
		this.rating_date = rating_date;
	}

	public Integer getRatingLevel() {
		return ratingLevel;
	}

	public void setRatingLevel(Integer ratingLevel) {
		this.ratingLevel = ratingLevel;
	}

	public Service getSelectedService() {
		return selectedService;
	}

	public void setSelectedService(Service selectedService) {
		this.selectedService = selectedService;
	}

}
