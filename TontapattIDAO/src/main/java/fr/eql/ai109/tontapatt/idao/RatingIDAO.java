package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

public interface RatingIDAO extends GenericIDAO<Rating> {

	Set<Rating> getAllBySearingOffer(ShearingOffer selectedOffer, User connectedUser);
	
}
