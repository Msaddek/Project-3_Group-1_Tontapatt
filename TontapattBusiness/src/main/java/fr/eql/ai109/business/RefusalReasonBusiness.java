package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.RefusalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.RefusalReason;
import fr.eql.ai109.tontapatt.idao.RefusalReasonIDAO;

@Remote(RefusalReasonIBusiness.class)
@Stateless
public class RefusalReasonBusiness implements RefusalReasonIBusiness {

	@EJB
	private RefusalReasonIDAO refusalReasonIDAO;

	@Override
	public RefusalReason add(RefusalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(RefusalReason t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RefusalReason update(RefusalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefusalReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RefusalReason> getAll() {
		return refusalReasonIDAO.getAll();
	}
}
