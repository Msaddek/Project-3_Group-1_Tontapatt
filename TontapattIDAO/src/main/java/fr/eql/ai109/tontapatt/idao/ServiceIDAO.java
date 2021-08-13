package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;

public interface ServiceIDAO extends GenericIDAO<Service> {

	Set<Service> getAllByFieldOwner(User connectedUser);
	
	Set<Service> getAllByOfferBreeder(User connectedUser);

	Set<Service> getAllCancelledServicesOfConnectedUser(User connectedUser);

	Set<Service> getAllFinishedServicesOfConnectedUser(User connectedUser);

	Set<Service> getAllInProgressServicesOfConnectedUser(User connectedUser);

	Set<Service> getAllPendingServicesOfConnectedUser(User connectedUser);
	
}
