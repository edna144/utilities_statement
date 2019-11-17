package com.utilities_statement.persistent;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.utilities_statement.application.Flat;
import com.utilities_statement.application.WaterMeterList;
import com.utilities_statement.persistent.LoadWaterMeters;

/**
 * Loads all flats from database
 * 
 * @author Edna
 *
 */

public class LoadFlats extends DatabaseController {
	
	private List<Flat> flats = new ArrayList<Flat>();

	public List<Flat> loadFlats() {
		String sql = "SELECT * FROM flat";
		ResultSet re = runQuery(sql);
		
		try {
			while( re.next() ) {
				int flatID = re.getInt(1);
				String flatName = re.getString(2);
				String flatTenant = re.getString(3);
				int numResidents = re.getInt(4);
				float flatSpace = re.getFloat(5);
				float flatRent = re.getFloat(6);
				LocalDate movingDate = re.getDate(7).toLocalDate();
				WaterMeterList wmList = new LoadWaterMeters().loadWaterMeters(flatID);
				boolean isRented = re.getBoolean(8);
				
				Flat flat = new Flat(flatName, flatTenant, numResidents, flatSpace, flatRent, movingDate, wmList, isRented);
				this.flats.add(flat);
			}	
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
		
		return this.flats;
	}
	
}
