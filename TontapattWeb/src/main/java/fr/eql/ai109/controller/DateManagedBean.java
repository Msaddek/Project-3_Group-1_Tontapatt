package fr.eql.ai109.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	private LocalDate minimumOfferEndDate;
	
	private LocalDate minimumServiceStartDate = LocalDate.now().plusDays(3);
	
	private LocalDate minimumServiceEndDate;

	public void calculateMinimumOfferEndDate(LocalDate startDate) {

		minimumOfferEndDate = startDate.plusDays(1);
	}
	public void calculateMinimumServiceEndDate(LocalDate startDate) {
		minimumServiceEndDate = startDate.plusDays(1);
	}
	
	public String localDateTimeFormatter(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy");
        return localDateTime.format(formatter);
    }
	
	public String localDateFormatter(LocalDate localDate) {
		 DateTimeFormatter formatter = DateTimeFormatter
	                .ofPattern("dd/MM/yyyy");
	        return localDate.format(formatter);
	}
	
	public String localDateTimeFormatterWithHour(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy HH:mm");
        return localDateTime.format(formatter);
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

	/**
	 * @return the minimumServiceStartDate
	 */
	public LocalDate getMinimumServiceStartDate() {
		return minimumServiceStartDate;
	}

	/**
	 * @return the minimumServiceEndDate
	 */
	public LocalDate getMinimumServiceEndDate() {
		return minimumServiceEndDate;
	}

}
