package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.AnomalyTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.AnomalyType;
import fr.eql.ai109.tontapatt.idao.AnomalyTypeIDAO;

@Remote(AnomalyTypeIBusiness.class)
@Stateless
public class AnomalyTypeBusiness extends GenericBusiness<AnomalyType>
		implements AnomalyTypeIBusiness {

	@EJB
	private AnomalyTypeIDAO anomalyTypeIDAO;
}
