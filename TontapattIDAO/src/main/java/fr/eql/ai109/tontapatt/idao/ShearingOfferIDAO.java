package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

public interface ShearingOfferIDAO extends GenericIDAO<ShearingOffer> {
	
	Set<ShearingOffer> findShearingOffersByUser(User user);
	
}
