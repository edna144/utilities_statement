package com.utilities_statement;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.utilities_statement.application.House;
import com.utilities_statement.application.Flat;
import com.utilities_statement.application.WaterMeterList;
import com.utilities_statement.application.Article;
import com.utilities_statement.application.Bill;
import com.utilities_statement.application.BillItem;
import com.utilities_statement.application.BillUnit;

/**
 * Unit test for Flat object
 */
public class BillTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BillTest( String testName )
    {
        super( testName );
    }

    /**
     * Flat test
     */
    public void testCreate()
    {
    	LocalDate date = LocalDate.of(2000, 1, 1);
    	//					description tenant	people		space			rent  moving date	watermeterlist
    	Flat flat1 = new Flat("desc1", "tenant1", 3, (float) 10.0, (float) 200.0, date, new WaterMeterList(), true);
    	Flat flat2 = new Flat("desc2", "tenant2", 1, (float) 30.0, (float) 300.0, date, new WaterMeterList(), true);
    	List<Flat> flats = new ArrayList<Flat>();
    	flats.add(flat1);
    	flats.add(flat2);
    	House house = new House("house 1", flats);
    	
    	BillItem item1 = new BillItem(Article.ELECTRICITY, (float) 100.0, BillUnit.NUMRESIDENTS, date);
    	BillItem item2 = new BillItem(Article.GAS, (float) 100.0, BillUnit.SPACE, date);
    	BillItem item3 = new BillItem(Article.STREET_CLEANING, (float) 100.0, BillUnit.FLAT, date);
    	List<BillItem> billList = new ArrayList<BillItem>();
    	billList.add(item1);
    	billList.add(item2);
    	billList.add(item3);
    	
    	Bill bill = new Bill(house, flat1, billList);
    	
    	// flat1 has to pay 3/4 of the electricity bill, because its houses 3 people and 
    	// the house has 4 people in total
    	assertEquals( bill.getBillValueByArticle(Article.ELECTRICITY), (float) 75.0 );
    	
    	// flat 1 has to pay 1/4 of the gas bill, because it has 10 qm space and the house total is 30 qm
    	assertEquals( bill.getBillValueByArticle(Article.GAS), (float) 25.0 );
    	
    	// flat 1 has to pay 1/2 of the street cleaning bill, because there are 2 flats in the house
    	assertEquals( bill.getBillValueByArticle(Article.STREET_CLEANING), (float) 50.0 );
    }
}
