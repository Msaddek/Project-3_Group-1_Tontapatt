package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.SpeciesIBusiness;
import fr.eql.ai109.tontapatt.entity.Species;

@ManagedBean(name = "mbSpecies")
@SessionScoped
public class SpeciesManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	SpeciesIBusiness business;
	private Species species;

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

}
