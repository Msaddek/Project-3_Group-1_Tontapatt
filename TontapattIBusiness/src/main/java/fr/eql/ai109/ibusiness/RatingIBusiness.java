package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Rating;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

public interface RatingIBusiness extends GenericIBusiness<Rating> {

	Set<Rating> getAllBySearingOffer(ShearingOffer selectedOffer, User connectedUser);

}
