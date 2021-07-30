package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.UnsubscriptionReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.UnsubscriptionReason;
import fr.eql.ai109.tontapatt.idao.UnsubscriptionReasonIDAO;

@Remote(UnsubscriptionReasonIBusiness.class)
@Stateless
public class UnsubscriptionReasonBusiness
		implements UnsubscriptionReasonIBusiness {

	@EJB
	private UnsubscriptionReasonIDAO unsubscriptionReasonIDAO;

	@Override
	public UnsubscriptionReason add(UnsubscriptionReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UnsubscriptionReason t) {
		// TODO Auto-generated method stub

	}

	@Override
	public UnsubscriptionReason update(UnsubscriptionReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnsubscriptionReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnsubscriptionReason> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
