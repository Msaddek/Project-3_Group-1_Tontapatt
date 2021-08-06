package fr.eql.ai109.controller;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.tontapatt.entity.FenceHeight;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.entity.FieldWithdrawalReason;
import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;
import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.entity.VegetationComposition;
import fr.eql.ai109.tontapatt.entity.VegetationType;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldIBusiness fieldBusiness;

	private Field field;

	private String name;

	private String address;

	private Integer area;

	private String description;

	private LocalDateTime additionDate;

	private LocalDateTime withdrawalDate;

	private Set<Service> services;

	private Set<FieldPhoto> photos;

	private GrassHeight grassHeight;

	private FieldWithdrawalReason fieldWithdrawalReason;

	private FenceHeight fenceHeight;

	private User owner;

	private ZipCodeCity zipCodeCity;

	private FlatnessPercentage flatnessPercentage;

	private Set<VegetationComposition> vegetationCompositions;
	
	private VegetationComposition  vegetationComposition;
	
	private Integer vegetationPercentage;


	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private Set<Field> connectedUserFields;

	@PostConstruct()
	public void init() {
		connectedUserFields = fieldBusiness.findFieldsByUser(connectedUser);
	}

	public String createField(){
		String forward = "/fieldRegistrationDone.xhtml?faces-redirect=true"; //faire addPhoto.xhtml redirection =false
		System.out.println(forward);
		Field newField = new Field();

		newField.setName(name);
		newField.setAddress(address);
		newField.setArea(area);
		newField.setAdditionDate(LocalDateTime.now());
		newField.setGrassHeight(grassHeight);
		newField.setFenceHeight(fenceHeight);
		newField.setFlatnessPercentage(flatnessPercentage);
		newField.setPhotos(photos);
		newField.setZipCodeCity(zipCodeCity);
		newField.setOwner(connectedUser);
		field = fieldBusiness.add(newField);
		System.out.println("***********" + field.getId());
		for (VegetationComposition vc:vegetationCompositions) {
			vc.setField(field);
		}
		field.setVegetationCompositions(vegetationCompositions);
		field = fieldBusiness.update(field);
		return forward;
	}
	
	public void createVegetationComposition(VegetationType vegetationType) {
		
		vegetationComposition = new VegetationComposition();
		vegetationCompositions = new HashSet<>();
		System.out.println(vegetationType.getVegetation());
		System.out.println(vegetationPercentage);
		vegetationComposition.setPercentage(vegetationPercentage);
		vegetationComposition.setVegetationType(vegetationType);
		vegetationCompositions.add(vegetationComposition);
		
	}


	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public FieldIBusiness getBusiness() {
		return fieldBusiness;
	}

	public void setBusiness(FieldIBusiness business) {
		this.fieldBusiness = business;
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

	public ZipCodeCity getCity() {
		return zipCodeCity;
	}

	public void setCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
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

	public Set<FieldPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<FieldPhoto> photos) {
		this.photos = photos;
	}

	public GrassHeight getGrassHeight() {
		return grassHeight;
	}

	public void setGrassHeight(GrassHeight grassHeight) {
		this.grassHeight = grassHeight;
	}

	public FenceHeight getFenceHeight() {
		return fenceHeight;
	}

	public void setFenceHeight(FenceHeight fenceHeight) {
		this.fenceHeight = fenceHeight;
	}

	public FlatnessPercentage getFlatnessPercentage() {
		return flatnessPercentage;
	}

	public void setFlatnessPercentage(FlatnessPercentage flatnessPercentage) {
		this.flatnessPercentage = flatnessPercentage;
	}

	public Set<VegetationComposition> getVegetationCompositions() {
		return vegetationCompositions;
	}

	public void setVegetationCompositions(
			Set<VegetationComposition> vegetationCompositions) {
		this.vegetationCompositions = vegetationCompositions;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public Set<Field> getConnectedUserFields() {
		return connectedUserFields;
	}

	public void setConnectedUserFields(Set<Field> connectedUserFields) {
		this.connectedUserFields = connectedUserFields;
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

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public FieldWithdrawalReason getFieldWithdrawalReason() {
		return fieldWithdrawalReason;
	}

	public void setFieldWithdrawalReason(FieldWithdrawalReason fieldWithdrawalReason) {
		this.fieldWithdrawalReason = fieldWithdrawalReason;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ZipCodeCity getZipCodeCity() {
		return zipCodeCity;
	}

	public void setZipCodeCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
	}

	public VegetationComposition getVegetationComposition() {
		return vegetationComposition;
	}

	public void setVegetationComposition(VegetationComposition vegetationComposition) {
		this.vegetationComposition = vegetationComposition;
	}

	public Integer getVegetationPercentage() {
		return vegetationPercentage;
	}

	public void setVegetationPercentage(Integer vegetationPercentage) {
		this.vegetationPercentage = vegetationPercentage;
	}


}
