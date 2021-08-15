package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;

public interface ShearingOfferPhotoIDAO
		extends GenericIDAO<ShearingOfferPhoto> {

	Set<ShearingOfferPhoto> findPhotosByShearingOffer(ShearingOffer shearingPhoto);

}
