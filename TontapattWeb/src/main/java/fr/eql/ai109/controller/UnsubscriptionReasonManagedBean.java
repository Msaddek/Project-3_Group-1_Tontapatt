package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.UnsubscriptionReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.UnsubscriptionReason;

@ManagedBean(name = "mbUnsubscriptionReason")
@SessionScoped
public class UnsubscriptionReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UnsubscriptionReasonIBusiness business;
	private UnsubscriptionReason unsubscriptionReason;

	public UnsubscriptionReason getUnsubscriptionReason() {
		return unsubscriptionReason;
	}

	public void setUnsubscriptionReason(
			UnsubscriptionReason unsubscriptionReason) {
		this.unsubscriptionReason = unsubscriptionReason;
	}

}
