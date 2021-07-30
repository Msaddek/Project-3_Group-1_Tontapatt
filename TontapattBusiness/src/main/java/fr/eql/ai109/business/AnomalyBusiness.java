package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.AnomalyIBusiness;
import fr.eql.ai109.tontapatt.idao.AnomalyIDAO;



@Remote(AnomalyIBusiness.class)
@Stateless
public class AnomalyBusiness implements AnomalyIBusiness{

	@EJB
	private AnomalyIDAO anomalyIDAO;
}
