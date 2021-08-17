package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import fr.eql.ai109.ibusiness.AnomalyIBusiness;
import fr.eql.ai109.tontapatt.entity.Anomaly;
import fr.eql.ai109.tontapatt.entity.AnomalyType;
import fr.eql.ai109.tontapatt.entity.Service;
import fr.eql.ai109.tontapatt.entity.User;

/**
 *
 *
 */
@ManagedBean(name = "mbAnomaly")
@SessionScoped
public class AnomalyManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	AnomalyIBusiness business;

	@ManagedProperty(value = "#{mbUser.user}")
	private User connectedUser;

	private Anomaly anomaly;

	private Set<Anomaly> anomalies;

	private AnomalyType anomalyType;

	private String description;

	public String declareAnomaly(Service selectedService) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyyMMddHHmmssSS");
        Anomaly newAnomaly = new Anomaly();
        newAnomaly.setAnomalyNumber(
                "ANO-" + LocalDateTime.now().format(formatter));
        newAnomaly.setDeclarer(connectedUser);
        newAnomaly.setService(selectedService);
        newAnomaly.setCreationDate(LocalDateTime.now());
        newAnomaly.setDescription(description);
        newAnomaly.setAnomalyType(anomalyType);
        anomaly = business.add(newAnomaly);
        if (selectedService.getField().getOwner().equals(connectedUser)) {
            return "/selectedServiceOwner.xhtml?faces-redirect=true";
        }
        return "/selectedServiceBreeder.xhtml?faces-redirect=true";
    }

	public String closeAnomaly(Service selectedService) {
        anomaly.setEndDate(LocalDateTime.now());
        anomaly = business.update(anomaly);
        if (selectedService.getField().getOwner().equals(connectedUser)) {
            return "/selectedServiceOwner.xhtml?faces-redirect=true";
        }
        return "/selectedServiceBreeder.xhtml?faces-redirect=true";
    }
	
	public void selectAnomaly(Anomaly selectedAnomaly) {
		anomaly = selectedAnomaly;
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('dlg1').show();");
	}

	public Set<Anomaly> allAnonomaliesByService(Service selectedService) { 
		return anomalies = business.getAllByService(selectedService);
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public Anomaly getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(Anomaly anomaly) {
		this.anomaly = anomaly;
	}

	public Set<Anomaly> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(Set<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

	public AnomalyType getAnomalyType() {
		return anomalyType;
	}

	public void setAnomalyType(AnomalyType anomalyType) {
		this.anomalyType = anomalyType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
