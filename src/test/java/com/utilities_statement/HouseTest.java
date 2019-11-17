package com.utilities_statement;

import java.util.List;

import com.utilities_statement.application.Flat;
import com.utilities_statement.application.House;
import com.utilities_statement.application.WaterMeterList;

import java.util.ArrayList;
import java.time.LocalDate;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class HouseTest extends TestCase
{
	private House house = null;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HouseTest( String testName )
    {
        super( testName );
        
        // initialize flat
        String descrip = "Flat";
    	String tenant = "Tenant";
    	int numResidents = 2;
    	float space = (float) 10.0;
    	float rent = (float) 200.0;
    	LocalDate movingDate = LocalDate.of(2014, 2, 11);
    	WaterMeterList wmList = new WaterMeterList();
    	boolean isRented = true;
    	
    	Flat flat = new Flat(descrip, tenant, numResidents, space, rent, movingDate, wmList, isRented);
        
    	// initialize house
        String houseDescrip = "House1";
    	List<Flat> flats = new ArrayList<Flat>();
    	flats.add(flat);
    	
    	this.house = new House(houseDescrip, flats);
    }

    /**
     * House test
     */
    public void testCreateHouse()
    {
    	String houseDescrip = "House1";
    	List<Flat> flats = new ArrayList<Flat>();
    	
    	House house = new House(houseDescrip, flats);
        assertEquals(house.getDescription(), houseDescrip);
        assertEquals(house.getFlats(), flats);
    }
    public void testCalculateLivingSpace() {
    	assertEquals(this.house.getLivingSpace(), (float) 10.0);   	
    }
    public void testCalculateNumberOfResidents() {
    	assertEquals(this.house.getNumberOfResidents(), 2);
    }
    public void testCalculateTotalRent() {
    	assertEquals(this.house.getTotalRent(), (float) 200.0);
    }
}
