package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.VegetationTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.VegetationComposition;
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
	
	private List<VegetationType> vegetationTypes;
	
	private Set<VegetationComposition> vegetationCompositions;
	
	public Set<VegetationComposition> allVegetationCompositions(){
		vegetationTypes = business.getAll();
		vegetationCompositions = new HashSet<>();
		
		for (VegetationType vt : vegetationTypes) {
			VegetationComposition vc = new VegetationComposition();
			vc.setVegetationType(vt);
			vegetationCompositions.add(vc);
		}
		return vegetationCompositions;
	}
	
	public List<VegetationType> allVegetationType() {
		return business.getAll();
	}

	public List<VegetationType> getVegetationType() {
		return vegetationTypes;
	}

	public void setVegetationType(List<VegetationType> vegetationTypes) {
		this.vegetationTypes = vegetationTypes;
	}

	public Set<VegetationComposition> getVegetationCompositions() {
		return vegetationCompositions;
	}

	public void setVegetationCompositions(
			Set<VegetationComposition> vegetationCompositions) {
		this.vegetationCompositions = vegetationCompositions;
	}

}
