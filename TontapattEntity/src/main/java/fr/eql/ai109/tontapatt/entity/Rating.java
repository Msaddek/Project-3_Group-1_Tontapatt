package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "rating_level", nullable = false)
	private Integer ratingLevel;
	@Column(name = "feedback", nullable = true)
	private String feedback;
	@Column(name = "rating_date", nullable = false)
	private LocalDateTime ratingDate;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Service service;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private User evaluator;

	public Rating() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(feedback, ratingDate, ratingLevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rating other = (Rating) obj;
		return Objects.equals(feedback, other.feedback)
				&& Objects.equals(ratingDate, other.ratingDate)
				&& Objects.equals(ratingLevel, other.ratingLevel);
	}

	@Override
	public String toString() {
		return "Rating [id=" + id
				+ ", ratingLevel="
				+ ratingLevel
				+ ", feedback="
				+ feedback
				+ ", ratingDate="
				+ ratingDate
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRatingLevel() {
		return ratingLevel;
	}

	public void setRatingLevel(Integer ratingLevel) {
		this.ratingLevel = ratingLevel;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getRatingDate() {
		return ratingDate;
	}

	public void setRatingDate(LocalDateTime ratingDate) {
		this.ratingDate = ratingDate;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(User evaluator) {
		this.evaluator = evaluator;
	}

}
