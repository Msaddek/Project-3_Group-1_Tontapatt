package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.PaymentMethodIBusiness;
import fr.eql.ai109.tontapatt.entity.PaymentMethod;

@ManagedBean(name = "mbPaymentMethod")
@SessionScoped
public class PaymentMethodManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PaymentMethodIBusiness business;
	
	private PaymentMethod paymentMethod;
	
	private List<PaymentMethod> paymentMethods;
	
	public List<PaymentMethod> allPaymentMethods(){
		paymentMethods = business.getAll();
		
		return paymentMethods;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
