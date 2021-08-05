package fr.eql.ai109.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
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

import fr.eql.ai109.ibusiness.FieldPhotoIBusiness;
import fr.eql.ai109.tontapatt.entity.Field;
import fr.eql.ai109.tontapatt.entity.FieldPhoto;

@ManagedBean(name = "mbFieldPhoto")
@SessionScoped
public class FieldPhotoManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	FieldPhotoIBusiness business;
	private FieldPhoto fieldPhoto;

	@ManagedProperty(value = "#{mbField.field}")
	private Field selectedField;
	private Set<FieldPhoto> selectedFieldPhotos;

	@PostConstruct()
	public void init() {
		selectedFieldPhotos = business.findPhotosByField(selectedField);
	}

	public void uploadPhoto(FileUploadEvent event) {
		URL url = null;
		String destination = null;
		String messageUploded = null;
		try {
			url = FacesContext.getCurrentInstance().getExternalContext().getResource("/");
			destination = url.getPath() + "/resources/img/fields/";
		} catch (MalformedURLException e1) {
			messageUploded = "Le fichier n'a pas pu être téléchargé";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageUploded, messageUploded);
			FacesContext.getCurrentInstance().addMessage("fieldRegistrationForm:inpPhoto", facesMessage);
			e1.printStackTrace();
		}
		// Do what you want with the file
		try {
			String[] file = event.getFile().getFileName().split("\\.");
			String fileName = UUID.randomUUID().toString() + "." + file[1];
			copyFile(fileName, event.getFile().getInputStream(), destination);
		} catch (IOException e) {
			messageUploded = "Le fichier n'a pas pu être téléchargé";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, messageUploded, messageUploded);
			FacesContext.getCurrentInstance().addMessage("fieldRegistrationForm:inpPhoto", facesMessage);
			e.printStackTrace();
		}
		messageUploded = "Téléchargement fait!";
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, messageUploded, messageUploded);
		FacesContext.getCurrentInstance().addMessage("fieldRegistrationForm:inpPhoto", facesMessage);
	}

	private void copyFile(String fileName, InputStream in, String destination) {
		try (OutputStream out = new FileOutputStream(new File(destination + fileName))) {
			// write the inputStream to a FileOutputStream;
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			System.out.println(fileName);
			FieldPhoto fp = new FieldPhoto();
			fp.setLink(fileName);
			fp.setId(1);
			//fp.setField(new Field().setId(2));
			selectedFieldPhotos.add(fp);
			System.out.println("New file created!" + fileName);
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public FieldPhoto getFieldPhoto() {
		return fieldPhoto;
	}

	public void setFieldPhoto(FieldPhoto fieldPhoto) {
		this.fieldPhoto = fieldPhoto;
	}

	public Field getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(Field selectedField) {
		this.selectedField = selectedField;
	}

	public Set<FieldPhoto> getSelectedFieldPhotos() {
		return selectedFieldPhotos;
	}

	public void setSelectedFieldPhotos(Set<FieldPhoto> selectedFieldPhotos) {
		this.selectedFieldPhotos = selectedFieldPhotos;
	}

}
