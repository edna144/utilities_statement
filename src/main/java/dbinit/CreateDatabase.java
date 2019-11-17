package dbinit;

import java.sql.DriverManager;

/**
 * Creates database .mv file
 * 
 * @author Edna
 *
 */

public class CreateDatabase {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.h2.Driver");
		DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
		System.out.println("Database was created.");
	}
	
}
