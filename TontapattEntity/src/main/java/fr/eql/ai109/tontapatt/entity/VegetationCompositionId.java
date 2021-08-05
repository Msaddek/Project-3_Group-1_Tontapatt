package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VegetationCompositionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "field_id")
	private Integer fieldId;

	@Column(name = "vegetation_type_id")
	private Integer vegetationTypeId;

	public VegetationCompositionId() {
		super();
	}

	public VegetationCompositionId(Integer fieldId, Integer vegetationTypeId) {
		super();
		this.fieldId = fieldId;
		this.vegetationTypeId = vegetationTypeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fieldId, vegetationTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VegetationCompositionId other = (VegetationCompositionId) obj;
		return Objects.equals(fieldId, other.fieldId)
				&& Objects.equals(vegetationTypeId, other.vegetationTypeId);
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public Integer getVegetationTypeId() {
		return vegetationTypeId;
	}

	public void setVegetationTypeId(Integer vegetationTypeId) {
		this.vegetationTypeId = vegetationTypeId;
	}

}
