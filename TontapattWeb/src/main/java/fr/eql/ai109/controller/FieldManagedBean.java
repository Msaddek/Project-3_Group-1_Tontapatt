package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldIBusiness business;
	private Field field;

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

}
