package fr.eql.ai109.controller;


import java.io.Serializable;
import java.time.LocalDateTime;
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
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbField")
@SessionScoped
public class FieldManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldIBusiness business;

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


	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	public LocalDateTime getAdditionDate() {
		return additionDate;
	}

	private Set<Field> connectedUserFields;

	@PostConstruct()
	public void init() {
		connectedUserFields = business.findFieldsByUser(connectedUser);
	}
	
	public String createField(){
		 //faire addPhoto.xhtml redirection =false
		Field newField = new Field();

		newField.setName(name);
		newField.setAddress(address);
		newField.setZipCodeCity(zipCodeCity);
		newField.setArea(area);
		newField.setAdditionDate(LocalDateTime.now());
		newField.setGrassHeight(grassHeight);
		newField.setFenceHeight(fenceHeight);
		newField.setFlatnessPercentage(flatnessPercentage);
		//newField.setVegetationCompositions(vegetationCompositions);
		//newField.setPhotos(photos);
		newField.setOwner(connectedUser);
		
		field = business.add(newField);
		
		System.out.println(name+ " " +address+ " " +zipCodeCity+ " " +area+ " "
				+ " " +grassHeight+ " " +fenceHeight+ " " +flatnessPercentage+ " "
				+ " " +connectedUser);

		String forward = "/fieldRegistrationDone.xhtml?faces-redirect=true";
		return forward;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public FieldIBusiness getBusiness() {
		return business;
	}

	public void setBusiness(FieldIBusiness business) {
		this.business = business;
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

}
