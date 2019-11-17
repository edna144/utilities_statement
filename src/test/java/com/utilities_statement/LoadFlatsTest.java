package com.utilities_statement;

import java.util.List;

import junit.framework.TestCase;

import com.utilities_statement.application.Flat;
import com.utilities_statement.persistent.LoadFlats;

/**
 * Unit test for Flat object
 */
public class LoadFlatsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoadFlatsTest( String testName )
    {
        super( testName );
    }

    /**
     * Flat test
     */
    public void testLoadFlats()
    {
    	List<Flat> flats = new LoadFlats().loadFlats();	
    	Flat flat = flats.get(0);
    	
    	assertEquals( flat.getDescription(), "Geschaeftsraum klein" );
    }
}
