package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.OfferWithdrawalReason;
import fr.eql.ai109.tontapatt.idao.OfferWithdrawalReasonIDAO;

@Remote(OfferWithdrawalReasonIDAO.class)
@Stateless
public class OfferWithdrawalReasonDAO extends GenericDAO<OfferWithdrawalReason>
		implements OfferWithdrawalReasonIDAO {

}
