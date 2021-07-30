package fr.eql.ai109.tontapatt.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.eql.ai109.tontapatt.entity.PaymentMethod;
import fr.eql.ai109.tontapatt.idao.PaymentMethodIDAO;

@Remote(PaymentMethodIDAO.class)
@Stateless
public class PaymentMethodDAO extends GenericDAO<PaymentMethod>
		implements PaymentMethodIDAO {

}
