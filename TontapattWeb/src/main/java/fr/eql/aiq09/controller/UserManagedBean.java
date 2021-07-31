package fr.eql.aiq09.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.ibusiness.UnsubscriptionReasonIBusiness;
import fr.eql.ai109.ibusiness.UserCategoryIBusiness;
import fr.eql.ai109.ibusiness.UserIBusiness;
import fr.eql.ai109.ibusiness.ZipCodeCityIBusiness;
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
	@EJB
	UserCategoryIBusiness userCategoryIBusiness;
	@EJB
	ZipCodeCityIBusiness zipCodeCityIBusiness;
	@EJB
	UnsubscriptionReasonIBusiness unsubscriptionReasonIBusiness;

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

	private Integer userCategoryId;

	private Integer zipCodeCityId;

	private Integer unsubscriptionReasonId;

	public User addUser() {
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
		newUser.setUserCategory(userCategoryIBusiness.getById(userCategoryId));
		newUser.setZipCodeCity(zipCodeCityIBusiness.getById(zipCodeCityId));

		business.add(newUser);
		return newUser;
	}

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

	public Integer getUserCategoryId() {
		return userCategoryId;
	}

	public void setUserCategoryId(Integer userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	public Integer getZipCodeCityId() {
		return zipCodeCityId;
	}

	public void setZipCodeCityId(Integer zipCodeCityId) {
		this.zipCodeCityId = zipCodeCityId;
	}

	public Integer getUnsubscriptionReasonId() {
		return unsubscriptionReasonId;
	}

	public void setUnsubscriptionReasonId(Integer unsubscriptionReasonId) {
		this.unsubscriptionReasonId = unsubscriptionReasonId;
	}

}
