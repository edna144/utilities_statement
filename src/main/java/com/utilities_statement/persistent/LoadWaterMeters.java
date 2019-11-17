package com.utilities_statement.persistent;

import java.sql.ResultSet;
import java.time.LocalDate;

import com.utilities_statement.application.WaterMeter;
import com.utilities_statement.application.WaterMeterList;

/**
 * Loads all WaterMeter data of single flat from database
 * 
 * @author Edna
 *
 */

public class LoadWaterMeters extends DatabaseController {
	
	private WaterMeterList wmList = new WaterMeterList();

	public WaterMeterList loadWaterMeters(int fid) {
		
		String sql = "SELECT * FROM watermeter WHERE flatid = " + fid;
		ResultSet co = runQuery(sql);
		try {					
			while( co.next() ) {
				LocalDate date = co.getDate(3).toLocalDate();
				float valueCold = co.getFloat(4);
				float valueWarm = co.getFloat(5);
				float additionalConsumption = co.getFloat(6);
				WaterMeter wm = new WaterMeter(date, valueCold, valueWarm, additionalConsumption);
				this.wmList.add(wm);
			}
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
		
		return this.wmList;
	}
	
}
