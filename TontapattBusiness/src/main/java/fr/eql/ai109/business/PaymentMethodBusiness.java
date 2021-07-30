package fr.eql.ai109.business;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.PaymentMethodIBusiness;
import fr.eql.ai109.tontapatt.entity.PaymentMethod;
import fr.eql.ai109.tontapatt.idao.PaymentMethodIDAO;

@Remote(PaymentMethodIBusiness.class)
@Stateless
public class PaymentMethodBusiness extends GenericBusiness<PaymentMethod>
		implements PaymentMethodIBusiness {

	@EJB
	private PaymentMethodIDAO paymentMethodIDAO;
}
