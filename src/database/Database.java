/*
File: 
Author:	@graydonsvendson
   **Adapted from http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm**
Date:	

Description: 

 */
package database;

import gui.MainGUI;

import java.sql.*;

import javax.swing.JOptionPane;



/**
Class:	Database

Description: 
*/
public class Database {	
	
	// Members
	//private static Database singleton = null;
	private static Connection conn = null;
	private static Statement stmt = null;
	
	// Methods
	
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	public static void close() {
		// Clean-up environment
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	// Returns a ResultSet - WARNING, this ReturnSet needs to be closed when done!
	public static ResultSet getResultSetFromSQL(String sql) {
		ResultSet result = null;
		
		MainGUI.setHourGlass(true);
		
		// Validate the input
		if (isValidSelectSql(sql)) {
			try {
				SerSports_DbConnectionProperties props = new SerSports_DbConnectionProperties();

				// Register JDBC driver
				Class.forName(props.get_JDBC_DRIVER());
	
				// Open a connection
				conn = DriverManager.getConnection(props.get_DB_URL(), props.get_USER(), props.get_PASS());
	
				// Execute a query - Get the Result Set
				stmt = conn.createStatement();
				result = stmt.executeQuery(sql); 	
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				//se.printStackTrace();
				JOptionPane.showMessageDialog(null, "Unable to connect to Database!!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}// end try
		}

		MainGUI.setHourGlass(false);
		
		return result;
	}
	
	private static boolean isValidSelectSql(String sql) {
		boolean result = false;
		
		// Determine if this string is a valid Select Sql Statement
		if (sql != null) {
		
			// Check that it at least contains SELECT and FROM
			if (sql.indexOf("SELECT") != -1 && sql.indexOf("FROM") != -1) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	public static boolean executeSQL(String sql) {
		boolean result = false;
		
		// Validate the input
		if (sql != null) {
			try {
				SerSports_DbConnectionProperties props = new SerSports_DbConnectionProperties();
	
				// Register JDBC driver
				Class.forName(props.get_JDBC_DRIVER());
	
				// Open a connection
				conn = DriverManager.getConnection(props.get_DB_URL(), props.get_USER(), props.get_PASS());
	
				// Execute a query - Get the Result Set
				stmt = conn.createStatement();
				result = !stmt.execute(sql);
				
				// Clean-up environment
				stmt.close();
				conn.close();
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException se2) {
				}// nothing we can do
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}// end finally try
			}// end try
		}
		
		return result;
	}

	 /**
	  Method: Constructor
	  Inputs: 
	  Returns:

	  Description: 
	*/
	// Default Constructor
	private Database() {
	}
	
	/**
	  Method: formatSqlStringValue
	  Inputs: String value_in
	  Returns: String result

	  Description: This method is used when putting a value into an SQL String.  
	  					This method will enclose the value in quotes as well as replace 
	  					it with Null if the String is null.
	*/
	public static String formatSqlStringValueForInsert(String value_in) {
		StringBuilder builder = new StringBuilder();
		
		// Check if the value is null
		if (value_in == null) {
			builder.append("Null");
		} else {
			builder.append("\"");
			builder.append(value_in);
			builder.append("\"");
		}
		
		return builder.toString();
	}
}