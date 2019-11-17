package com.utilities_statement.application;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Data container modelling a single Flat
 * 
 * @author Edna
 *
 */

public class Flat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String description = new String();
	private String tenant = new String();
	private int numberOfResidents = 0;
	private float space = 0;
	private float rent = 0;
	private LocalDate movingDate;
	private boolean isRented = false;
	private WaterMeterList watermeterlist = new WaterMeterList();

	public Flat(String description, String tenant, int numberOfResidents, float space, 
			float rent, LocalDate movingDate, WaterMeterList watermeterlist, boolean isRented) {
		
		this.description = description;
		this.tenant = tenant;
		this.numberOfResidents = numberOfResidents;
		this.space = space;
		this.rent = rent;
		this.movingDate = movingDate;
		this.isRented = isRented;
		this.watermeterlist = watermeterlist;
	}
	
	// GETTERS
	
	public String getDescription() {
		return description;
	}
	public String getTenant() {
		return tenant;
	}
	public int getNumberOfResidents() {
		return numberOfResidents;
	}
	public float getLivingSpace() {
		return space;
	}
	public float getRent() {
		return rent;
	}
	public LocalDate getMovingDate() {
		return movingDate;
	}
	public boolean getIfRented() {
		return isRented;
	}
	public WaterMeterList getWaterMeterList() {
		return watermeterlist;
	}
	public boolean getIsRented() {
		return isRented;
	}
	
}
