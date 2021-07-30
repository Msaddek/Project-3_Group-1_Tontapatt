package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UnsubscriptionReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.UnsubscriptionReason;
import fr.eql.ai109.tontapatt.idao.UnsubscriptionReasonIDAO;

@Remote(UnsubscriptionReasonIBusiness.class)
@Stateless
public class UnsubscriptionReasonBusiness
		extends GenericBusiness<UnsubscriptionReason>
		implements UnsubscriptionReasonIBusiness {

	@EJB
	private UnsubscriptionReasonIDAO unsubscriptionReasonIDAO;
}
