package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.idao.ServiceIDAO;

@Remote(ServiceIDAO.class)
@Stateless
public class ServiceDAO extends GenericDAO<Service> implements ServiceIDAO {

	@Override
	public Set<Service> getAllByFieldOwner(User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em.createQuery(
					"SELECT s FROM Service s WHERE s.field.owner=:userParam")
					.setParameter("userParam", connectedUser).getFirstResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;
	}

	@Override
	public Set<Service> getAllByOfferBreeder(User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em.createQuery(
					"SELECT s FROM Service s WHERE s.shearingOffer.breeder=:userParam")
					.setParameter("userParam", connectedUser).getFirstResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;
	}

}
