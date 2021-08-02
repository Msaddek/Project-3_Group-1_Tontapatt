package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vegetation_type")
public class VegetationType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "vegetation", nullable = false)
	private String vegetation;
	@ManyToMany(mappedBy = "vegetationTypes")
	Set<Field> fields;
	@ManyToMany
	@JoinTable(name = "favorite_vegetation", joinColumns = @JoinColumn(name = "vegetation_type_id"), inverseJoinColumns = @JoinColumn(name = "species_id"))
	private Set<Species> species;

	public VegetationType() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(vegetation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetationType other = (VegetationType) obj;
		return Objects.equals(vegetation, other.vegetation);
	}

	@Override
	public String toString() {
		return "VegetationType [id=" + id + ", vegetation=" + vegetation + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public String getVegetation() {
		return vegetation;
	}

	public void setVegetation(String vegetation) {
		this.vegetation = vegetation;
	}

}
