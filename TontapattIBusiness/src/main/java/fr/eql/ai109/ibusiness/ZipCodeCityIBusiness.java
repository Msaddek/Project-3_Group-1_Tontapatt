package fr.eql.ai109.ibusiness;

import java.util.List;

import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

public interface ZipCodeCityIBusiness extends GenericIBusiness<ZipCodeCity> {
	
	List<ZipCodeCity> getAllByZipCode(String zipCode);

}
