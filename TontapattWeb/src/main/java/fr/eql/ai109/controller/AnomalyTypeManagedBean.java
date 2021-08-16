package fr.eql.ai109.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.eql.ai109.ibusiness.AnomalyTypeIBusiness;
import fr.eql.ai109.tontapatt.entity.AnomalyType;

@ManagedBean(name = "mbAnomalyType")
@ViewScoped
public class AnomalyTypeManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	AnomalyTypeIBusiness business;
	
	private AnomalyType anomalyType;
	
	private List<AnomalyType> anomalyTypes;
	
	public List<AnomalyType> allAnomalyTypes(){
		return business.getAll();
	}

	public AnomalyType getAnomalyType() {
		return anomalyType;
	}

	public void setAnomalyType(AnomalyType anomalyType) {
		this.anomalyType = anomalyType;
	}

	public List<AnomalyType> getAnomalyTypes() {
		return anomalyTypes;
	}

	public void setAnomalyTypes(List<AnomalyType> anomalyTypes) {
		this.anomalyTypes = anomalyTypes;
	}

}
