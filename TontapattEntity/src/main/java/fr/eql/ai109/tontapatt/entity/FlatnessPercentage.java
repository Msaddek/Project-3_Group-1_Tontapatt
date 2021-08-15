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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flatness_percentage")
public class FlatnessPercentage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "percentage", nullable = false)
	private Integer percentage;
	
	@JsonIgnore
	@OneToMany(mappedBy = "flatnessPercentage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "favorite_flatness", joinColumns = @JoinColumn(name = "flatness_percentage_id"), inverseJoinColumns = @JoinColumn(name = "species_id"))
	private Set<Species> species;

	public FlatnessPercentage() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(percentage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlatnessPercentage other = (FlatnessPercentage) obj;
		return Objects.equals(percentage, other.percentage);
	}

	@Override
	public String toString() {
		return "FlatnessPercentage [id=" + id
				+ ", percentage="
				+ percentage
				+ ", species="
				+ species
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Set<Species> getSpecies() {
		return species;
	}

	public void setSpecies(Set<Species> species) {
		this.species = species;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

}
