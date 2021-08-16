package fr.eql.ai109.business;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.AnomalyIBusiness;
import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.idao.AnomalyIDAO;

@Remote(AnomalyIBusiness.class)
@Stateless
public class AnomalyBusiness implements AnomalyIBusiness {

	@EJB
	private AnomalyIDAO anomalyIDAO;

	@Override
	public Anomaly add(Anomaly t) {
		return anomalyIDAO.add(t);
	}

	@Override
	public void delete(Anomaly t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Anomaly update(Anomaly t) {
		return anomalyIDAO.update(t);
	}

	@Override
	public Anomaly getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anomaly> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Anomaly> getAllByService(Service selectedService) {
		return anomalyIDAO.getAllByService(selectedService);
	}
}
