package fr.eql.aiq09.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.AnomalyTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.AnomalyType;

@ManagedBean(name = "mbAnomalyType")
@SessionScoped
public class AnomalyTypeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	AnomalyTypeIBusiness business;
	private AnomalyType anomalyType;

	public AnomalyType getAnomalyType() {
		return anomalyType;
	}

	public void setAnomalyType(AnomalyType anomalyType) {
		this.anomalyType = anomalyType;
	}

}
