package fr.eql.ai109.tontapatt.idao;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.entity.Service;

public interface AnomalyIDAO extends GenericIDAO<Anomaly> {

	Set<Anomaly> getAllByService(Service selectedService);
	
}
