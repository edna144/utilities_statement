package com.utilities_statement;

import com.utilities_statement.application.WaterMeter;
import com.utilities_statement.application.WaterMeterList;
import com.utilities_statement.persistent.LoadWaterMeters;

import junit.framework.TestCase;

/**
 * Unit test for Flat object
 */
public class LoadWaterMetersTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoadWaterMetersTest( String testName )
    {
        super( testName );
    }

    /**
     * Flat test
     */
    public void testLoadWaterMeters()
    {
    	int flatID = 1;
    	WaterMeterList wmList = new LoadWaterMeters().loadWaterMeters(flatID);
    	WaterMeter wm = wmList.get(0);
    	
    	assertEquals( wm.getValueCold(), (float) 55.0 );
    }
}
