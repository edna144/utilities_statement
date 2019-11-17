package com.utilities_statement.application;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Serializes a Flat object or Flat object list 
 * 
 * @author Edna
 *
 * @see Flat
 */

public abstract class WriteFlatObject {

	public static void writeFlat(Flat flat, String filePath) {

		try (ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream(filePath))) {

			oos.writeObject(flat);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static void writeFlats(Flat[] flats, String filePath) {

		try (ObjectOutputStream ostream = 
				new ObjectOutputStream(new FileOutputStream(filePath))) {

			ostream.writeObject(flats);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
