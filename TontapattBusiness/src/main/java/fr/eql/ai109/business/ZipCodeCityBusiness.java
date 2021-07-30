package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ZipCodeCityIBusiness;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;
import fr.eql.ai109.tontapatt.idao.ZipCodeCityIDAO;

@Remote(ZipCodeCityIBusiness.class)
@Stateless
public class ZipCodeCityBusiness extends GenericBusiness<ZipCodeCity>
		implements ZipCodeCityIBusiness {

	@EJB
	private ZipCodeCityIDAO zipCodeCityIDAO;

	@Override
	public List<ZipCodeCity> getAllByZipCode(String zipCode) {
		return zipCodeCityIDAO.getAllByZipCode(zipCode);
	}

	/*
	 * public ZipCodeCity calculateDistance() { return
	 * zipCodeCityIDAO.calculateDistance(); }
	 */

}
