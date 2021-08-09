package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.VegetationCompositionIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.entity.VegetationType;

@ManagedBean(name = "mbVegetationComposition")
@SessionScoped
public class VegetationCompositionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	VegetationCompositionIBusiness vegetationCompositionBusiness;
	
	private VegetationComposition vegetationComposition;
	private Field field;
	private VegetationType vegetationType;
	private Integer percentage;
	private Set<VegetationComposition> vegetationCompositions;
	

	
	
	public VegetationComposition getVegetationComposition() {
		return vegetationComposition;
	}
	public void setVegetationComposition(VegetationComposition vegetationComposition) {
		this.vegetationComposition = vegetationComposition;
	}

	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public VegetationType getVegetationType() {
		return vegetationType;
	}
	public void setVegetationType(VegetationType vegetationType) {
		this.vegetationType = vegetationType;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}


	public Set<VegetationComposition> getVegetationCompositions() {
		return vegetationCompositions;
	}


	public void setVegetationCompositions(Set<VegetationComposition> vegetationCompositions) {
		this.vegetationCompositions = vegetationCompositions;
	}
	
	
}
