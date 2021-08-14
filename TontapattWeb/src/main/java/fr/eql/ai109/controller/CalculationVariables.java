package fr.eql.ai109.controller;

public interface CalculationVariables {

	final Integer SURFACE_ANIMAL_JOUR = 6;

	final Double VAT = 0.2;

	final Double DIESEL_TRUCK_CONSUMPTION = 0.342; // truck consumption l/km

	final Double DIESEL_LITER_PRICE = 1.434; // price 1l of diesel

	final Double DIESEL_CAR_CONSUMPTION = 0.0731; // car consuption l/km

	Double TRUCK_CONSUMPTION_PRICE = DIESEL_TRUCK_CONSUMPTION
			* DIESEL_LITER_PRICE;

	Double CAR_CONSUPTION_PRICE = DIESEL_CAR_CONSUMPTION * DIESEL_LITER_PRICE;

}
