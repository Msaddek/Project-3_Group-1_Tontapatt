package fr.eql.ai109.tontapatt.idao;

import java.util.List;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;

public interface ShearingOfferIDAO extends GenericIDAO<ShearingOffer> {
	
	List<ShearingOffer> searchOfferByFieldLocation(Field field);
	
}
