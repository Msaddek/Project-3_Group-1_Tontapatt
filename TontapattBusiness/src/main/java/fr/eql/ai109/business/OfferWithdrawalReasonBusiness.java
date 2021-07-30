package fr.eql.ai109.business;


import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.OfferWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.idao.OfferWithdrawalReasonIDAO;


@Remote(OfferWithdrawalReasonIBusiness.class)
@Stateless
public class OfferWithdrawalReasonBusiness implements OfferWithdrawalReasonIBusiness{

	@EJB
	private OfferWithdrawalReasonIDAO offerWithdrawalReasonIDAO;
}
