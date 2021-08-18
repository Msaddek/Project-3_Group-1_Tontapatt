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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "field_withdrawal_reason")
public class FieldWithdrawalReason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "withdrawal_reason", nullable = false)
	private String withdrawalReason;
	@JsonIgnore
	@OneToMany(mappedBy = "fieldWithdrawalReason", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;

	public FieldWithdrawalReason() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(withdrawalReason);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldWithdrawalReason other = (FieldWithdrawalReason) obj;
		return Objects.equals(withdrawalReason, other.withdrawalReason);
	}

	@Override
	public String toString() {
		return "FieldWithdrawalReason [id=" + id
				+ ", withdrawalReason="
				+ withdrawalReason
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWithdrawalReason() {
		return withdrawalReason;
	}

	public void setWithdrawalReason(String withdrawalReason) {
		this.withdrawalReason = withdrawalReason;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

}
