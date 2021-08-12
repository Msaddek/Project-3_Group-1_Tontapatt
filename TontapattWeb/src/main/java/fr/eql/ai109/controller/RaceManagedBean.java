package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.RaceIBusiness;
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.Species;

@ManagedBean(name = "mbRace")
@ViewScoped
public class RaceManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RaceIBusiness business;
	
	@ManagedProperty(value = "#{mbShearingOffer.shearingOffer}")
	private ShearingOffer selectedShearingOffer;
	
	private Race race;

	private Set<Race> races;

	private Species species;
	
	public void onSpeciesChange() {
		races = business.getRacesBySpecies(species);
	}
	
	public void initRaceParamForOfferCreation() {
		species = null;
	}
	
	public void initRaceParamForOfferModification() {
		species = selectedShearingOffer.getRace().getSpecies();
		race = selectedShearingOffer.getRace();
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Set<Race> getRaces() {
		return races;
	}

	public void setRaces(Set<Race> races) {
		this.races = races;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public ShearingOffer getSelectedShearingOffer() {
		return selectedShearingOffer;
	}

	public void setSelectedShearingOffer(ShearingOffer selectedShearingOffer) {
		this.selectedShearingOffer = selectedShearingOffer;
	}

}
