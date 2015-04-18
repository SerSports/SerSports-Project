/*
File: SportsStatsApi.java
Author:	XML Code adapted from 
		http://www.javacodegeeks.com/2013/05/parsing-xml-using-dom-sax-and-stax-parser-in-java.html
Date:	

Description: API for pulling the MLB stats from Sports Data LLC

 */
package database;

import java.awt.Image;

/*
 
 API for http://www.sportsdatallc.com/
 */



public class SportsPicsApi {
	private static final String apiKey = "enwf769pmzvpjr57jurvexqz";
	private static final String apiUrlPrefix = "https://api.sportsdatallc.org/mlb-images-t4/usat/players/headshot/";
	private static final String apiUrlSuffix = ".jpg?api_key=";
	
	//http(s)://api.sportsdatallc.org/[sport]-images-[access_level][version]/
	//[provider]/players/[image_type]/[asset_id]/[filename].[format]?api_key=[your_api_key]
		
	public static Image getImageForMlbPlayer(String assetId) {
		Image pic = null;
		
		
		return pic;
	}
	public static void loadNewestStatsIntoDatabase() {

	}

	private static String getApiUrlString(String assetId) {
		return apiUrlPrefix + assetId + apiUrlSuffix + apiKey;
	}
}
