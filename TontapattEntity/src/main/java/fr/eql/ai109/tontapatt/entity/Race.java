package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "race")
public class Race implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "race", nullable = false)
	private String race;
	
	@JsonIgnore
	@OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ShearingOffer> shearingOffers;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Species species;

	public Race() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(race);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		return Objects.equals(race, other.race);
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", race=" + race + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Set<ShearingOffer> getShearingOffers() {
		return shearingOffers;
	}

	public void setShearingOffers(Set<ShearingOffer> shearingOffers) {
		this.shearingOffers = shearingOffers;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

}
