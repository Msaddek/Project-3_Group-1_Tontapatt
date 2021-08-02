package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FieldPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;

@ManagedBean(name = "mbFieldPhoto")
@SessionScoped
public class FieldPhotoManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldPhotoIBusiness business;
	private FieldPhoto fieldPhoto;

	public FieldPhoto getFieldPhoto() {
		return fieldPhoto;
	}

	public void setFieldPhoto(FieldPhoto fieldPhoto) {
		this.fieldPhoto = fieldPhoto;
	}

}
