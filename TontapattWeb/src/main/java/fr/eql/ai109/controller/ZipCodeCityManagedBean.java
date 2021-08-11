package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.ZipCodeCityIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbZipCodeCity")
@ViewScoped
public class ZipCodeCityManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private Double distance;
	private ZipCodeCity city;
	private List<ZipCodeCity> cities;
	private String zipCode;

	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;
	
	@ManagedProperty(value = "#{mbShearingOffer.shearingOffer}")
	private ShearingOffer selectedShearingOffer;
	
	@ManagedProperty(value = "#{mbField.field}")
	private Field selectedField;

	@EJB
	ZipCodeCityIBusiness business;

	public void initCityOfConnectedUser() {
		city = connectedUser.getZipCodeCity();
		zipCode = city.getZipCode();
	}
	
	public void initCityOfSelectedOffer() {
		System.out.println(selectedShearingOffer.getId());
		city = selectedShearingOffer.getZipCodeCity();
		zipCode = city.getZipCode();
	}
	
	public void initCityForOfferCreation() {
		city = null;
		zipCode = null;
	}
	
	public void initCityOfSelectedField() {
		System.out.println(selectedField.getId());
		city = selectedField.getZipCodeCity();
		zipCode = city.getZipCode();
	}
	
	public void initCityForFieldCreation() {
		city = null;
		zipCode = null;
	}

	public void onZipCodeChange() {
		if (zipCode != null && !zipCode.equals("")) {
			cities = business.getAllByZipCode(zipCode);
		} else {
			cities = new ArrayList<>();
		}
		for (ZipCodeCity zipCodeCity : cities) {
			System.out.println(zipCodeCity.getName());
		}
	}

	/*
	 * public ZipCodeCity calculateDistance() { city =
	 * business.calculateDistance(); System.out.println(city); return city; }
	 */
	public ZipCodeCity getCity() {
		return city;
	}

	public void setCity(ZipCodeCity city) {
		this.city = city;
	}

	public List<ZipCodeCity> getCities() {
		return cities;
	}

	public void setCities(List<ZipCodeCity> cities) {
		this.cities = cities;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public ShearingOffer getSelectedShearingOffer() {
		return selectedShearingOffer;
	}

	public void setSelectedShearingOffer(ShearingOffer selectedShearingOffer) {
		this.selectedShearingOffer = selectedShearingOffer;
	}

	public Field getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(Field selectedField) {
		this.selectedField = selectedField;
	}

	
}
