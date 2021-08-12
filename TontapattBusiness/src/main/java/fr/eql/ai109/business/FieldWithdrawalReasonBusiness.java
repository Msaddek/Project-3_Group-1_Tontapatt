package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FieldWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.FieldWithdrawalReason;
import fr.eql.ai109.tontapatt.idao.FieldWithdrawalReasonIDAO;

@Remote(FieldWithdrawalReasonIBusiness.class)
@Stateless
public class FieldWithdrawalReasonBusiness
		implements FieldWithdrawalReasonIBusiness {

	@EJB
	private FieldWithdrawalReasonIDAO fieldWithdrawalReasonIDAO;

	@Override
	public FieldWithdrawalReason add(FieldWithdrawalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(FieldWithdrawalReason t) {
		// TODO Auto-generated method stub

	}

	@Override
	public FieldWithdrawalReason update(FieldWithdrawalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FieldWithdrawalReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FieldWithdrawalReason> getAll() {
		
		return fieldWithdrawalReasonIDAO.getAll();
	}
}
