package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cancellation_reason")
public class CancellationReason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "reason", nullable = false)
	private String reason;
	@OneToMany(mappedBy = "cancellationReason", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Service> services;

	public CancellationReason() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

}
