package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.FieldWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.idao.FieldWithdrawalReasonIDAO;



@Remote(FieldWithdrawalReasonIBusiness.class)
@Stateless
public class FieldWithdrawalReasonBusiness implements FieldWithdrawalReasonIBusiness{

	@EJB
	private FieldWithdrawalReasonIDAO fieldWithdrawalReasonIDAO;
}
