package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbDate")
@SessionScoped
public class DateManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDate maximumDate = LocalDate.now().minusYears(18);

	private LocalDate minimumDate = LocalDate.now().minusYears(99);

	public LocalDate getMaximumDate() {
		return maximumDate;
	}

	public LocalDate getMinimumDate() {
		return minimumDate;
	}

}
