package fr.eql.ai109.ibusiness;

import java.util.Set;

import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.entity.Service;

public interface AnomalyIBusiness extends GenericIBusiness<Anomaly> {

	Set<Anomaly> getAllByService(Service selectedService);

}
