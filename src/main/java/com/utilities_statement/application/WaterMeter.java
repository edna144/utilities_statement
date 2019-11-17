package com.utilities_statement.application;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @author Edna
 *
 */

public class WaterMeter implements Serializable{
	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private float valueCold;
	private float valueWarm;
	private float additionalConsumption;
	
	public WaterMeter(LocalDate date, float valueCold, float valueWarm, float additionalConsumption) {
		this.date = date;
		this.valueCold = valueCold;
		this.valueWarm = valueWarm;
		this.additionalConsumption = additionalConsumption;
	}
	
	// GETTER
	
	public LocalDate getDate() {
		return date;
	}
	public float getValueCold() {
		return valueCold;
	}
	public float getValueWarm() {
		return valueWarm;
	}
	public float getAdditionalConsumption() {
		return additionalConsumption;
	}
	
	// SETTER
	
	public void setAdditionalConsumption(float additionalConsumption) {
		this.additionalConsumption = additionalConsumption;
	}
	
}
