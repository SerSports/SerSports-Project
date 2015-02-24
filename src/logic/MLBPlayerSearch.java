import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/* Possible libraries for future use
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
*/


public class MLBPlayerSearch {

	private Connection dbConn = null;  //will get more info from JDBC
	
	//constructor
	public MLBPlayerSearch(){
	}
	
	//constructor with 4 parameters
	public MLBPlayerSearch(String fName, String lName, String position, String team) {
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

	//If request only by first name
	public List<String> playerSearchByFirstName(String fName){
		
		String query = "SELECT player_name FROM name_of_table WHERE player_name=\""+fName+"\"";
		
		ResultSet rs = getRS(query);
		
		List<String> playerList = convertToListString(rs, "player_name");
		
		return playerList;
		
	}
	
	//if request only by last name
	public List<String> playerSearchByLastName(String lName){
		
		String query = "SELECT player_name FROM name_of_table WHERE player_name=\""+lName+"\"";
		
		ResultSet rs = getRS(query);
		
		List<String> playerList = convertToListString(rs, "player_name");
		
		return playerList;
		
	}
	
	//if request a list of players that play a certain position
	public List<String> playerSearchByPosition(String position){
		
		String query = "SELECT player_name FROM name_of_table WHERE player_name=\""+position+"\"";
		
		ResultSet rs = getRS(query);
		
		List<String> playerList = convertToListString(rs, "player_name");
		
		return playerList;
		
	}

	//if request a list of players within a certain team
	public List<String> playerSearchByTeamName(String team){
	
		String query = "SELECT player_name FROM name_of_table WHERE player_name=\""+team+"\"";
	
		ResultSet rs = getRS(query);
	
		List<String> playerList = convertToListString(rs, "player_name");
	
		return playerList;
	
	}
	
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
