package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ZipCodeCityIBusiness;
import fr.eql.ai109.tontapatt.idao.ZipCodeCityIDAO;

@Remote(ZipCodeCityIBusiness.class)
@Stateless
public class ZipCodeCityBusiness implements ZipCodeCityIBusiness {

	@EJB
	private ZipCodeCityIDAO zipCodeCityIDAO;
	
	/*
	 * public ZipCodeCity calculateDistance() { return
	 * zipCodeCityIDAO.calculateDistance(); }
	 */

}
