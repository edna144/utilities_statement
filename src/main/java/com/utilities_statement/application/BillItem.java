package com.utilities_statement.application;

import java.time.LocalDate;

/**
 * Defines an item of an invoice
 * 
 * @author Edna
 *
 */

public class BillItem {
	private Article article;
	private float value;
	private BillUnit unit;
	private LocalDate year;

	public BillItem(Article article, float value, BillUnit unit, LocalDate year) {
		this.article = article;
		this.value = value;
		this.unit = unit;
		this.year = year;
	}
	
	// GETTER
	
	public Article getArticle() {
		return article;
	}
	public float getBillValue() {
		return value;
	}
	public float getValuePerUnit(float units) {
		return value / units;
	}
	public BillUnit getUnit() {
		return unit;
	}
	public LocalDate getYear() {
		return year;
	}

	// SETTER
	
	public void setBillValue(float value) {
		this.value = value;
	}
}
