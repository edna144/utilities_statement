package com.utilities_statement.client;

import java.time.LocalDate;
import java.util.List;

import com.utilities_statement.client.CommandLineOutput;
import com.utilities_statement.application.Flat;
import com.utilities_statement.application.House;
import com.utilities_statement.application.BillItem;
import com.utilities_statement.application.Bill;
import com.utilities_statement.persistent.LoadFlats;
import com.utilities_statement.persistent.LoadBillItems;


/**
 * Class containing main method
 * 
 * @author Edna
 *
 */

public class Main {
	
	public static void main(String[] args) {
		
		LocalDate year = LocalDate.of(2018, 1, 1);
		List<Flat> flats = new LoadFlats().loadFlats();		
		House house = new House("Haus 1", flats);	
		List<BillItem> billItems = new LoadBillItems().loadBillItems(year);	
		
		Flat flat = flats.get(0);
		Bill bill = new Bill(house, flat, billItems);
		
		CommandLineOutput output = new CommandLineOutput();
		output.print(house);
		output.print(flat);
		output.print(bill, billItems);
		
		//GUI in progress
		//GUI gui = new GUI();
		//gui.launchGUI(args);
		Interface gui = new Interface();
		gui.start();
		
	}
	
}
