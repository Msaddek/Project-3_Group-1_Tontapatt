package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.SpeciesIBusiness;
import fr.eql.ai109.tontapatt.entity.Species;

@ManagedBean(name = "mbSpecies")
@ViewScoped
public class SpeciesManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	SpeciesIBusiness business;
	
	private Species species;
	
	private List<Species> speciesList;

	public List<Species> allSpecies(){
		speciesList = business.getAll();
		return speciesList;
	}
	
	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public List<Species> getSpeciesList() {
		return speciesList;
	}

	public void setSpeciesList(List<Species> speciesList) {
		this.speciesList = speciesList;
	}

}
