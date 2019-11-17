package com.utilities_statement.persistent;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.utilities_statement.application.Article;
import com.utilities_statement.application.BillItem;
import com.utilities_statement.application.BillUnit;

/**
 * Loads all flats from database
 * 
 * @author Edna
 *
 */

public class LoadBillItems extends DatabaseController {
	
	private List<BillItem> billItems = new ArrayList<BillItem>();

	public List<BillItem> loadBillItems(LocalDate year) {
		String sql = "SELECT * FROM billitem WHERE year = '" + Date.valueOf(year) + "'";
		ResultSet re = runQuery(sql);
		
		try {
			while( re.next() ) {
				Article article = Article.valueOf(re.getString(2));
				float billValue = re.getFloat(3);
				BillUnit billUnit = BillUnit.valueOf(re.getString(4));
				
				BillItem billItem = new BillItem(article, billValue, billUnit, year);
				this.billItems.add(billItem);
			}	
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
		
		return this.billItems;
	}
	
}
