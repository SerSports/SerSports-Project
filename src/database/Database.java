/**
 *  Adapted from http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
 */
package database;

import java.sql.*;

/**
 * @author graydonsvendson
 *
 */
public class Database {
	
	// Constants
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/ser_sports";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	// Members
	//private static Database singleton = null;
	private static Connection conn = null;
	private static Statement stmt = null;
	
	// Methods
	
	public static void close() {
		// Clean-up environment
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Returns a ResultSet - WARNING, this ReturnSet needs to be closed when done!
	public static ResultSet getResultSetFromSQL(String sql) {
		ResultSet result = null;
		
		// Validate the input
		if (isValidSelectSql(sql))
		{
			try {

				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
	
				// Open a connection
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
				// Execute a query - Get the Result Set
				stmt = conn.createStatement();
				result = stmt.executeQuery(sql); 	
				
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}// end try
		}
		
		return result;
	}
	
	private static boolean isValidSelectSql(String sql) {
		boolean result = false;
		
		// Determine if this string is a valid Select Sql Statement
		if (sql != null) {
		
			// Check that it at least contains SELECT and FROM
			if (sql.indexOf("SELECT") != -1 && sql.indexOf("FROM") != -1)
				result = true;
		}
		
		return result;
	}
	
	public static boolean executeSQL(String sql)
	{
		boolean result = false;
		
		// Validate the input
		if (sql != null)
		{
			try {
	
				// Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");
	
				// Open a connection
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
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
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}// nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// end finally try
			}// end try
		}
		
		return result;
	}

	// Default Constructor
	private Database() {
	}
}