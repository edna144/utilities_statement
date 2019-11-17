package com.utilities_statement.application;

import java.util.Calendar;
import java.io.Serializable;

/**
 * Class for Date configuration
 * 
 * @author Edna
 *
 */

public final class DateUtils implements Serializable{
	private static final long serialVersionUID = 1L;
	Calendar cal = null;
	
    public DateUtils() {
    	cal = Calendar.getInstance();
    }
    
    public DateUtils(int year, int month, int day) {
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
    }

    public void setDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
    }
    public Calendar getDate() {
    	return cal;
    }
    public void printDate() {
    	System.out.println(cal.getTime());
    }

}
