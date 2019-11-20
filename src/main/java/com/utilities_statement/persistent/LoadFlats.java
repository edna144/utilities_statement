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
				String flatName = re.getString("description");
				String flatTenant = re.getString("tenant");
				int numResidents = re.getInt("numResidents");
				float flatSpace = re.getFloat("space");
				float flatRent = re.getFloat("rent");
				LocalDate movingDate = re.getDate("movingDate").toLocalDate();
				WaterMeterList wmList = new LoadWaterMeters().loadWaterMeters(flatID);
				boolean isRented = re.getBoolean("isRented");
				
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
