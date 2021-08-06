package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity 
@Table(name="favorite_flatness")
public class FavoriteFlatness implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FavoriteFlatnessId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("flatnessPercentageId")
	private FlatnessPercentage flatnessPercentage;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("speciesId")
	private Species species;

	public FavoriteFlatness() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(flatnessPercentage, id, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteFlatness other = (FavoriteFlatness) obj;
		return Objects.equals(flatnessPercentage, other.flatnessPercentage) && Objects.equals(id, other.id)
				&& Objects.equals(species, other.species);
	}

	public FavoriteFlatnessId getId() {
		return id;
	}

	public void setId(FavoriteFlatnessId id) {
		this.id = id;
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
