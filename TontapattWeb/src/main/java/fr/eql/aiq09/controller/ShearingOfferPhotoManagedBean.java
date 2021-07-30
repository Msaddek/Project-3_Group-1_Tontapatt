package fr.eql.aiq09.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ShearingOfferPhotoIBusiness;
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

	public ShearingOfferPhoto getShearingOfferPhoto() {
		return shearingOfferPhoto;
	}

	public void setShearingOfferPhoto(ShearingOfferPhoto shearingOfferPhoto) {
		this.shearingOfferPhoto = shearingOfferPhoto;
	}

}
