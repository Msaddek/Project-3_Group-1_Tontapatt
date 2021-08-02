package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.RefusalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.RefusalReason;

@ManagedBean(name = "mbRefusalReason")
@SessionScoped
public class RefusalReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RefusalReasonIBusiness business;
	private RefusalReason refusalReason;

	public RefusalReason getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(RefusalReason refusalReason) {
		this.refusalReason = refusalReason;
	}

}
