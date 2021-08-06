package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class FavoriteFlatnessId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "flatness_percentage_id")
	private Integer flatnessPercentageId;

	@Column(name = "species_id")
	private Integer speciesId;

	public FavoriteFlatnessId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(flatnessPercentageId, speciesId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteFlatnessId other = (FavoriteFlatnessId) obj;
		return Objects.equals(flatnessPercentageId, other.flatnessPercentageId)
				&& Objects.equals(speciesId, other.speciesId);
	}

	public Integer getFlatnessPercentageId() {
		return flatnessPercentageId;
	}

	public void setFlatnessPercentageId(Integer flatnessPercentageId) {
		this.flatnessPercentageId = flatnessPercentageId;
	}

	public Integer getSpeciesId() {
		return speciesId;
	}

	public void setSpeciesId(Integer speciesId) {
		this.speciesId = speciesId;
	}

	
	
	

}
