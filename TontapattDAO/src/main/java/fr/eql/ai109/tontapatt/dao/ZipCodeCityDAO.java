package fr.eql.ai109.tontapatt.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.ZipCodeCity;
import fr.eql.ai109.tontapatt.idao.ZipCodeCityIDAO;

@Remote(ZipCodeCityIDAO.class)
@Stateless
public class ZipCodeCityDAO extends GenericDAO<ZipCodeCity>
		implements ZipCodeCityIDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ZipCodeCity> getAllByZipCode(String zipCode) {
		List<ZipCodeCity> cities = null;
		try {
			cities = em.createQuery(
					"SELECT c FROM ZipCodeCity c WHERE c.zipCode=:zipCodeParam")
					.setParameter("zipCodeParam", zipCode).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cities;
	}

}
