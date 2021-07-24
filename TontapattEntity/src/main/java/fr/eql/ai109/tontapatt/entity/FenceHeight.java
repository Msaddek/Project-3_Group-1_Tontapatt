package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fence_height")
public class FenceHeight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "height", nullable = false)
	private String height;
	@ManyToMany
	@JoinTable(name = "favorite_fence_height", 
	joinColumns = @JoinColumn(name = "fence_id"),
	inverseJoinColumns = @JoinColumn(name = "species_id"))
	private Set<Species> species;

}
