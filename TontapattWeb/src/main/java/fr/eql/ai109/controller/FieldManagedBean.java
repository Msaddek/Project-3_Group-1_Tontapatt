package fr.eql.ai109.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.tontapatt.entity.FenceHeight;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;
import fr.eql.ai109.tontapatt.entity.FieldWithdrawalReason;
import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;
import fr.eql.ai109.tontapatt.entity.GrassHeight;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;
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

	private Set<VegetationType> vegetationTypes;


	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	private Set<Field> connectedUserFields;

	@PostConstruct()
	public void init() {
		connectedUserFields = business.findFieldsByUser(connectedUser);
	}
	
	public String createField(){
		String forward = "/fieldRegistrationDone.xhtml?faces-redirection=true"; //faire addPhoto.xhtml redirection =false
		Field newField = new Field();

		newField.setName(name);
		newField.setAddress(address);
		newField.setZipCodeCity(zipCodeCity);
		newField.setArea(area);
		newField.setAdditionDate(LocalDateTime.now());
		newField.setWithdrawalDate(LocalDateTime.now());
		newField.setGrassHeight(grassHeight);
		newField.setFenceHeight(fenceHeight);
		newField.setFlatnessPercentage(flatnessPercentage);
		newField.setVegetationTypes(vegetationTypes);
		newField.setPhotos(photos);
		
		field = business.add(newField);

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

	public Set<VegetationType> getVegetationTypes() {
		return vegetationTypes;
	}

	public void setVegetationTypes(Set<VegetationType> vegetationTypes) {
		this.vegetationTypes = vegetationTypes;
	}




}
