package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.CancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.CancellationReason;
import fr.eql.ai109.tontapatt.idao.CancellationReasonIDAO;

@Remote(CancellationReasonIBusiness.class)
@Stateless
public class CancellationReasonBusiness implements CancellationReasonIBusiness {

	@EJB
	private CancellationReasonIDAO cancellationReasonIDAO;

	@Override
	public CancellationReason add(CancellationReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CancellationReason t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CancellationReason update(CancellationReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CancellationReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CancellationReason> getAll() {
		return cancellationReasonIDAO.getAll();
	}
}
