package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vegetation_composition")
public class VegetationComposition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Field field;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private VegetationType vegetationType;

	@Column(name = "percentage", nullable = false)
	private Integer percentage;

	public VegetationComposition() {
		super();
	}

	public VegetationComposition(Field field, VegetationType vegetationType) {
		super();
		this.field = field;
		this.vegetationType = vegetationType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(field, percentage, vegetationType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetationComposition other = (VegetationComposition) obj;
		return Objects.equals(field, other.field)
				&& Objects.equals(percentage, other.percentage)
				&& Objects.equals(vegetationType, other.vegetationType);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public VegetationType getVegetationType() {
		return vegetationType;
	}

	public void setVegetationType(VegetationType vegetationType) {
		this.vegetationType = vegetationType;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

}
