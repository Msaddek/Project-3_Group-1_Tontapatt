package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "request_date", nullable = false)
	private LocalDateTime requestDate;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@Column(name = "validation_date", nullable = true)
	private LocalDateTime validationDate;

	@Column(name = "herd_setup_date", nullable = true)
	private LocalDateTime herdSetupDate;

	@Column(name = "equipment_setup_date", nullable = true)
	private LocalDateTime equipmentSetupDate;

	@Column(name = "herd_uninstall_date", nullable = true)
	private LocalDateTime herdUninstallDate;

	@Column(name = "equipment_uninstall_date", nullable = true)
	private LocalDateTime equipmentUninstallDate;

	@Column(name = "refusal_date", nullable = true)
	private LocalDateTime refusalDate;

	@Column(name = "cancellation_date", nullable = true)
	private LocalDateTime cancellationDate;

	@Column(name = "premature_cancellation_date", nullable = true)
	private LocalDateTime prematureCancellationDate;

	@Column(name = "price", nullable = false)
	private Double price;

	@Column(name = "distance", nullable = false)
	private Double distance;

	@Column(name = "invoice_number", nullable = false)
	private String invoiceNumber;

	@Column(name = "required_animal_count", nullable = false)
	private Integer requiredAnimalCount;

	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratings;

	@OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Anomaly> anomalies;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Field field;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private PaymentMethod paymentMethod;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private RefusalReason refusalReason;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private PrematureCancellationReason prematureCancellationReason;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private CancellationReason cancellationReason;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private ShearingOffer shearingOffer;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private GrassHeight grassHeight;

	public Service() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cancellationDate, endDate, equipmentSetupDate,
				equipmentUninstallDate, herdSetupDate, herdUninstallDate,
				prematureCancellationDate, price, distance, refusalDate,
				requestDate, startDate, validationDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		return Objects.equals(cancellationDate, other.cancellationDate)
				&& Objects.equals(endDate, other.endDate)
				&& Objects.equals(equipmentSetupDate, other.equipmentSetupDate)
				&& Objects.equals(equipmentUninstallDate,
						other.equipmentUninstallDate)
				&& Objects.equals(herdSetupDate, other.herdSetupDate)
				&& Objects.equals(herdUninstallDate, other.herdUninstallDate)
				&& Objects.equals(prematureCancellationDate,
						other.prematureCancellationDate)
				&& Objects.equals(price, other.price)
				&& Objects.equals(distance, other.distance)
				&& Objects.equals(refusalDate, other.refusalDate)
				&& Objects.equals(requestDate, other.requestDate)
				&& Objects.equals(startDate, other.startDate)
				&& Objects.equals(validationDate, other.validationDate);
	}

	@Override
	public String toString() {
		return "Service [id=" + id
				+ ", requestDate="
				+ requestDate
				+ ", startDate="
				+ startDate
				+ ", endDate="
				+ endDate
				+ ", validationDate="
				+ validationDate
				+ ", herdSetupDate="
				+ herdSetupDate
				+ ", equipmentSetupDate="
				+ equipmentSetupDate
				+ ", herdUninstallDate="
				+ herdUninstallDate
				+ ", equipmentUninstallDate="
				+ equipmentUninstallDate
				+ ", refusalDate="
				+ refusalDate
				+ ", cancellationDate="
				+ cancellationDate
				+ ", prematureCancellationDate="
				+ prematureCancellationDate
				+ ", price="
				+ price
				+ ", distance="
				+ distance
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(LocalDateTime validationDate) {
		this.validationDate = validationDate;
	}

	public LocalDateTime getHerdSetupDate() {
		return herdSetupDate;
	}

	public void setHerdSetupDate(LocalDateTime herdSetupDate) {
		this.herdSetupDate = herdSetupDate;
	}

	public LocalDateTime getEquipmentSetupDate() {
		return equipmentSetupDate;
	}

	public void setEquipmentSetupDate(LocalDateTime equipmentSetupDate) {
		this.equipmentSetupDate = equipmentSetupDate;
	}

	public LocalDateTime getHerdUninstallDate() {
		return herdUninstallDate;
	}

	public void setHerdUninstallDate(LocalDateTime herdUninstallDate) {
		this.herdUninstallDate = herdUninstallDate;
	}

	public LocalDateTime getEquipmentUninstallDate() {
		return equipmentUninstallDate;
	}

	public void setEquipmentUninstallDate(
			LocalDateTime equipmentUninstallDate) {
		this.equipmentUninstallDate = equipmentUninstallDate;
	}

	public LocalDateTime getRefusalDate() {
		return refusalDate;
	}

	public void setRefusalDate(LocalDateTime refusalDate) {
		this.refusalDate = refusalDate;
	}

	public LocalDateTime getCancellationDate() {
		return cancellationDate;
	}

	public void setCancellationDate(LocalDateTime cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public LocalDateTime getPrematureCancellationDate() {
		return prematureCancellationDate;
	}

	public void setPrematureCancellationDate(
			LocalDateTime prematureCancellationDate) {
		this.prematureCancellationDate = prematureCancellationDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Integer getRequiredAnimalCount() {
		return requiredAnimalCount;
	}

	public void setRequiredAnimalCount(Integer requiredAnimalCount) {
		this.requiredAnimalCount = requiredAnimalCount;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Set<Anomaly> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(Set<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

	public RefusalReason getRefusalReason() {
		return refusalReason;
	}

	public void setRefusalReason(RefusalReason refusalReason) {
		this.refusalReason = refusalReason;
	}

	public PrematureCancellationReason getPrematureCancellationReason() {
		return prematureCancellationReason;
	}

	public void setPrematureCancellationReason(
			PrematureCancellationReason prematureCancellationReason) {
		this.prematureCancellationReason = prematureCancellationReason;
	}

	public CancellationReason getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(CancellationReason cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

	public GrassHeight getGrassHeight() {
		return grassHeight;
	}

	public void setGrassHeight(GrassHeight grassHeight) {
		this.grassHeight = grassHeight;
	}

}
