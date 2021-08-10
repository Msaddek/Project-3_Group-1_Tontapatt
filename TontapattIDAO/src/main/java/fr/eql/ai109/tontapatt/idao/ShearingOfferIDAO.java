package fr.eql.ai109.tontapatt.idao;

import java.time.LocalDate;
import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.Species;
import fr.eql.ai109.tontapatt.entity.User;

public interface ShearingOfferIDAO extends GenericIDAO<ShearingOffer> {
	
	Set<ShearingOffer> searchOfferByFieldLocation(Field field,
			Species species, LocalDate serviceStartDate, LocalDate serviceEndDate);
	
	Set<ShearingOffer> getShearingOffersOfConnectedUser(User user);
	
	Set<ShearingOffer> getExpiredShearingOffersOfConnectedUser(User user);
	
	Set<ShearingOffer> getInProgressShearingOffersOfConnectedUser(User user);
	
}
