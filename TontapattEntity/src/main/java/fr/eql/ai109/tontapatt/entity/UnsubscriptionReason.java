package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "unsubscription_reason")
public class UnsubscriptionReason implements Serializable {

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
	@OneToMany(mappedBy = "unsubscriptionReason", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users;

	public UnsubscriptionReason() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(reason);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnsubscriptionReason other = (UnsubscriptionReason) obj;
		return Objects.equals(reason, other.reason);
	}

	@Override
	public String toString() {
		return "UnsubscriptionReason [id=" + id + ", reason=" + reason + "]";
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
