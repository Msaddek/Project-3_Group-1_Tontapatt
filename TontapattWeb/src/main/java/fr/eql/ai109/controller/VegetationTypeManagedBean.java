package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
	
	private Set<VegetationType> vegetationTypes;
	
	public List<VegetationType> allVegetationType() {
		return business.getAll();
	}

	public Set<VegetationType> getVegetationType() {
		return vegetationTypes;
	}

	public void setVegetationType(Set<VegetationType> vegetationTypes) {
		this.vegetationTypes = vegetationTypes;
	}

}
