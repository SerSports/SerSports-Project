package sersports.mlb;

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

public class SportsStatsApi
{
	private static final String apiKey = "enwf769pmzvpjr57jurvexqz";
	private static final String apiUrlPrefix = "https://api.sportsdatallc.org/mlb-t4/seasontd/players/";
	private static final String apiUrlSuffix = ".xml?api_key=";
	
	public static List<MlbPlayerStatistics> getListOfMlbPlayerStatisticsForYear(int year) throws Exception
	{   
		List<MlbPlayerStatistics> playerList = null;
		
		// Validate Input
		if (year > 0)
		{
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    
		    //Load and Parse the XML document
		    //document contains the complete XML as a Tree.
		    URL url = new URL(getApiUrlString(year));
		    Document document = builder.parse(url.openStream());
		    
		    //Iterating through the nodes and extracting the data.
		    NodeList nodeList = document.getDocumentElement().getChildNodes();
		    
		    // Make sure an error hasn't occured.
		    //if (nodeList.item(0).getAttributes().getNamedItem("error") == null)
		    {
			    // Create list of players
			    playerList = new ArrayList<MlbPlayerStatistics>();
			    
			    for (int i = 0; i < nodeList.getLength(); i++)
			    {
			        //We have encountered an <employee> tag.
			        Node node = nodeList.item(i);
			        if (node instanceof Element)
			        {
			            // Create the Player
			            MlbPlayerStatistics player = new MlbPlayerStatistics(node);
			            
			            // Add the Player to the list
			            playerList.add(player);
			        }
			    }
		    }
		}
	    
	    return playerList;
	}
	
	private static String getApiUrlString(int year)
	{
		return apiUrlPrefix + year + apiUrlSuffix + apiKey;
	}
}