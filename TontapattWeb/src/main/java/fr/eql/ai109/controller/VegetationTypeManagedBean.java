package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.VegetationTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.VegetationType;

@ManagedBean(name = "mbVegetationType")
@SessionScoped
public class VegetationTypeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	VegetationTypeIBusiness business;
	private VegetationType vegetationType;

	public VegetationType getVegetationType() {
		return vegetationType;
	}

	public void setVegetationType(VegetationType vegetationType) {
		this.vegetationType = vegetationType;
	}

}
