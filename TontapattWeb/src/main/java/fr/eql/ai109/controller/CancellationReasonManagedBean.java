package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.CancellationReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.CancellationReason;

@ManagedBean(name = "mbCancellationReason")
@ViewScoped
public class CancellationReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	CancellationReasonIBusiness business;

	private CancellationReason cancellationReason;

	private List<CancellationReason> cancellationReasons;

	public List<CancellationReason> allCancellationReasons() {
		return cancellationReasons = business.getAll();
	}

	public CancellationReason getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(CancellationReason cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public List<CancellationReason> getCancellationReasons() {
		return cancellationReasons;
	}

	public void setCancellationReasons(
			List<CancellationReason> cancellationReasons) {
		this.cancellationReasons = cancellationReasons;
	}

}
