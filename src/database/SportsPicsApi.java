/*
File: SportsStatsApi.java
Author:	XML Code adapted from 
		http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
Date:	

Description: API for pulling the MLB stats from Sports Data LLC

 */
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

/*
 
 API for http://www.sportsdatallc.com/
 */

public class SportsPicsApi {
	private static final String apiImageKey = "udwx6be6kaszg2y46z6aduj2";
	private static final String apiImageUrlPrefix = "https://api.sportsdatallc.org/mlb-images-t2/usat/players/headshots/";
	private static final String apiImageUrlSuffix = "/250.jpg?api_key=";
		
	public static Image getImageForMlbPlayer(MlbPlayer player) {
		Image pic = null;
		
		try {
			NodeList nodeList = getManifestNodeList();
			String assetId = getAssetIdFromManifestForMlbPlayerId(nodeList, player);
			pic = getImageFromAssetId(assetId);
		}
		catch (Exception e) {
			try {
				URL url = new URL("http://a.espncdn.com/combiner/i?img=/i/headshots/mlb/players/full/4937.png&w=350&h=254");
				pic = ImageIO.read(url);
			} catch (MalformedURLException me) {
				me.printStackTrace();
 			} catch (IOException ioe) {
 				ioe.printStackTrace();
 			}
		}
		
		return pic;
	}

	private static String getAssetIdFromManifestForMlbPlayerId(
			NodeList nodeList, MlbPlayer player) {
		String assetID = null;
		
		if (nodeList != null) {
			for (int i = 0; i < nodeList.getLength() && assetID == null; i++) {
				Node node = nodeList.item(i);
				if (node instanceof Element) {
					ManifestRecord record = new ManifestRecord(node);
					
					if (record.getPlayerId().equals(player.getId())) {
						assetID = record.getAssetId();
					}
				}
			}
		}
		
		return assetID;
	}
	
	// Working Example: (WARNING our license only allows 25 calls a month, so don't follow this link unless you NEED to)
	// https://api.sportsdatallc.org/mlb-images-t2/usat/players/headshots/c6070f31-749f-4e99-8f35-f2a8bce3be4a/250.jpg?api_key=udwx6be6kaszg2y46z6aduj2
	private static Image getImageFromAssetId(String assetId) throws MalformedURLException, IOException {
		
		String urlString = getApiUrlString(assetId);
		urlString = new String("12312");				// Only here to mess things up.  We don't want this code to work otherwise it will use one of our API's calls for this month.
		URL url = new URL(urlString);
		Image pic = ImageIO.read(url);
		
		return pic;
	}

	private static NodeList getManifestNodeList() throws UnableToLoadManifestException {
		NodeList list = null;
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			FileInputStream manifest = new FileInputStream("images/all_assets.xml");
			Document document = builder.parse(manifest);
			
			list = document.getDocumentElement().getChildNodes();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		} catch (FileNotFoundException e) {
			System.out.println("Error in getManifestNodeList():  Can't find manifest file!");
			throw new UnableToLoadManifestException();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnableToLoadManifestException();
		}
		
		return list;
	}

	private static String getApiUrlString(String assetId) {
		return apiImageUrlPrefix + assetId + apiImageUrlSuffix + apiImageKey;
	}
	
	private static class UnableToLoadManifestException extends Exception {
		
	}
}
