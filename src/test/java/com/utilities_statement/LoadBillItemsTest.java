package com.utilities_statement;

import java.time.LocalDate;
import java.util.List;

import com.utilities_statement.application.BillItem;
import com.utilities_statement.persistent.LoadBillItems;

import junit.framework.TestCase;

/**
 * Unit test for Flat object
 */
public class LoadBillItemsTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LoadBillItemsTest( String testName )
    {
        super( testName );
    }

    /**
     * Flat test
     */
    public void testLoadBillItems()
    {
    	LocalDate year = LocalDate.of(2019, 1, 1);
    	List<BillItem> billItems = new LoadBillItems().loadBillItems(year);
        
    	BillItem item = billItems.get(0);
    	
    	assertEquals( item.getBillValue(), (float) 230.0 );
    }
}
