package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.GrassHeightIBusiness;
import fr.eql.ai109.tontapatt.entity.GrassHeight;

@ManagedBean(name = "mbGrassHeight")
@SessionScoped
public class GrassHeightManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	GrassHeightIBusiness business;
	private GrassHeight grassHeight;

	public GrassHeight getGrassHeight() {
		return grassHeight;
	}

	public void setGrassHeight(GrassHeight grassHeight) {
		this.grassHeight = grassHeight;
	}

}
