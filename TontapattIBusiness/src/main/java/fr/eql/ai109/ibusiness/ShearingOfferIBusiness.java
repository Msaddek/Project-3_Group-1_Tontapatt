package fr.eql.ai109.ibusiness;

import java.util.List;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;

public interface ShearingOfferIBusiness
		extends GenericIBusiness<ShearingOffer> {
	
	List<ShearingOffer> searchOfferByFieldLocation(Field field);

}
