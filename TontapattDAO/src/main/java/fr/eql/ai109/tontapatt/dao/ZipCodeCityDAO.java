package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.ZipCodeCity;
import fr.eql.ai109.tontapatt.idao.ZipCodeCityIDAO;

@Remote(ZipCodeCityIDAO.class)
@Stateless
public class ZipCodeCityDAO extends GenericDAO<ZipCodeCity>
		implements ZipCodeCityIDAO {

	/*
	 * public ZipCodeCity calculateDistance() { ZipCodeCity distance = null; try
	 * { System.out.println(em); System.out.println("ok");
	 * 
	 * String sqlString = "SELECT id, name, zip_code, latitude, longitude, " +
	 * "CalcDistance(41.9714498244, 9.24775602009, 42.3941662475, " +
	 * "9.37311777417) AS distance FROM zip_code_city WHERE id=1";
	 * 
	 * distance = (ZipCodeCity) em .createNativeQuery(sqlString,
	 * ZipCodeCity.class) .getSingleResult(); System.out
	 * .println(distance.getName()); System.out.println("ok"); } catch
	 * (Exception e) { e.printStackTrace(); } System.out.println(em); return
	 * distance; }
	 */
}
