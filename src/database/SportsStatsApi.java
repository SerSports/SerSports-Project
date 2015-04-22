package database;

import javax.xml.parsers.*;
import java.net.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;

/**
 * API used for pulling the MLB statistics from the database Sports Data LLC
 * 
 * @author XML Code adapted from
 *         http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom
 *         -sax-and-stax-parser-in-java.html
 * 
 */
public class SportsStatsApi
{
	private static final String apiKey = "enwf769pmzvpjr57jurvexqz";
	private static final String apiUrlPrefix = "https://api.sportsdatallc.org/mlb-t4/seasontd/players/";
	private static final String apiUrlSuffix = ".xml?api_key=";
	
	/**
	 * Validates input and then loads and parses the XML document which contains the
	 * complete XML as a Tree. Iterates through the nodes and extracts the data then
	 * creates a list of players for the specified year
	 * 
	 * @param year
	 *            Year specified by user
	 * @return A list of players based on the specified year
	 */
	public static List<MlbPlayer> getListOfMlbPlayerForYear(int year)
	{
		List<MlbPlayer> playerList = null;
		
		if (year > 0)
		{
			try
			{
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				URL url = new URL(getApiUrlString(year));
				Document document = builder.parse(url.openStream());
				
				NodeList nodeList = document.getDocumentElement().getChildNodes();
				
				{
					playerList = new ArrayList<MlbPlayer>();
					for (int i = 0; i < nodeList.getLength(); i++)
					{
						Node node = nodeList.item(i);
						if (node instanceof Element)
						{
							MlbPlayer player = new MlbPlayer(node);
							playerList.add(player);
						}
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return playerList;
	}
	
	/**
	 * Ensures that the most recent statistics are loaded into the database for default
	 * purposes
	 */
	public static void loadNewestStatsIntoDatabase()
	{
		
		List<MlbPlayer> playerList = getListOfMlbPlayerForYear(2014);
		
		for (MlbPlayer playerApi : playerList)
		{
			playerApi.saveMlbPlayerToDatabase();
		}
	}
	
	private static String getApiUrlString(int year)
	{
		return apiUrlPrefix + year + apiUrlSuffix + apiKey;
	}
}
