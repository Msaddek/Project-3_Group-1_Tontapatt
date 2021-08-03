package fr.eql.ai109.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.eql.ai109.tontapatt.entity.UserCategory;

@ManagedBean(name = "mbRequired")
@SessionScoped
public class RequiredManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean userCategory;

	private Boolean email;

	private Boolean password;

	private Boolean password2;

	private Boolean lastName;

	private Boolean firstName;

	private Boolean birthDate;

	private Boolean phoneNumber;

	private Boolean address;

	private Boolean zipCode;

	private Boolean city;

	private Boolean siret;

	private Boolean description;

	private Boolean photo;

	public void requiredSubscriptionForm(UserCategory userCategory) {
		switch (userCategory.getId()) {
		case 1: {
			email = true;
			password = true;
			password2 = true;
			lastName = true;
			firstName = true;
			birthDate = true;
			phoneNumber = true;
			address = true;
			zipCode = true;
			city = true;
			siret = false;
			description = false;
			photo = false;
			break;
		}
		case 2: 
		case 4: {
			email = true;
			password = true;
			password2 = true;
			lastName = true;
			firstName = false;
			birthDate = true;
			phoneNumber = true;
			address = true;
			zipCode = true;
			city = true;
			siret = true;
			description = false;
			photo = false;
			break;
		}
		case 3: {
			email = true;
			password = true;
			password2 = true;
			lastName = true;
			firstName = true;
			birthDate = false;
			phoneNumber = true;
			address = true;
			zipCode = true;
			city = true;
			siret = false;
			description = false;
			photo = false;
			break;
		}
		default:
			break;
		}
	}

	public Boolean getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(Boolean userCategory) {
		this.userCategory = userCategory;
	}

	public Boolean getEmail() {
		return email;
	}

	public void setEmail(Boolean email) {
		this.email = email;
	}

	public Boolean getPassword() {
		return password;
	}

	public void setPassword(Boolean password) {
		this.password = password;
	}

	public Boolean getPassword2() {
		return password2;
	}

	public void setPassword2(Boolean password2) {
		this.password2 = password2;
	}

	public Boolean getLastName() {
		return lastName;
	}

	public void setLastName(Boolean lastName) {
		this.lastName = lastName;
	}

	public Boolean getFirstName() {
		return firstName;
	}

	public void setFirstName(Boolean firstName) {
		this.firstName = firstName;
	}

	public Boolean getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Boolean birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Boolean phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getAddress() {
		return address;
	}

	public void setAddress(Boolean address) {
		this.address = address;
	}

	public Boolean getZipCode() {
		return zipCode;
	}

	public void setZipCode(Boolean zipCode) {
		this.zipCode = zipCode;
	}

	public Boolean getCity() {
		return city;
	}

	public void setCity(Boolean city) {
		this.city = city;
	}

	public Boolean getSiret() {
		return siret;
	}

	public void setSiret(Boolean siret) {
		this.siret = siret;
	}

	public Boolean getDescription() {
		return description;
	}

	public void setDescription(Boolean description) {
		this.description = description;
	}

	public Boolean getPhoto() {
		return photo;
	}

	public void setPhoto(Boolean photo) {
		this.photo = photo;
	}

}
