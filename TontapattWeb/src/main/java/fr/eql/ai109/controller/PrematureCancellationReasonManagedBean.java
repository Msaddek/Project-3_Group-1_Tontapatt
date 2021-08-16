package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.PrematureCancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.PrematureCancellationReason;

@ManagedBean(name = "mbPrematureCancellationReason")
@ViewScoped
public class PrematureCancellationReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	PrematureCancellationReasonIBusiness business;
	
	private PrematureCancellationReason prematureCancellationReason;

	private List<PrematureCancellationReason> prematureCancellationReasons;
	
	public List<PrematureCancellationReason> allPrematureCancellationReasons(){
		return prematureCancellationReasons = business.getAll();
	}

	public PrematureCancellationReason getPrematureCancellationReason() {
		return prematureCancellationReason;
	}

	public void setPrematureCancellationReason(
			PrematureCancellationReason prematureCancellationReason) {
		this.prematureCancellationReason = prematureCancellationReason;
	}

	public List<PrematureCancellationReason> getPrematureCancellationReasons() {
		return prematureCancellationReasons;
	}

	public void setPrematureCancellationReasons(
			List<PrematureCancellationReason> prematureCancellationReasons) {
		this.prematureCancellationReasons = prematureCancellationReasons;
	}

}
