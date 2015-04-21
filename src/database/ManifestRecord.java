package database;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ManifestRecord {
	
	private String asset_id;
	private String player_id;

	public ManifestRecord(Node node) {
		loadDataFromNode(node);
	}

	private void loadDataFromNode(Node node) {
		
		loadAssetData(node);
		
		// We're not loading the rest of the data, we don't need it currently.
	}

	private void loadAssetData(Node node) {
        asset_id = getNodesNamedItem(node, "id");
        player_id = getNodesNamedItem(node, "player_id");
	}
	
	private String getNodesNamedItem(Node node, String namedItem) {
        String returnVal = new String("0");
        
        // Check the attribute exists
        if (node.getAttributes().getNamedItem(namedItem) != null) {
            returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();
        }
        return returnVal;
    }
    
    private float getNodesNamedFloat(Node node, String namedItem) {
    	float result = 0f;
    	
    	// Get the Value as a String first
    	String value = getNodesNamedItem(node, namedItem);
    	
    	// Validate it is in fact a float
    	try {
    		result = Float.parseFloat(value);
    	} catch (NumberFormatException e) {
    		result = 0f;
    	}
    	
    	return result;
    }

	private int getNodesNamedInt(Node node, String namedItem) {
    	int result = 0;
    	
    	// Get the Value as a String first
    	String value = getNodesNamedItem(node, namedItem);
    	
    	// Validate it is in fact a float
    	try {
    		result = Integer.parseInt(value);
    	} catch (NumberFormatException e) {
    		result = 0;
    	}
    	
    	return result;
    }

	public String getAssetId() {
		return asset_id;
	}
	public String getPlayerId() {
		return player_id;
	}
	
}
