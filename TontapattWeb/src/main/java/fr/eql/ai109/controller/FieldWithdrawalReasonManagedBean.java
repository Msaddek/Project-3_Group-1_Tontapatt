package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FieldWithdrawalReasonIBusiness;
import fr.eql.ai109.tontapatt.entity.FieldWithdrawalReason;

@ManagedBean(name = "mbFieldWithdrawalReason")
@SessionScoped
public class FieldWithdrawalReasonManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldWithdrawalReasonIBusiness business;
	private FieldWithdrawalReason fieldWithdrawalReason;

	public FieldWithdrawalReason getFieldWithdrawalReason() {
		return fieldWithdrawalReason;
	}

	public void setFieldWithdrawalReason(
			FieldWithdrawalReason fieldWithdrawalReason) {
		this.fieldWithdrawalReason = fieldWithdrawalReason;
	}

}
