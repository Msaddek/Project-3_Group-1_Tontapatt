package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.AnomalyIBusiness;
import fr.eql.ai109.tontapatt.entity.Anomaly;

@ManagedBean(name = "mbAnomaly")
@SessionScoped
public class AnomalyManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	AnomalyIBusiness business;
	private Anomaly anomaly;

	public Anomaly getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(Anomaly anomaly) {
		this.anomaly = anomaly;
	}

}
