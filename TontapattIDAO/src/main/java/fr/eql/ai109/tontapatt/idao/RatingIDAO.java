package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;

public interface RatingIDAO extends GenericIDAO<Rating> {

	Set<Rating> getAllByShearingOffer(ShearingOffer selectedOffer);

	Set<Rating> getAllByField(Field selectedField);

	Set<Rating> getAllbyService(Service selectedService);
	
}
