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
@Table(name = "anomaly_type")
public class AnomalyType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "type", nullable = false)
	private String type;
	@OneToMany(mappedBy = "anomalyType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Anomaly> anomalies;

	public AnomalyType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Anomaly> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(Set<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

}
