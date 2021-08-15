package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.eql.ai109.ibusiness.FieldIBusiness;
import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;

@ManagedBean(name = "mbHomePage")
@SessionScoped
public class HomePageManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShearingOfferIBusiness offerbusiness;
	
	@EJB
	FieldIBusiness fieldbusiness;
	
	public String allShearingOffersAsJson(){
		Set<ShearingOffer> offers = offerbusiness.getAllWithPhotos();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(offers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String allFieldsAsJson(){
		Set<Field> offers = fieldbusiness.getAllWithPhotos();
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(offers);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}