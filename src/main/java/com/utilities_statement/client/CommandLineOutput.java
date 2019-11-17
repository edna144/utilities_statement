package com.utilities_statement.client;

import java.util.Locale;
import java.util.List;

import com.utilities_statement.application.Bill;
import com.utilities_statement.application.BillItem;
import com.utilities_statement.application.Flat;
import com.utilities_statement.application.House;

/**
 * GUI in progress
 * 
 * @author Edna
 *
 */
public class CommandLineOutput {
	private String highlight = "-------------------------------------------------------\n";
	private String highlight2 = "\t\t\t\t\t ======";
	
	public void print(House house) {
		System.out.println(highlight 
				+ house.getDescription() + "\n"
				+ highlight 
				+ "total flats:\t\t" + house.getNumberOfFlats() + "\n"
				+ "total residents:\t" + house.getNumberOfResidents() + "\n"
				+ "total living space:\t" + house.getLivingSpace());
		
		printEnd();
		System.out.println("FLATS");
		for (Flat flat : house.getFlats()) {
			System.out.println(flat.getDescription());
		}
		
		printEnd();
	}
	
	public void print(Flat flat) {
		System.out.println(highlight
				+ flat.getDescription() + "\n"
				+ highlight
				+ "tenant:\t\t\t" + flat.getTenant() + "\n"
				+ "number of residents:\t" + flat.getNumberOfResidents() + "\n"
				+ "rent:\t\t\t" + flat.getRent());
		
		printEnd();
	}
	
	public void print(Bill bill, List<BillItem> totalbill) {
		System.out.println(highlight
				+ "Bill for " + pad30(bill.getTenant()) + bill.getDate().getYear() + "\n"
				+ highlight
				+ "ITEM\t\t\tUNIT\t\tVALUE\tTOTAL");
		
		List<BillItem> singlebill = bill.getBillItems();
		for (int i = 0; i < singlebill.size(); i++) {
			BillItem sitem = singlebill.get(i);
			BillItem titem = totalbill.get(i);
			System.out.println(pad20(sitem.getArticle().toString()) + "\t" 
					+ pad10(sitem.getUnit().toString()) + "\t" 
					+ format(sitem.getBillValue()) + "\t" 
					+ format(titem.getBillValue()));
		}
		
		float totalSum = 0;
		for (BillItem titem : totalbill) {
			totalSum += titem.getBillValue();
		}
		
		System.out.println(highlight
				+ "SUM\t\t\t\t\t" + format(bill.getSum()) + "\t" + format(totalSum)+ "\n"
				+ highlight2);
	}
	
	private void printEnd() {
		System.out.print("\n");
	}
	private String format(float value) {
		return String.format(Locale.US, "%7.2f", value);
	}
	private String pad30(String string) {
		return String.format("%-30s", string);
	}
	private String pad20(String string) {
		return String.format("%-20s", string);
	}
	private String pad10(String string) {
		return String.format("%-10s", string);
	}
}
