package database;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * API used for pulling the MLB player's images from the database Sports Data LLC
 * 
 * @author XML Code adapted from
 *         http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom
 *         -sax-and-stax-parser-in-java.html
 */
public class SportsPicsApi
{
	private static final String apiImageKey = "udwx6be6kaszg2y46z6aduj2";
	private static final String apiImageUrlPrefix = "https://api.sportsdatallc.org/mlb-images-t2/usat/players/headshots/";
	private static final String apiImageUrlSuffix = "/250.jpg?api_key=";
	
	/**
	 * Gets an image that matches the Asset Id assigned to each player object
	 * 
	 * @param player
	 *            Player whose image is being obtained
	 * @return Image of the player whose Asset Id is matched
	 */
	public static Image getImageForMlbPlayer(MlbPlayer player)
	{
		Image pic = null;
		
		try
		{
			NodeList nodeList = getManifestNodeList();
			String assetId = getAssetIdFromManifestForMlbPlayerId(nodeList, player);
			pic = getImageFromAssetId(assetId);
		}
		catch (Exception e)
		{
			try
			{
				URL url = new URL(
						"http://www.clker.com/cliparts/5/9/4/c/12198090531909861341man%20silhouette.svg.hi.png");
				pic = ImageIO.read(url);
			}
			catch (MalformedURLException me)
			{
				me.printStackTrace();
			}
			catch (IOException ioe)
			{
				ioe.printStackTrace();
			}
		}
		
		return pic;
	}
	
	/**
	 * Uses Manifest Records to get an Asset Id for any given MLB Player
	 * 
	 * @param nodeList
	 *            List of nodes consisting of MLB Player's Id's
	 * @param player
	 *            MLB Player object
	 * @return Identifier for an MLB Player
	 */
	private static String getAssetIdFromManifestForMlbPlayerId(NodeList nodeList,
			MlbPlayer player)
	{
		String assetID = null;
		
		if (nodeList != null)
		{
			for (int i = 0; i < nodeList.getLength() && assetID == null; i++)
			{
				Node node = nodeList.item(i);
				if (node instanceof Element)
				{
					ManifestRecord record = new ManifestRecord(node);
					
					if (record.getPlayerId().equals(player.getId()))
					{
						assetID = record.getAssetId();
					}
				}
			}
		}
		
		return assetID;
	}
	
	/**
	 * WARNING: Our license only allows 25 calls a month, so don't follow this link unless
	 * you NEED to, this is just a working example.
	 * 
	 * https://api.sportsdatallc.org/mlb-images-t2/usat/players
	 * /headshots/c6070f31-749f-4e99
	 * -8f35-f2a8bce3be4a/250.jpg?api_key=udwx6be6kaszg2y46z6aduj2
	 * 
	 * Sets the URL String to an arbitrary value in order to prevent it from using one of
	 * the API's calls for the month
	 * 
	 * @param assetId
	 *            Identifier assigned to every player
	 * @return Image that was generated
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private static Image getImageFromAssetId(String assetId)
			throws MalformedURLException, IOException
	{
		String urlString = getApiUrlString(assetId);
		URL url = new URL(urlString);
		Image pic = ImageIO.read(url);
		
		return pic;
	}
	
	/**
	 * Gets the elements of the Manifest Records and returns them as a list of nodes
	 * 
	 * @return NodeList consisting of the elements in the Manifest Records
	 * @throws UnableToLoadManifestException
	 */
	private static NodeList getManifestNodeList() throws UnableToLoadManifestException
	{
		NodeList list = null;
		
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			FileInputStream manifest = new FileInputStream("images/all_assets.xml");
			Document document = builder.parse(manifest);
			
			list = document.getDocumentElement().getChildNodes();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error in getManifestNodeList():  Can't find manifest file!");
			throw new UnableToLoadManifestException();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		}
		
		return list;
	}
	
	private static String getApiUrlString(String assetId)
	{
		return apiImageUrlPrefix + assetId + apiImageUrlSuffix + apiImageKey;
	}
	
	private static class UnableToLoadManifestException extends Exception
	{
		// TODO: Add functionality
	}
}
