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
import org.primefaces.model.file.UploadedFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.eql.ai109.ibusiness.ShearingOfferIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.OfferWithdrawalReason;
import fr.eql.ai109.tontapatt.entity.Race;
import fr.eql.ai109.tontapatt.entity.ShearingOffer;
import fr.eql.ai109.tontapatt.entity.ShearingOfferPhoto;
import fr.eql.ai109.tontapatt.entity.Species;
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

	private Set<ShearingOffer> shearingOfferSearchResult;

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

	private UploadedFile file;

	private OfferWithdrawalReason offerWithdrawalReason;

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

	public String offerDetails() {

		return "/offerDetails.xhtml?faces-redirect=true";

	}

	public String offerDetailedView(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
		return "/offerDetailedView.xhtml?faces-redirect=true";

	}

	public String createOffer() {
		if (photos.isEmpty()) {
			String messageUploded = "Vous devez télécharger au moins une photo";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageUploded,
					messageUploded);
			FacesContext.getCurrentInstance()
					.addMessage("offerCreationForm:inpPhoto", facesMessage);
			return "/offerCreation.xhtml?faces-redirect=false";
		}
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
		init();
		return "/offerParameters.xhtml?faces-redirect=true";
	}

	public void uploadPhoto(FileUploadEvent event) {
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
			this.file = event.getFile();
			String[] fileString = this.file.getFileName().split("\\.");
			String fileName = UUID.randomUUID().toString() + "."
					+ fileString[1];
			copyFile(fileName, this.file.getInputStream(), destination);
		} catch (IOException e) {
			messageUploded = "Le fichier n'a pas pu être télécharger";
			FacesMessage facesMessage = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, messageUploded,
					messageUploded);
			FacesContext.getCurrentInstance()
					.addMessage("offerCreationForm:inpPhoto", facesMessage);
		}
		messageUploded = photos.size() + "/4 photos téléchargée(s)";
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
			photo = new ShearingOfferPhoto();
			photo.setLink(fileName);
			photos.add(photo);
			System.out.println("New file created!" + fileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void initOfferParamForCreation() {
		shearingOffer = new ShearingOffer();
		address = null;
		animalCount = null;
		animalDailyPrice = null;
		creationDate = null;
		description = null;
		endDate = null;
		maxTravelDistance = null;
		name = null;
		startDate = null;
		race = null;
		city = null;
		photo = null;
		photos = new HashSet<>();
		file = null;
	}

	public void initOfferParamForModification() {
		address = shearingOffer.getAddress();
		animalCount = shearingOffer.getAnimalCount();
		animalDailyPrice = shearingOffer.getAnimalDailyPrice();
		creationDate = shearingOffer.getCreationDate();
		description = shearingOffer.getDescription();
		endDate = shearingOffer.getEndDate();
		maxTravelDistance = shearingOffer.getMaxTravelDist();
		name = shearingOffer.getName();
		startDate = shearingOffer.getStartDate();
		race = shearingOffer.getRace();
		city = shearingOffer.getZipCodeCity();
		System.out.println("cityyyyyyyyyyy " + city.getName());
		photo = null;
		photos = new HashSet<>();
		file = null;
	}

	public String updateOffer() {
		shearingOffer.setAddress(address);
		shearingOffer.setAnimalCount(animalCount);
		shearingOffer.setAnimalDailyPrice(animalDailyPrice);
		shearingOffer.setDescription(description);
		shearingOffer.setEndDate(endDate);
		shearingOffer.setMaxTravelDist(maxTravelDistance);
		shearingOffer.setName(name);
		shearingOffer.setStartDate(startDate);
		shearingOffer.setRace(race);
		shearingOffer.setZipCodeCity(city);
		shearingOffer = business.update(shearingOffer);
		init();
		return "/offerParameters.xhtml?faces-redirect=true";
	}

	public String withdrawOffer() {
		shearingOffer.setWithdrawalDate(LocalDateTime.now());
		shearingOffer.setOfferWithdrawalReason(offerWithdrawalReason);
		shearingOffer = business.update(shearingOffer);
		init();
		return "/offerParameters.xhtml?faces-redirect=true";
	}

	public String showOffersByFieldLocation(Field selectedField,
			LocalDate serviceStartDate, LocalDate serviceEndDate,
			Integer requiredAnimalCount, Species selectedSpecies) {
		System.out.println("species****************" + selectedSpecies);
		System.out.println(requiredAnimalCount + "++++++++++++++++++++++++");
		shearingOfferSearchResult = new HashSet<ShearingOffer>();
		if (selectedSpecies == null) {
			shearingOfferSearchResult = business.searchOfferByFieldLocation(
					selectedField, serviceStartDate, serviceStartDate,
					requiredAnimalCount);
		} else {
			shearingOfferSearchResult = business
					.searchOfferByFieldLocationAndSpecies(selectedField,
							serviceStartDate, serviceEndDate,
							requiredAnimalCount, selectedSpecies);
		}
		for (ShearingOffer shearingOffer : shearingOfferSearchResult) {
			System.out.println(
					"--------------------------" + shearingOffer.toString());
		}
		return "/offerSearchPage.xhtml?faces-redirect=true";
	}
	
	public String searchResultAsJson() {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(shearingOfferSearchResult);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
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

	public Set<ShearingOffer> getShearingOfferSearchResult() {
		return shearingOfferSearchResult;
	}

	public void setShearingOfferSearchResult(
			Set<ShearingOffer> shearingOfferSearchResult) {
		this.shearingOfferSearchResult = shearingOfferSearchResult;
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public OfferWithdrawalReason getOfferWithdrawalReason() {
		return offerWithdrawalReason;
	}

	public void setOfferWithdrawalReason(
			OfferWithdrawalReason offerWithdrawalReason) {
		this.offerWithdrawalReason = offerWithdrawalReason;
	}

}
