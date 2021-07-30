package fr.eql.ai109.tontapatt.idao;

import java.util.List;

import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

public interface ZipCodeCityIDAO extends GenericIDAO<ZipCodeCity> {
	
	List<ZipCodeCity> getAllByZipCode(String zipCode);
	
}
