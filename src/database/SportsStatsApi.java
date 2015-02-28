package database;

/*
 XML Code adapted from http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
 API for http://www.sportsdatallc.com/
 */
import javax.xml.parsers.*;
import java.net.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

public class SportsStatsApi {
	private static final String apiKey = "enwf769pmzvpjr57jurvexqz";
	private static final String apiUrlPrefix = "https://api.sportsdatallc.org/mlb-t4/seasontd/players/";
	private static final String apiUrlSuffix = ".xml?api_key=";

	public static List<MlbPlayerAPIImport> getListOfMlbPlayerAPIImportForYear(int year) {
		List<MlbPlayerAPIImport> playerList = null;
		
		// Validate Input
		if (year > 0) {
			
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
	
				// Load and Parse the XML document
				// document contains the complete XML as a Tree.
				URL url = new URL(getApiUrlString(year));
				Document document = builder.parse(url.openStream());
	
				// Iterating through the nodes and extracting the data.
				NodeList nodeList = document.getDocumentElement().getChildNodes();
	
				// Make sure an error hasn't occurred.
				// if (nodeList.item(0).getAttributes().getNamedItem("error") == null)
				{
					// Create list of players
					playerList = new ArrayList<MlbPlayerAPIImport>();
					for (int i = 0; i < nodeList.getLength(); i++) {
						// We have encountered an <employee> tag.
						Node node = nodeList.item(i);
						if (node instanceof Element) {
							// Create the Player
							MlbPlayerAPIImport player = new MlbPlayerAPIImport(node);
							// Add the Player to the list
							playerList.add(player);
						}
					}
				}
			//} catch () {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return playerList;
	}
	
	public static void loadNewestStatsIntoDatabase() {
		
		// Load 2014's season's statistics
		List<MlbPlayerAPIImport> playerList = getListOfMlbPlayerAPIImportForYear(2014);
		
		// Add each player to the database
		for (MlbPlayerAPIImport playerApi : playerList) {
			MlbPlayer player = new MlbPlayer(playerApi);
			player.saveMlbPlayerToDatabase();
		}
	}

	private static String getApiUrlString(int year) {
		return apiUrlPrefix + year + apiUrlSuffix + apiKey;
	}
}