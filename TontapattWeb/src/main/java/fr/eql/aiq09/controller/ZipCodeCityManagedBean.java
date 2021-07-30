package fr.eql.aiq09.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.ZipCodeCityIBusiness;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbZipCodeCity")
@SessionScoped
public class ZipCodeCityManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private Double distance;
	private ZipCodeCity city;

	@EJB
	ZipCodeCityIBusiness business;

	/*
	 * public ZipCodeCity calculateDistance() { city =
	 * business.calculateDistance(); System.out.println(city);
	 * return city; }
	 */
	public ZipCodeCity getCity() {
		return city;
	}

	public void setCity(ZipCodeCity city) {
		this.city = city;
	}

}
