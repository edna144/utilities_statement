package com.utilities_statement;

import java.time.LocalDate;

import com.utilities_statement.application.WaterMeter;

import junit.framework.TestCase;

/**
 * Unit test for Flat object
 */
public class WaterMeterTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WaterMeterTest( String testName )
    {
        super( testName );
        
    }

    /**
     * WaterMeter test
     */
    public void testWaterMeter()
    {
    	LocalDate date = LocalDate.of(2014, 2, 11);
        float valueCold = (float) 10.0;
        float valueWarm = (float) 20.0;
        float addConsump = (float) 5.0;
        WaterMeter wm = new WaterMeter(date, valueCold, valueWarm, addConsump);
    	
        assertEquals( wm.getDate(), date );
    	assertEquals( wm.getValueCold(), valueCold );
    	assertEquals( wm.getValueWarm(), valueWarm );
    	assertEquals( wm.getAdditionalConsumption(), addConsump );
    }
    public void testSetAdditionalConsumption() {
    	LocalDate date = LocalDate.of(2014, 2, 11);
        float valueCold = (float) 10.0;
        float valueWarm = (float) 20.0;
        float addConsump = (float) 5.0;
        WaterMeter wm = new WaterMeter(date, valueCold, valueWarm, addConsump);
    	
        float newValue = (float) 15.0;
        wm.setAdditionalConsumption(newValue);
        
        assertEquals( wm.getAdditionalConsumption(), newValue );
    }
}
