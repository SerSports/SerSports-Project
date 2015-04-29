package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

class SerSports_DbConnectionProperties
{
	
	private final static String configFileName = "config.properties";
	
	/*
	 * JDBC driver name and database URL
	 */
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private String DB_URL = "jdbc:mysql://local/ser_sports";
	//private String DB_URL = "jdbc:mysql://107.170.229.233/ser_sports";
	
	/*
	 * Database credentials
	 */
	private String USER = "root";
	//private String PASS = "root";
	private String PASS = "";
	
	private static Boolean usingDefaultValues = false;
	
	public String get_JDBC_DRIVER()
	{
		return JDBC_DRIVER;
	}
	
	public String get_DB_URL()
	{
		return DB_URL;
	}
	
	public String get_USER()
	{
		return USER;
	}
	
	public String get_PASS()
	{
		return PASS;
	}
	
	/**
	 * Loads the properties and sets the credentials
	 */
	SerSports_DbConnectionProperties()
	{
		Properties prop = new Properties();
		InputStream input = null;
		
		try
		{
			input = new FileInputStream(configFileName);
			
			prop.load(input);
			
			JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
			DB_URL = prop.getProperty("DB_URL");
			USER = prop.getProperty("USER");
			PASS = prop.getProperty("PASS");
			
		}
		catch (IOException ex)
		{
			if (usingDefaultValues == false)
			{
				System.out.println("config file not found!  Using default values.");
				usingDefaultValues = true;
			}
		}
		finally
		{
			if (input != null)
			{
				try
				{
					input.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Sets the properties value and then saves them to the project's root folder
	 */
	public void savePropertiesFile()
	{
		Properties prop = new Properties();
		OutputStream output = null;
		
		try
		{
			output = new FileOutputStream(configFileName);
			
			prop.setProperty("JDBC_DRIVER", JDBC_DRIVER);
			prop.setProperty("DB_URL", DB_URL);
			prop.setProperty("USER", USER);
			prop.setProperty("PASS", PASS);
			
			prop.store(output, null);
			
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			if (output != null)
			{
				try
				{
					output.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
}
