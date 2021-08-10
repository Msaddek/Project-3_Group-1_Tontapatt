package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FieldPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
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

	@ManagedProperty(value = "#{mbField.field}")
	private Field selectedField;
	private Set<FieldPhoto> selectedFieldPhotos;

	@PostConstruct()
	public void init() {
		selectedFieldPhotos = business.findPhotosByField(selectedField);
	}

	public FieldPhoto getFieldPhoto() {
		return fieldPhoto;
	}

	public void setFieldPhoto(FieldPhoto fieldPhoto) {
		this.fieldPhoto = fieldPhoto;
	}

	public Field getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(Field selectedField) {
		this.selectedField = selectedField;
	}

	public Set<FieldPhoto> getSelectedFieldPhotos() {
		return selectedFieldPhotos;
	}

	public void setSelectedFieldPhotos(Set<FieldPhoto> selectedFieldPhotos) {
		this.selectedFieldPhotos = selectedFieldPhotos;
	}

}
