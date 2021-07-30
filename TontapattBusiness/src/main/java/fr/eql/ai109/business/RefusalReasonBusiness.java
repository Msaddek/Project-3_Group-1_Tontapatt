package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RefusalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.RefusalReason;
import fr.eql.ai109.tontapatt.idao.RefusalReasonIDAO;

@Remote(RefusalReasonIBusiness.class)
@Stateless
public class RefusalReasonBusiness extends GenericBusiness<RefusalReason>
		implements RefusalReasonIBusiness {

	@EJB
	private RefusalReasonIDAO refusalReasonIDAO;
}
