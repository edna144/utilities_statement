package com.utilities_statement.application;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Calculates share per flat
 * 
 * @author Edna
 *
 */

public class Bill {
	List<BillItem> bill;
	String tenant;
	LocalDate date;
	
	public Bill(House house, Flat flat, List<BillItem> totalbill) {
		
		this.bill = new ArrayList<BillItem>();
		
		setTenant(flat.getTenant());
		setDate(totalbill.get(0).getYear());
		
		create(house, flat, totalbill);
	}
	
	/**
	 * Calculates the share of one flat for each bill item in bill
	 * 
	 * @param house House object
	 * @param flat Flat object
	 * @param totalbill BillItem list
	 * @return bill for specified flat
	 */
	public List<BillItem> create(House house, Flat flat, List<BillItem> totalbill) {
		for(BillItem billitem : totalbill) {
			float share = getAmount(house, flat, billitem);
			BillItem item = new BillItem(billitem.getArticle(), share, billitem.getUnit(), billitem.getYear());
			this.bill.add(item);
		}
		return this.bill;
	}
	
	/**
	 * Sums all values from all bill items in bill
	 * 
	 * @return sum
	 */
	public float getSum() {
		float sum = 0;
		for(BillItem item : this.bill) {
			sum += item.getBillValue();
		}
		return sum;
	}
	
	/**
	 * Calculates share for a single bill item
	 * 
	 * @param house House object
	 * @param flat Flat object
	 * @param billItem BillItem object
	 * @return billing amount
	 */
	private float getAmount(House house, Flat flat, BillItem billitem) {
		float flatValue;
		float totalValue;
		
		// calculate share based on total value
		// e.g. if unit is SPACE, calculate share based on total living space in the house
		switch(billitem.getUnit()){
			case FLAT:
				flatValue = 1;
				totalValue = house.getNumberOfFlats();
				break;
			case SPACE:
				flatValue = flat.getLivingSpace();
				totalValue = house.getLivingSpace();
				break;
			case NUMRESIDENTS:
				flatValue = flat.getNumberOfResidents();
				totalValue = house.getNumberOfResidents();
				break;
			case CONSUMPTION:
				return 0;
			default:
				throw new IllegalArgumentException("Unit type is unknown.");
		}
		
		float amount = billitem.getBillValue() / totalValue * flatValue;
		return amount;
	}
	
	public String getTenant() {
		return this.tenant;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public List<BillItem> getBillItems() {
		return this.bill;
	}
	public float getBillValueByArticle(Article article) {
		float value = -1; 
		for (BillItem item : this.bill) {
			if (item.getArticle() == article) {
				value = item.getBillValue();
			}
		}
		if (value == -1) {
			System.err.print("Bill: Requested article type not found");
		}
		return value;
	}
	
	private void setTenant(String tenant) {
		this.tenant = tenant;
	}
	private void setDate(LocalDate date) {
		this.date = date;
	}
}
