package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.RefusalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.RefusalReason;

@ManagedBean(name = "mbRefusalReason")
@ViewScoped
public class RefusalReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RefusalReasonIBusiness business;
	
	private RefusalReason refusalReason;
	
	private List<RefusalReason> refusalReasons;
	
	public List<RefusalReason> allRefusalReasons(){
		return refusalReasons = business.getAll();
	}

	public RefusalReason getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(RefusalReason refusalReason) {
		this.refusalReason = refusalReason;
	}

	public List<RefusalReason> getRefusalReasons() {
		return refusalReasons;
	}

	public void setRefusalReasons(List<RefusalReason> refusalReasons) {
		this.refusalReasons = refusalReasons;
	}

}
