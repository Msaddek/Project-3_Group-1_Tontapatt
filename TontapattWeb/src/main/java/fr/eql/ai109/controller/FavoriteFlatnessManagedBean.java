package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FavoriteFlatnessIBusiness;
import fr.eql.ai109.tontapatt.entity.FavoriteFlatness;
import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;
import fr.eql.ai109.tontapatt.entity.Species;

@ManagedBean(name = "mbFavoriteFlatness")
@SessionScoped
public class FavoriteFlatnessManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FavoriteFlatnessIBusiness business;

	private FavoriteFlatness favoriteFlatness;
	private FlatnessPercentage flatnessPercentage;
	private Species species;

	public FavoriteFlatness getFavoriteFlatness() {
		return favoriteFlatness;
	}

	public void setFavoriteFlatness(FavoriteFlatness favoriteFlatness) {
		this.favoriteFlatness = favoriteFlatness;
	}

	public FlatnessPercentage getFlatnessPercentage() {
		return flatnessPercentage;
	}

	public void setFlatnessPercentage(FlatnessPercentage flatnessPercentage) {
		this.flatnessPercentage = flatnessPercentage;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

}
