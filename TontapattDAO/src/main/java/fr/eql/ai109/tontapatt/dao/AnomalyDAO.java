package fr.eql.ai109.tontapatt.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.idao.AnomalyIDAO;

@Remote(AnomalyIDAO.class)
@Stateless
public class AnomalyDAO extends GenericDAO<Anomaly>
		implements AnomalyIDAO {

	@Override
	public Set<Anomaly> getAllByService(Service selectedService) {
		Set<Anomaly> anomalies = null;
		try {
			anomalies = new HashSet<>(em.createQuery(
					"SELECT a FROM Anomaly a WHERE a.service=:serviceParam")
					.setParameter("serviceParam", selectedService).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return anomalies;
	}

}
