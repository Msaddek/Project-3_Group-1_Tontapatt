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
public class ZipCodeCityBusiness implements ZipCodeCityIBusiness {

	@EJB
	private ZipCodeCityIDAO zipCodeCityIDAO;

	@Override
	public List<ZipCodeCity> getAllByZipCode(String zipCode) {
		return zipCodeCityIDAO.getAllByZipCode(zipCode);
	}

	@Override
	public ZipCodeCity add(ZipCodeCity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ZipCodeCity t) {
		// TODO Auto-generated method stub

	}

	@Override
	public ZipCodeCity update(ZipCodeCity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZipCodeCity getById(int i) {
		return zipCodeCityIDAO.getById(i);
	}

	@Override
	public List<ZipCodeCity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public ZipCodeCity calculateDistance() { return
	 * zipCodeCityIDAO.calculateDistance(); }
	 */

}
