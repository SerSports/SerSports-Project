import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import database.Database;
import database.MlbPlayer;

/* Possible libraries for future use
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Types;
*/


public class MLBPlayerSearch {

	private Connection dbConn = null;  //will get more info from JDBC
	
	//constructor
	public MLBPlayerSearch(){
	}
	
	//constructor with 3 parameters
	public MLBPlayerSearch(String fName, String lName, String team) {
	}
	
	//GETTER: Takes a query, returns a result set
	private ResultSet getRS(String myQuery) {
		Statement stmt = null;
	    ResultSet rs = null;
	      
	    try{ 
	         stmt = dbConn.createStatement();
	         rs = stmt.executeQuery(myQuery);
	    } catch(Exception e) { 
	         e.printStackTrace();
	    }
	      
	    return rs;  
	}
	
	// Static Methods
	public static ArrayList<MlbPlayer> getListOfPlayersFromDatabase() {
		
		ArrayList<MlbPlayer> resultList = new ArrayList<MlbPlayer>();
		
		// Get the Result Set containing every Player
		ResultSet rs = Database.getResultSetFromSQL("SELECT * FROM " + MlbPlayer.TABLE_NAME);
		if (rs != null)
		{
			// Loop through the Result Set and Add Each MlbPlayer to the ArrayList
			try {
				while(rs.next()){
					MlbPlayer player = new MlbPlayer(rs);
					resultList.add(player);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return resultList;
	}

/*
	public List<String> professionalPlayerSearch(String str){
		String table_name = "";
		String team_name = "name";
		String query = "SELECT "+team_name+" FROM"+table_name+"WHERE first_name=\""+str+"\"";
		ResultSet rs = getRS(query);
		List<String> playerList = convertToListString(rs, "player");
		return playerList;
	}
*/


	
	//CONVERSION: ResultSet to a List<String>
	private List<String> convertToListString(ResultSet rs, String label) { 
		List<String> myList = new ArrayList<String>();
	    
		try{
	    	rs.beforeFirst(); /*not rs.first() because the rs.next() below will move on, missing the first element*/
	        
	    	while (rs.next()) {
	        	String myString = rs.getString(label);
	            
	        	//not the best way, but reliable
	            if (myString == null ) { 
	               myString = null; //sqlNull;   /*If null value, convert to string value of 'NULL'*/
	            }
	            
	            myList.add(myString);
	       }
	    } catch(Exception e) { 
	    	e.printStackTrace(); 
	    }
		
	    return myList;
	}
}
