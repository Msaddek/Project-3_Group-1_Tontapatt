package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "field")
public class Field implements Serializable {

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
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "area", nullable = false)
	private Integer area;
	@Column(name = "description", nullable = true)
	private String description;
	@Column(name = "addition_date", nullable = false)
	private LocalDateTime additionDate;
	@Column(name = "withdrawal_date", nullable = true)
	private LocalDateTime withdrawalDate;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private GrassHeight grassHeight;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private FieldWithdrawalReason fieldWithdrawalReason;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private FenceHeight fenceHeight;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private ZipCodeCity zipCodeCity;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private FlatnessPercentage flatnessPercentage;
	@ManyToMany
	@JoinTable(name = "vegetation_composition", joinColumns = @JoinColumn(name = "field_id"), inverseJoinColumns = @JoinColumn(name = "vegetation_type_id"))
	private Set<VegetationType> vegetationTypes;
	@OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Service> services;
	@OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Photo> photos;

	public Field() {
		super();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate(LocalDateTime additionDate) {
		this.additionDate = additionDate;
	}

	public LocalDateTime getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(LocalDateTime withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public GrassHeight getGrassHeight() {
		return grassHeight;
	}

	public void setGrassHeight(GrassHeight grassHeight) {
		this.grassHeight = grassHeight;
	}

	public FieldWithdrawalReason getFieldWithdrawalReason() {
		return fieldWithdrawalReason;
	}

	public void setFieldWithdrawalReason(
			FieldWithdrawalReason fieldWithdrawalReason) {
		this.fieldWithdrawalReason = fieldWithdrawalReason;
	}

	public FenceHeight getFenceHeight() {
		return fenceHeight;
	}

	public void setFenceHeight(FenceHeight fenceHeight) {
		this.fenceHeight = fenceHeight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ZipCodeCity getZipCodeCity() {
		return zipCodeCity;
	}

	public void setZipCodeCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
	}

	public FlatnessPercentage getFlatnessPercentage() {
		return flatnessPercentage;
	}

	public void setFlatnessPercentage(FlatnessPercentage flatnessPercentage) {
		this.flatnessPercentage = flatnessPercentage;
	}

	public Set<VegetationType> getVegetationTypes() {
		return vegetationTypes;
	}

	public void setVegetationTypes(Set<VegetationType> vegetationTypes) {
		this.vegetationTypes = vegetationTypes;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}
