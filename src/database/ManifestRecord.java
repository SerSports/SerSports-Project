package database;

import org.w3c.dom.Node;

/**
 * Gathers information from a database that is relevant for the program that is then
 * stored in a node. Gets the named item from the node and returns the values of its
 * attributes and then manages them from there, parsing them to the required types.
 * 
 * @author SerSports
 */
public class ManifestRecord
{
	
	private String asset_id;
	private String player_id;
	
	public ManifestRecord(Node node)
	{
		loadDataFromNode(node);
	}
	
	/**
	 * Only loading data that we currently need.
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadDataFromNode(Node node)
	{
		loadAssetData(node);
	}
	
	/**
	 * Sets ID's that are used as temporary asset and player identifiers.
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadAssetData(Node node)
	{
		asset_id = getNodesNamedItem(node, "id");
		player_id = getNodesNamedItem(node, "player_id");
	}
	
	/**
	 * Gets the attribute of the node's named item given that the attribute exists.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return The namedItem given that it is not null
	 */
	private String getNodesNamedItem(Node node, String namedItem)
	{
		String returnVal = new String("0");
		
		if (node.getAttributes().getNamedItem(namedItem) != null)
		{
			returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();
		}
		return returnVal;
	}
	
	/**
	 * Gets the value of the node's named item as a String and then parses the String to a
	 * float.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return Value of the node's named item as a float
	 */
	private float getNodesNamedFloat(Node node, String namedItem)
	{
		float result = 0f;
		
		String value = getNodesNamedItem(node, namedItem);
		
		try
		{
			result = Float.parseFloat(value);
		}
		catch (NumberFormatException e)
		{
			result = 0f;
		}
		
		return result;
	}
	
	/**
	 * Gets the value of the node's named item as a String and then parses the String to
	 * an integer.
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param namedItem
	 *            The specific attribute that the node value holds.
	 * @return Value of the node's named item as an integer
	 */
	private int getNodesNamedInt(Node node, String namedItem)
	{
		int result = 0;
		
		String value = getNodesNamedItem(node, namedItem);
		
		try
		{
			result = Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{
			result = 0;
		}
		
		return result;
	}
	
	public String getAssetId()
	{
		return asset_id;
	}
	
	public String getPlayerId()
	{
		return player_id;
	}
	
}
