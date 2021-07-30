package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.FieldWithdrawalReason;
import fr.eql.ai109.tontapatt.idao.FieldWithdrawalReasonIDAO;

@Remote(FieldWithdrawalReasonIDAO.class)
@Stateless
public class FieldWithdrawalReasonDAO extends GenericDAO<FieldWithdrawalReason>
		implements FieldWithdrawalReasonIDAO {

}
