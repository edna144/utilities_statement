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
				LocalDate date = co.getDate("date").toLocalDate();
				float valueCold = co.getFloat("cold");
				float valueWarm = co.getFloat("warm");
				float additionalConsumption = co.getFloat("addCon");
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
