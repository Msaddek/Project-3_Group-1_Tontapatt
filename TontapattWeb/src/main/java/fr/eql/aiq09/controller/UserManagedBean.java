package fr.eql.aiq09.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.tontapatt.entity.UnsubscriptionReason;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.entity.UserCategory;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

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

	private String firstName;

	private String lastName;

	private LocalDate birthDate;

	private String email;

	private String password;

	private String address;

	private LocalDateTime signupDate;

	private String description;

	private String siret;

	private String phoneNumber;

	private LocalDateTime unsubscriptionDate;

	private String photo;

	private ZipCodeCity city;

	private UnsubscriptionReason unsubscriptionReason;

	private UserCategory category;

	public String createUser() {
		String forward = null;
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setBirthDate(birthDate);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setAddress(address);
		newUser.setSignupDate(LocalDateTime.now());
		newUser.setDescription(description);
		newUser.setSiret(siret);
		newUser.setPhoneNumber(phoneNumber);
		newUser.setPhoto(photo);
		newUser.setUserCategory(category);
		newUser.setZipCodeCity(city);

		forward = verifyIfUserExists(newUser);

		return forward;
	}

	private String verifyIfUserExists(User newUser) {
		String forward;
		boolean userExists = business.verifyIfUserExists(email);
		if (!userExists) {
			user = business.add(newUser);
			forward = "/subscriptionDone.xhtml?faces-redirection=false";
		} else {
			String message = "Adresse mail déjà existante, veuillez vous connecter";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL,
					message,
					message);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpEmail", facesMessage);
			forward = "/subscription.xhtml?faces-redirection=false";
		}
		return forward;
	}

	public void verifyIfUserExists() {
		boolean userExists = business.verifyIfUserExists(email);
		System.out.println(userExists);
		if (userExists) {
			String message = "Adresse mail déjà existante, veuillez vous connecter";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL,
					message,
					message);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpEmail", facesMessage);
		}
	}

	/*
	 * public void verifyBirthDate() { System.out.println(birthDate); if
	 * (Period.between(birthDate, LocalDate.now()).getYears() < 18) {
	 * FacesMessage facesMessage = new FacesMessage( FacesMessage.SEVERITY_WARN,
	 * "Vous devez avoir 18ans ou plus", "Vous devez avoir 18ans ou plus");
	 * FacesContext.getCurrentInstance()
	 * .addMessage("subscriptionForm:inpBirthDate", facesMessage); birthDate =
	 * null; System.out.println(birthDate); }
	 * 
	 * }
	 */

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getUnsubscriptionDate() {
		return unsubscriptionDate;
	}

	public void setUnsubscriptionDate(LocalDateTime unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZipCodeCity getCity() {
		return city;
	}

	public void setCity(ZipCodeCity city) {
		this.city = city;
	}

	public UnsubscriptionReason getUnsubscriptionReason() {
		return unsubscriptionReason;
	}

	public void setUnsubscriptionReason(
			UnsubscriptionReason unsubscriptionReason) {
		this.unsubscriptionReason = unsubscriptionReason;
	}

	public UserCategory getCategory() {
		return category;
	}

	public void setCategory(UserCategory category) {
		this.category = category;
	}

}
