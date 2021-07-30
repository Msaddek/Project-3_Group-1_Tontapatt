package fr.eql.ai109.business;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.CancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.idao.CancellationReasonIDAO;


@Remote(CancellationReasonIBusiness.class)
@Stateless
public class CancellationReasonBusiness implements CancellationReasonIBusiness{

	@EJB
	private CancellationReasonIDAO cancellationReasonIDAO;
}
