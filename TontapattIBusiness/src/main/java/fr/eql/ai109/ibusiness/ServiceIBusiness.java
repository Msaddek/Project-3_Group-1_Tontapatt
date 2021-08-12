package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;

public interface ServiceIBusiness extends GenericIBusiness<Service> {

	Set<Service> getAllByFieldOwner(User connectedUser);
	
	Set<Service> getAllByOfferBreeder(User connectedUser);

}
