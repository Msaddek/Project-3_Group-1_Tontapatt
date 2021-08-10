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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.entity.User;
import fr.eql.ai109.tontapatt.entity.ZipCodeCity;

@ManagedBean(name = "mbShearingOffer")
@SessionScoped
public class ShearingOfferManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ShearingOfferIBusiness business;
	
	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private Set<ShearingOffer> connectedUserOffers;

	private Set<ShearingOffer> connectedUserExpiredOffers;

	private Set<ShearingOffer> connectedUserInProgress;

	private ShearingOffer shearingOffer;
	
	private String address;
	
	private Integer animalCount;
	
	private Double animalDailyPrice;
	
	private LocalDateTime creationDate;
	
	private String description;
	
	private LocalDate endDate;
	
	private Integer maxTravelDistance;
	
	private String name;
	
	private LocalDate startDate;
	
	private Race race;
	
	private ZipCodeCity city;
	
	private ShearingOfferPhoto photo;
	
	private Set<ShearingOfferPhoto> photos;

	@PostConstruct
	public void init() {
		connectedUserOffers = business
				.getShearingOffersOfConnectedUser(connectedUser);
		connectedUserExpiredOffers = business
				.getExpiredShearingOffersOfConnectedUser(connectedUser);
		connectedUserInProgress = business
				.getInProgressShearingOffersOfConnectedUser(connectedUser);
		photos = new HashSet<>();
	}
	
	public String offerDetails (ShearingOffer offer) {
		this.shearingOffer = offer;
		return "/offerDetails.xhtml?faces-redirect=true";
		
	}
	
	public String createOffer() {
		ShearingOffer newShearingOffer = new ShearingOffer();
		newShearingOffer.setCreationDate(LocalDateTime.now());
		newShearingOffer.setAddress(address);
		newShearingOffer.setAnimalCount(animalCount);
		newShearingOffer.setAnimalDailyPrice(animalDailyPrice);
		newShearingOffer.setDescription(description);
		newShearingOffer.setEndDate(endDate);
		newShearingOffer.setMaxTravelDist(maxTravelDistance);
		newShearingOffer.setName(name);
		newShearingOffer.setStartDate(startDate);
		newShearingOffer.setBreeder(connectedUser);
		newShearingOffer.setRace(race);
		newShearingOffer.setZipCodeCity(city);
		shearingOffer = business.add(newShearingOffer);
		for (ShearingOfferPhoto sop : photos) {
			sop.setShearingOffer(shearingOffer);
		}
		shearingOffer.setPhotos(photos);
		shearingOffer = business.update(shearingOffer);
		return "/offerParameters.xhtml?faces-redirect=true";
	}
	
	public void uploadPhoto(FileUploadEvent event) {
		System.out.println("connected user " + connectedUser.getId());
		URL url = null;
		String destination = null;
		String messageUploded = null;
		try {
			url = FacesContext.getCurrentInstance().getExternalContext()
					.getResource("/");
			destination = url.getPath() + "/resources/img/offers/";
		} catch (MalformedURLException e1) {
			messageUploded = "Le fichier n'a pas pu être télécharger";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageUploded,
					messageUploded);
			FacesContext.getCurrentInstance()
					.addMessage("offerCreationForm:inpPhoto", facesMessage);
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
					.addMessage("offerCreationForm:inpPhoto", facesMessage);
		}
		messageUploded = "Télécharge fait!";
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,
				messageUploded, messageUploded);
		FacesContext.getCurrentInstance()
				.addMessage("offerCreationForm:inpPhoto", facesMessage);
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
			photo = new ShearingOfferPhoto();
			photo.setLink(fileName);
			photo.setShearingOffer(shearingOffer);
			photos.add(photo);
			System.out.println("New file created!" + fileName);
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public Set<ShearingOffer> getConnectedUserOffers() {
		return connectedUserOffers;
	}

	public void setConnectedUserOffers(Set<ShearingOffer> connectedUserOffers) {
		this.connectedUserOffers = connectedUserOffers;
	}

	public Set<ShearingOffer> getConnectedUserExpiredOffers() {
		return connectedUserExpiredOffers;
	}

	public void setConnectedUserExpiredOffers(
			Set<ShearingOffer> connectedUserExpiredOffers) {
		this.connectedUserExpiredOffers = connectedUserExpiredOffers;
	}

	public Set<ShearingOffer> getConnectedUserInProgress() {
		return connectedUserInProgress;
	}

	public void setConnectedUserInProgress(
			Set<ShearingOffer> connectedUserInProgress) {
		this.connectedUserInProgress = connectedUserInProgress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(Integer animalCount) {
		this.animalCount = animalCount;
	}

	public Double getAnimalDailyPrice() {
		return animalDailyPrice;
	}

	public void setAnimalDailyPrice(Double animalDailyPrice) {
		this.animalDailyPrice = animalDailyPrice;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getMaxTravelDistance() {
		return maxTravelDistance;
	}

	public void setMaxTravelDistance(Integer maxTravelDistance) {
		this.maxTravelDistance = maxTravelDistance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public ZipCodeCity getCity() {
		return city;
	}

	public void setCity(ZipCodeCity city) {
		this.city = city;
	}

	public ShearingOfferPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(ShearingOfferPhoto photo) {
		this.photo = photo;
	}

	public Set<ShearingOfferPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<ShearingOfferPhoto> photos) {
		this.photos = photos;
	}

}
