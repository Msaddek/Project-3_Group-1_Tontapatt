package fr.eql.ai109.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

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

	private String confirmPassword;

	private String address;

	private LocalDateTime signupDate;

	private String description;

	private String withdrawalReasonDescription;

	private String siret;

	private String phoneNumber;

	private LocalDateTime unsubscriptionDate;

	private String photo;

	private ZipCodeCity city;

	private UnsubscriptionReason unsubscriptionReason;

	private UserCategory category;

	private String dialogMessage;

	public String connect() {

		String forward = null;
		user = business.connection(email, password);
		if (user != null) {
			forward = "/connectedPage.xhtml?faces-redirect=true";
		} else {
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_WARN,
					"Identifiant et/ou mot de passe incorrect(s)",
					"Identifiant et/ou mot de passe incorrect(s)");
			FacesContext.getCurrentInstance().addMessage("loginForm:inpEmail",
					facesMessage);
			FacesContext.getCurrentInstance()
					.addMessage("loginForm:inpPassword", facesMessage);
			forward = "/home.xhtml?faces-redirect=false";
		}

		return forward;
	}

	public String disconnect() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();
		email = "";
		password = "";
		user = new User();
		return "/home.xhtml?faces-redirect=true";
	}

	public void createUser() {
		String forward = null;
		confirmPassword = password;
		User newUser = new User();
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName.toUpperCase());
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
		verifyIfUserExists(newUser);
	}

	public String returnToHome() {
		disconnect();
		return "/home.xhtml?faces-redirect=true";
	}

	private void verifyIfUserExists(User newUser) {
		boolean userExists = business.verifyIfUserExists(email);
		if (!userExists) {
			user = business.add(newUser);
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('dlg1').show();");

		} else {
			String message = "Adresse mail déjà existante, veuillez vous connecter";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL, message, message);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpEmail", facesMessage);
		}
	}

	public void verifyIfUserExists() {
		boolean userExists = business.verifyIfUserExists(email);
		if (userExists) {
			String message = "Adresse mail déjà existante, veuillez vous connecter";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL, message, message);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpEmail", facesMessage);
		}
	}

	public void uploadPhoto(FileUploadEvent event) {
		URL url = null;
		String destination = null;
		String messageUploded = null;
		try {
			url = FacesContext.getCurrentInstance().getExternalContext()
					.getResource("/");
			destination = url.getPath() + "/resources/img/users/";
		} catch (MalformedURLException e1) {
			messageUploded = "Le fichier n'a pas pu être télécharger";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageUploded,
					messageUploded);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpPhoto", facesMessage);
			FacesContext.getCurrentInstance()
					.addMessage("updateUserForm:inpPhoto", facesMessage);
			e1.printStackTrace();
		}
		// Do what you want with the file
		try {
			String[] file = event.getFile().getFileName().split("\\.");
			String fileName = UUID.randomUUID().toString() + "." + file[1];
			copyFile(fileName, event.getFile().getInputStream(), destination);
		} catch (IOException e) {
			messageUploded = "Le fichier n'a pas pu être télécharger";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageUploded,
					messageUploded);
			FacesContext.getCurrentInstance()
					.addMessage("subscriptionForm:inpPhoto", facesMessage);
			FacesContext.getCurrentInstance()
					.addMessage("updateUserForm:inpPhoto", facesMessage);
			e.printStackTrace();
		}
		messageUploded = "Téléchargement fait!";
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				messageUploded, messageUploded);
		FacesContext.getCurrentInstance()
				.addMessage("subscriptionForm:inpPhoto", facesMessage);
		FacesContext.getCurrentInstance().addMessage("updateUserForm:inpPhoto",
				facesMessage);
	}

	private void copyFile(String fileName, InputStream in, String destination) {
		try (OutputStream out = new FileOutputStream(
				new File(destination + fileName))) {
			// write the inputStream to a FileOutputStream;
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			photo = fileName;
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void initConnectedUserParam() {
		address = user.getAddress();
		city = user.getZipCodeCity();
		password = null;
		email = user.getEmail();
		firstName = user.getFirstName();
		lastName = user.getLastName();
		description = user.getDescription();
		phoneNumber = user.getPhoneNumber();
	}

	public void updateNameAndAddress() {
		user.setAddress(address);
		user.setZipCodeCity(city);
		user.setFirstName(firstName);
		user.setLastName(lastName.toUpperCase());
		user = business.update(user);
		dialogMessage = "Votre profile est à jour!";
		PrimeFaces.current().executeScript("PF('dialogWidget').show()");
	}

	public void updateContact() {
		User newUser = user;
		newUser.setEmail(email);
		newUser.setPhoneNumber(phoneNumber);

		verifyEmailExistBeforeUpdate(newUser);
	}

	private void verifyEmailExistBeforeUpdate(User newUser) {
		boolean emailExists = business.verifyDuplicateEmailOnUpdate(
				newUser.getId(), newUser.getEmail());
		if (!emailExists) {
			user = business.update(newUser);
			dialogMessage = "Votre adresse mail et/ou le numéro de portable sont à jour";
			PrimeFaces.current().executeScript("PF('dialogWidget').show()");

		} else {
			String message = "Adresse mail déjà existante, veuillez choisir un autre";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL, message, message);
			FacesContext.getCurrentInstance()
					.addMessage("updateEmailForm:inpEmail", facesMessage);
		}
	}

	public void verifyEmailExistBeforeUpdate() {
		boolean emailExists = business
				.verifyDuplicateEmailOnUpdate(user.getId(), email);
		if (emailExists) {
			String message = "Adresse mail déjà existante, veuillez choisir un autre";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_FATAL, message, message);
			FacesContext.getCurrentInstance()
					.addMessage("updateEmailForm:inpEmail", facesMessage);
		}
	}

	public void updatePassword() {
		user.setPassword(password);
		user = business.updatePassword(user);
		dialogMessage = "Votre mot de passe est à jour!";
		PrimeFaces.current().executeScript("PF('dialogWidget').show()");
	}

	public void updateDescriptionAndPhoto() {
		user.setDescription(description);
		user.setPhoto(photo);
		user = business.update(user);
		dialogMessage = "Votre photo et/ou description sont à jour!";
		PrimeFaces.current().executeScript("PF('dialogWidget').show()");
	}

	public String unsubscribeUser() {
		user.setUnsubscriptionDate(LocalDateTime.now());
		user.setUnsubscriptionReason(unsubscriptionReason);
		user = business.update(user);

		return disconnect();
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public String getWithdrawalReasonDescription() {
		return withdrawalReasonDescription;
	}

	public void setWithdrawalReasonDescription(
			String withdrawalReasonDescription) {
		this.withdrawalReasonDescription = withdrawalReasonDescription;
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

	public String getDialogMessage() {
		return dialogMessage;
	}

	public void setDialogMessage(String dialogMessage) {
		this.dialogMessage = dialogMessage;
	}

}
