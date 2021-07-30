package fr.eql.aiq09.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UserManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UserIBusiness business;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
