package fr.eql.ai109.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.ibusiness.PaymentMethodIBusiness;
import fr.eql.ai109.tontapatt.entity.PaymentMethod;
import fr.eql.ai109.tontapatt.idao.PaymentMethodIDAO;

@Remote(PaymentMethodIBusiness.class)
@Stateless
public class PaymentMethodBusiness implements PaymentMethodIBusiness {

	@EJB
	private PaymentMethodIDAO paymentMethodIDAO;

	@Override
	public PaymentMethod add(PaymentMethod t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PaymentMethod t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentMethod update(PaymentMethod t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentMethod getById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaymentMethod> getAll() {
		return paymentMethodIDAO.getAll();
	}
}
