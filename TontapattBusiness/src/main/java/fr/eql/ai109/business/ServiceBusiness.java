package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.ServiceIBusiness;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ServiceIDAO;

@Remote(ServiceIBusiness.class)
@Stateless
public class ServiceBusiness implements ServiceIBusiness {

	@EJB
	private ServiceIDAO serviceIDAO;

	@Override
	public Service add(Service t) {
		return serviceIDAO.add(t);
	}

	@Override
	public void delete(Service t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Service update(Service t) {
		return serviceIDAO.update(t);
	}

	@Override
	public Service getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Service> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Service> getAllByFieldOwner(User connectedUser) {
		return serviceIDAO.getAllByFieldOwner(connectedUser);
	}

	@Override
	public Set<Service> getAllByOfferBreeder(User connectedUser) {
		return serviceIDAO.getAllByOfferBreeder(connectedUser);
	}

	@Override
	public Set<Service> getAllCancelledServicesOfConnectedUser(
			User connectedUser) {
		return serviceIDAO
				.getAllCancelledServicesOfConnectedUser(connectedUser);
	}

	@Override
	public Set<Service> getAllFinishedServicesOfConnectedUser(
			User connectedUser) {
		return serviceIDAO.getAllFinishedServicesOfConnectedUser(connectedUser);
	}

	@Override
	public Set<Service> getAllInProgressServicesOfConnectedUser(
			User connectedUser) {
		return serviceIDAO
				.getAllInProgressServicesOfConnectedUser(connectedUser);
	}

	@Override
	public Set<Service> getAllPendingServicesOfConnectedUser(
			User connectedUser) {
		return serviceIDAO.getAllPendingServicesOfConnectedUser(connectedUser);
	}
}
