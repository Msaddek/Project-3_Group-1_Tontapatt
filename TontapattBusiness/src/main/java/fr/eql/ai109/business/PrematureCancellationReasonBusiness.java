package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.PrematureCancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;
import fr.eql.ai109.tontapatt.idao.PrematureCancellationReasonIDAO;

@Remote(PrematureCancellationReasonIBusiness.class)
@Stateless
public class PrematureCancellationReasonBusiness
		implements PrematureCancellationReasonIBusiness {

	@EJB
	private PrematureCancellationReasonIDAO prematureCancellationReasonerviceIDAO;

	@Override
	public PrematureCancellationReason add(PrematureCancellationReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PrematureCancellationReason t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrematureCancellationReason update(PrematureCancellationReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrematureCancellationReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PrematureCancellationReason> getAll() {
		return prematureCancellationReasonerviceIDAO.getAll();
	}
}
