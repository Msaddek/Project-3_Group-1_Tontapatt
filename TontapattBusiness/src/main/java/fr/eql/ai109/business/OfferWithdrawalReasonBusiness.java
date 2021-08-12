package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.OfferWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.OfferWithdrawalReason;
import fr.eql.ai109.tontapatt.idao.OfferWithdrawalReasonIDAO;

@Remote(OfferWithdrawalReasonIBusiness.class)
@Stateless
public class OfferWithdrawalReasonBusiness
		implements OfferWithdrawalReasonIBusiness {

	@EJB
	private OfferWithdrawalReasonIDAO offerWithdrawalReasonIDAO;

	@Override
	public OfferWithdrawalReason add(OfferWithdrawalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(OfferWithdrawalReason t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OfferWithdrawalReason update(OfferWithdrawalReason t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferWithdrawalReason getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfferWithdrawalReason> getAll() {
		return offerWithdrawalReasonIDAO.getAll();
	}
}
