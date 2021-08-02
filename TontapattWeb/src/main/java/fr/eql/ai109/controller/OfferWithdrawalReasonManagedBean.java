package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.OfferWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.OfferWithdrawalReason;

@ManagedBean(name = "mbOfferWithdrawalReason")
@SessionScoped
public class OfferWithdrawalReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	OfferWithdrawalReasonIBusiness business;
	private OfferWithdrawalReason offerWithdrawalReason;

	public OfferWithdrawalReason getOfferWithdrawalReason() {
		return offerWithdrawalReason;
	}

	public void setOfferWithdrawalReason(
			OfferWithdrawalReason offerWithdrawalReason) {
		this.offerWithdrawalReason = offerWithdrawalReason;
	}

}
