package com.utilities_statement.application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Class to read serialized data from .ser file
 * 
 * @author Edna
 *
 */

public class ReadFlatObject {

	public static Flat readFlat(String filename) {

		Flat flat = null;

		try (ObjectInputStream istream 
			= new ObjectInputStream(new FileInputStream(filename))) {

			flat = (Flat) istream.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flat;
	}
	
	public static Flat[] readFlats(String filename) {

		Flat[] flats = null;

		try (ObjectInputStream istream 
			= new ObjectInputStream(new FileInputStream(filename))) {

			flats = (Flat[]) istream.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Flats loaded");
		return flats;
	}
}
