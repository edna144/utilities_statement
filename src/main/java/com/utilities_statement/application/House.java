package com.utilities_statement.application;

import java.util.List;

/**
 * House object containing corresponding Flat objects
 * internally calculating total living space, number of residents, total rent
 * 
 * @author Edna
 *
 */

public final class House {
	private final String description;
	private final float space;
	private final int numberOfResidents;
	private final float totalRent;
	private final List<Flat> flats;

	public House(String description, List<Flat> flats) {
		this.description = description;
		this.flats = flats;
		
		this.space = calculateLivingSpace();
		this.numberOfResidents = calculateNumberOfResidents();
		this.totalRent = calculateTotalRent();
	}
	
	private int calculateLivingSpace() {
		int sumLivingSpace = 0;
		for(Flat flt : this.flats) {
			sumLivingSpace += flt.getLivingSpace();
		}
		return sumLivingSpace;
	}
	
	private int calculateNumberOfResidents() {
		int numberOfResidents = 0;
		for(Flat flt : this.flats) {
			numberOfResidents += flt.getNumberOfResidents();
		}
		return numberOfResidents;
	}
	
	private float calculateTotalRent() {
		float totalRent = 0;
		for(Flat flt : this.flats) {
			totalRent += flt.getRent();
		}
		return totalRent;
	}
	
	// GETTER
	
	public String getDescription() {
		return description;
	}
	public List<Flat> getFlats() {
		return flats;
	}
	public float getLivingSpace() {
		return space;
	}
	public int getNumberOfResidents() {
		return numberOfResidents;
	}
	public int getNumberOfFlats() {
		return flats.size();
	}
	public float getTotalRent() {
		return totalRent;
	}
}
