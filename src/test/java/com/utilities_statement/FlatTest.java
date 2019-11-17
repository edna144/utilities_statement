package com.utilities_statement;

import java.time.LocalDate;

import com.utilities_statement.application.Flat;
import com.utilities_statement.application.WaterMeterList;

import junit.framework.TestCase;

/**
 * Unit test for Flat object
 */
public class FlatTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FlatTest( String testName )
    {
        super( testName );
    }

    /**
     * Flat test
     */
    public void testCreateFlat()
    {
    	String descrip = "Flat";
    	String tenant = "Tenant";
    	int numResidents = 2;
    	float space = (float) 10.0;
    	float rent = (float) 200.0;
    	LocalDate movingDate = LocalDate.of(2014, 2, 3);
    	WaterMeterList wmList = new WaterMeterList();
    	boolean isRented = true;
    	
    	Flat flat = new Flat(descrip, tenant, numResidents, space, rent, movingDate, wmList, isRented);
        
    	assertEquals( flat.getDescription(), descrip );
    	assertEquals( flat.getTenant(), tenant );
    	assertEquals( flat.getNumberOfResidents(), numResidents );
    	assertEquals( flat.getLivingSpace(), space );
    	assertEquals( flat.getRent(), rent );
    	assertEquals( flat.getMovingDate(), movingDate );
    	assertEquals( flat.getWaterMeterList(), wmList );
    	assertEquals( flat.getIsRented(), isRented );
    }
}
