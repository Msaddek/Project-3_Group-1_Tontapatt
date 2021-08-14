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
@Table(name = "fence_height")
public class FenceHeight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "height", nullable = false)
	private String height;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fenceHeight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "favorite_fence_height", joinColumns = @JoinColumn(name = "fence_id"), inverseJoinColumns = @JoinColumn(name = "species_id"))
	private Set<Species> species;

	public FenceHeight() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FenceHeight other = (FenceHeight) obj;
		return Objects.equals(height, other.height);
	}

	@Override
	public String toString() {
		return "FenceHeight [height=" + height + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
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
