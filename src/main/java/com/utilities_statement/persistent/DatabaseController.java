package com.utilities_statement.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DatabaseController {
	private Statement statement = null;
	
	public DatabaseController() {
		try {
			Connection connect = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			this.statement = connect.createStatement();
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
	public ResultSet runQuery(String sql) {
		ResultSet re = null;
		try {
			re = this.statement.executeQuery(sql);
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
		return re;
	}
	
	public void update(String sql) {
		try {
			this.statement.executeUpdate(sql);
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
}
