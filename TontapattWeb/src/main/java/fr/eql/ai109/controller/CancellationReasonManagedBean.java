package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.CancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.CancellationReason;

@ManagedBean(name = "mbCancellationReason")
@SessionScoped
public class CancellationReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	CancellationReasonIBusiness business;
	private CancellationReason cancellationReason;

	public CancellationReason getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(CancellationReason cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

}
