package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

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

	private List<UnsubscriptionReason> unsubscriptionReasons;

	private String reason;

	public List<UnsubscriptionReason> showAllUnsubscriptionReasons() {
		unsubscriptionReasons = business.getAll();
		return unsubscriptionReasons;
	}

	public UnsubscriptionReason getUnsubscriptionReason() {
		return unsubscriptionReason;
	}

	public void setUnsubscriptionReason(
			UnsubscriptionReason unsubscriptionReason) {
		this.unsubscriptionReason = unsubscriptionReason;
	}

	public List<UnsubscriptionReason> getUnsubscriptionReasons() {
		return unsubscriptionReasons;
	}

	public void setUnsubscriptionReasons(
			List<UnsubscriptionReason> unsubscriptionReasons) {
		this.unsubscriptionReasons = unsubscriptionReasons;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
