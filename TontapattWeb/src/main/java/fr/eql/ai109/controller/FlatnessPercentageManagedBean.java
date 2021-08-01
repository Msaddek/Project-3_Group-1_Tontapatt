package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FlatnessPercentageIBusiness;
import fr.eql.ai109.tontapatt.entity.FlatnessPercentage;

@ManagedBean(name = "mbFlatnessPercentage")
@SessionScoped
public class FlatnessPercentageManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FlatnessPercentageIBusiness business;
	private FlatnessPercentage flatnessPercentage;

	public FlatnessPercentage getFlatnessPercentage() {
		return flatnessPercentage;
	}

	public void setFlatnessPercentage(FlatnessPercentage flatnessPercentage) {
		this.flatnessPercentage = flatnessPercentage;
	}

}
