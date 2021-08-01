package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.User;

@ManagedBean(name = "mbUser")
@SessionScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private User user;
	private String email;
	private String password;
	
	@EJB
	private UserIBusiness userIBusiness;

	
	public String connect() {
		
		String forward = null;
		user = userIBusiness.connection(email, password);
		if (user != null) {
			System.out.println(user.getFirstName());
			forward = "/TontapattWeb/inscription.xhtml?faces-redirect=true";
			System.out.println("url doit être " + forward);
		} else {
			System.out.println("e");
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)",
					"Identifiant et/ou mot de passe incorrect(s)"
					);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpEmail", facesMessage);
			FacesContext.getCurrentInstance().addMessage("loginForm:inpPassword", facesMessage);
			forward = "/TontapattWeb/home.xhtml?faces-redirection=true";
		}
		
		return forward;
	}
	
	public String disconnect() {
		HttpSession session = (HttpSession) FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSession(true);
		session.invalidate();
		email = "";
		password = "";
		user = new User();
		return "/TontapattWeb/home.xhtml?faces-redirection=true";
	}
	
	public User addUser(User newUser) {
		this.user = userIBusiness.add(newUser);
		return this.user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
