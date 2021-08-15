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
@Table(name = "zip_code_city")
public class ZipCodeCity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "zip_code", nullable = false)
	private String zipCode;

	@Column(name = "longitude", nullable = false)
	private Double longitude;

	@Column(name = "latitude", nullable = false)
	private Double latitude;

	@JsonIgnore
	@OneToMany(mappedBy = "zipCodeCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users;

	@JsonIgnore
	@OneToMany(mappedBy = "zipCodeCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;

	@JsonIgnore
	@OneToMany(mappedBy = "zipCodeCity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ShearingOffer> shearingOffers;

	public ZipCodeCity() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude, name, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipCodeCity other = (ZipCodeCity) obj;
		return Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude)
				&& Objects.equals(name, other.name)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "ZipCodeCity [id=" + id
				+ ", name="
				+ name
				+ ", zipCode="
				+ zipCode
				+ ", longitude="
				+ longitude
				+ ", latitude="
				+ latitude
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public Set<ShearingOffer> getShearingOffers() {
		return shearingOffers;
	}

	public void setShearingOffers(Set<ShearingOffer> shearingOffers) {
		this.shearingOffers = shearingOffers;
	}

}
