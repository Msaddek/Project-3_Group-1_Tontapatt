package fr.eql.aiq09.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.PrematureCancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;

@ManagedBean(name = "mbPrematureCancellationReason")
@SessionScoped
public class PrematureCancellationReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PrematureCancellationReasonIBusiness business;
	private PrematureCancellationReason prematureCancellationReason;

	public PrematureCancellationReason getPrematureCancellationReason() {
		return prematureCancellationReason;
	}

	public void setPrematureCancellationReason(
			PrematureCancellationReason prematureCancellationReason) {
		this.prematureCancellationReason = prematureCancellationReason;
	}

}
