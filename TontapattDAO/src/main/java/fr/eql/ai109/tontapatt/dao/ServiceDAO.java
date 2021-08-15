package fr.eql.ai109.tontapatt.dao;

import java.time.LocalDate;
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
					.setParameter("userParam", connectedUser).getResultList());
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
					.setParameter("userParam", connectedUser).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;
	}

	@Override
	public Set<Service> getAllCancelledServicesOfConnectedUser(
			User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em
					.createQuery("SELECT s FROM Service s WHERE "
							+ "(s.shearingOffer.breeder=:userParam OR "
							+ "s.field.owner=:userParam) AND (s.refusalDate IS NOT NULL "
							+ "OR s.cancellationDate IS NOT NULL OR "
							+ "s.prematureCancellationDate IS NOT NULL) AND "
							+ "s.requestDate IS NOT NULL")
					.setParameter("userParam", connectedUser).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;
	}

	@Override
	public Set<Service> getAllFinishedServicesOfConnectedUser(
			User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em
					.createQuery("SELECT s FROM Service s WHERE "
							+ "(s.shearingOffer.breeder=:userParam OR "
							+ "s.field.owner=:userParam) AND s.refusalDate IS NULL "
							+ "AND s.cancellationDate IS NULL AND "
							+ "s.prematureCancellationDate IS NULL AND "
							+ "s.requestDate IS NOT NULL AND s.validationDate IS NOT "
							+ "NULL AND s.endDate<=:dateNowParam")
					.setParameter("userParam", connectedUser)
					.setParameter("dateNowParam", LocalDate.now())
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return services;
	}

	@Override
	public Set<Service> getAllInProgressServicesOfConnectedUser(
			User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em
					.createQuery("SELECT s FROM Service s WHERE "
							+ "(s.shearingOffer.breeder=:userParam OR "
							+ "s.field.owner=:userParam) AND s.refusalDate IS NULL "
							+ "AND s.cancellationDate IS NULL AND "
							+ "s.prematureCancellationDate IS NULL AND "
							+ "s.requestDate IS NOT NULL AND s.validationDate IS NOT "
							+ "NULL AND :dateNowParam BETWEEN startDate AND "
							+ "endDate")
					.setParameter("userParam", connectedUser)
					.setParameter("dateNowParam", LocalDate.now())
					.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Service service : services) {
			System.out.println("----------------------------- en cours " + service.toString());
		}
		return services;
	}

	@Override
	public Set<Service> getAllPendingServicesOfConnectedUser(
			User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em
                    .createQuery("SELECT s FROM Service s WHERE "
                            + "(s.shearingOffer.breeder=:userParam OR "
                            + "s.field.owner=:userParam) AND s.refusalDate IS NULL "
                            + "AND s.cancellationDate IS NULL AND "
                            + "s.prematureCancellationDate IS NULL AND "
                            + "s.requestDate IS NOT NULL AND s.validationDate IS "
                            + "NULL OR(s.validationDate IS NOT NULL AND "
                            + ":dateNowParam NOT BETWEEN s.startDate AND "
                            + "s.endDate)")
                    .setParameter("userParam", connectedUser)
                    .setParameter("dateNowParam", LocalDate.now())
                    .getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Service service : services) {
			System.out.println("----------------------------- en attente " + service.toString());
		}
		return services;
	}

	@Override
	public Set<Service> getAllPendingServicesOfConnectedBreeder(
			User connectedUser) {
		Set<Service> services = null;
		try {
			services = new HashSet<>(em
					.createQuery("SELECT s FROM Service s WHERE "
							+ "s.shearingOffer.breeder=:userParam "
							+ "AND s.refusalDate IS NULL "
							+ "AND s.cancellationDate IS NULL AND "
							+ "s.prematureCancellationDate IS NULL AND "
							+ "s.requestDate IS NOT NULL AND s.validationDate IS "
							+ "NULL")
					.setParameter("userParam", connectedUser).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Service service : services) {
			System.out.println("----------------------------- en attente " + service.toString());
		}
		return services;
	}

}
