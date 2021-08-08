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

	private LocalDate maximumAgeDate = LocalDate.now().minusYears(18);

	private LocalDate minimumAgeDate = LocalDate.now().minusYears(99);

	private LocalDate minimumOfferStartDate = LocalDate.now();

	private LocalDate minimumOfferEndDate = LocalDate.now();

	public void minimumOfferEndDate(LocalDate startDate) {

		minimumOfferEndDate = startDate.plusDays(1);
	}

	public LocalDate getMaximumAgeDate() {
		return maximumAgeDate;
	}

	public LocalDate getMinimumAgeDate() {
		return minimumAgeDate;
	}

	public LocalDate getMinimumOfferStartDate() {
		return minimumOfferStartDate;
	}

	public LocalDate getMinimumOfferEndDate() {
		return minimumOfferEndDate;
	}

}
