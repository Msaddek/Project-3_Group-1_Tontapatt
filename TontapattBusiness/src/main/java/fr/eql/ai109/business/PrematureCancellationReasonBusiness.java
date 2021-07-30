package fr.eql.ai109.business;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.PrematureCancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.idao.PrematureCancellationReasonIDAO;


@Remote(PrematureCancellationReasonIBusiness.class)
@Stateless
public class PrematureCancellationReasonBusiness implements PrematureCancellationReasonIBusiness{

	

	@EJB
	private PrematureCancellationReasonIDAO prematureCancellationReasonerviceIDAO;
}
