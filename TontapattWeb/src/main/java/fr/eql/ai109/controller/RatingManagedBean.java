package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.RatingIBusiness;
import fr.eql.ai109.tontapatt.entity.Rating;

@ManagedBean(name = "mbRating")
@SessionScoped
public class RatingManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RatingIBusiness business;
	private Rating rating;

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
