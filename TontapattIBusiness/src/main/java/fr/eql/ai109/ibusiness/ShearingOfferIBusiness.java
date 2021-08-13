package fr.eql.ai109.ibusiness;

import java.time.LocalDate;
import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.User;

public interface ShearingOfferIBusiness
		extends GenericIBusiness<ShearingOffer> {

	Set<ShearingOffer> searchOfferByFieldLocation(Field field,
			LocalDate startDate, LocalDate endDate);

	Set<ShearingOffer> getShearingOffersOfConnectedUser(User user);

	Set<ShearingOffer> getExpiredShearingOffersOfConnectedUser(User user);

	Set<ShearingOffer> getInProgressShearingOffersOfConnectedUser(User user);

	ShearingOffer createShearingOffer(ShearingOffer shearingOffer);

}
