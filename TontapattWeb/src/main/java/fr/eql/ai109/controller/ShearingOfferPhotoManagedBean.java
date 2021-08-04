package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ShearingOfferPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;

@ManagedBean(name = "mbShearingOfferPhoto")
@SessionScoped
public class ShearingOfferPhotoManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShearingOfferPhotoIBusiness business;
	private ShearingOfferPhoto shearingOfferPhoto;
	
//	public Set<ShearingOfferPhoto> fetchOfferPhotos(){
//		return business.findPhotosByOffer(shearingOffer);
//	}
//	
//	@ManagedProperty(value = "#{mbShearingOffer}")
//	private ShearingOffer shearingOffer;
//	private Set<ShearingOfferPhoto> offerPhotos;
//	
//	@PostConstruct()
//	public void init() {
//		offerPhotos = business.findPhotosByOffer(shearingOffer);
//	}

	public ShearingOfferPhoto getShearingOfferPhoto() {
		return shearingOfferPhoto;
	}

	public void setShearingOfferPhoto(ShearingOfferPhoto shearingOfferPhoto) {
		this.shearingOfferPhoto = shearingOfferPhoto;
	}

//	public ShearingOffer getShearingOffer() {
//		return shearingOffer;
//	}
//
//	public void setShearingOffer(ShearingOffer shearingOffer) {
//		this.shearingOffer = shearingOffer;
//	}
//
//	public Set<ShearingOfferPhoto> getOfferPhotos() {
//		return offerPhotos;
//	}
//
//	public void setOfferPhotos(Set<ShearingOfferPhoto> offerPhotos) {
//		this.offerPhotos = offerPhotos;
//	}
	
	

}
