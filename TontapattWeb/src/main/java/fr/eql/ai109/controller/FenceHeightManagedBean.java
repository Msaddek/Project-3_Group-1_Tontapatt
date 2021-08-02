package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.FenceHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.FenceHeight;

@ManagedBean(name = "mbFenceHeight")
@SessionScoped
public class FenceHeightManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FenceHeightIBusiness business;
	private FenceHeight fenceHeight;

	public FenceHeight getFenceHeight() {
		return fenceHeight;
	}

	public void setFenceHeight(FenceHeight fenceHeight) {
		this.fenceHeight = fenceHeight;
	}

}
