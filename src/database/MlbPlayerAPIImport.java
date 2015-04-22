package database;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class MlbPlayerAPIImport
{
	String id; // Identifier used to track players
	String first_name; // Player First Name
	String last_name; // Player Last Name
	
	String team_id; // Identifier used to track teams
	String team_name;// Team Name
	
	int hitting_ab; // At Bats
	int hitting_rbi; // Runs Batted In
	
	float pitching_era; // Earned Run Average
	int pitching_onbase_h; // Hits Allowed
	int pitching_onbase_s; // Singles Allowed
	int pitching_onbase_d; // Doubles Allowed
	int pitching_onbase_t; // Triples Allowed
	int pitching_onbase_hr; // Home Runs Allowed
	int pitching_onbase_bb; // Base-on-balls (Walks) Allowed
	int pitching_runs_earned; // Total Earned Runs Allowed
	int pitching_runs_total; // Total Runs Allowed
	int pitching_outs_ktotal; // Strike-outs
	int pitching_steal_stolen; // Steals Allowed
	int pitching_games_play; // Games Played
	int pitching_games_win; // Games Won
	int pitching_games_loss; // Games Lost
	int pitching_games_save; // Games Saved
	int pitching_games_hold; // Games Held
	
	int hitting_onbase_h; // Total Hits
	int hitting_onbase_s;// Singles
	int hitting_onbase_d;// Doubles
	int hitting_onbase_t;// Triples
	int hitting_onbase_hr;// Home Runs
	int hitting_onbase_bb;// Base-on-balls (Walks)
	int hitting_runs_earned; // Runs Scored
	int hitting_runs_total; // Total Runs
	int hitting_outs_ktotal; // Strike-outs
	int hitting_steal_stolen; // Stolen Bases
	int hitting_games_play; // Games Played
	int hitting_games_win; // Games Won
	int hitting_games_loss; // Games Lost
	int hitting_games_save;
	int hitting_games_hold;
	
	/**
	 * Initializes data from XML Node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	public MlbPlayerAPIImport(Node node)
	{
		loadDataFromNode(node);
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
			returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();
		
		return returnVal;
	}
	
	/**
	 * Gets the loaded player's general attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadPlayerData(Node node)
	{
		id = getNodesNamedItem(node, "id");
		first_name = getNodesNamedItem(node, "first_name");
		last_name = getNodesNamedItem(node, "last_name");
	}
	
	/**
	 * Gets the loaded player's team attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadTeamData(Node node)
	{
		team_id = getNodesNamedItem(node, "id");
		team_name = getNodesNamedItem(node, "name");
	}
	
	/**
	 * Gets the loaded player's batting attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadHittingData(Node node)
	{
		hitting_ab = Integer.parseInt(getNodesNamedItem(node, "ab"));
		hitting_rbi = Integer.parseInt(getNodesNamedItem(node, "rbi"));
	}
	
	/**
	 * Gets the loaded player's pitching attributes from the node
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	private void loadPitchingData(Node node)
	{
		pitching_era = Float.parseFloat(getNodesNamedItem(node, "era"));
	}
	
	/**
	 * Gets the data of all "on-base" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadOnbaseData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			hitting_onbase_h = Integer.parseInt(getNodesNamedItem(node, "h"));
			hitting_onbase_s = Integer.parseInt(getNodesNamedItem(node, "s"));
			hitting_onbase_d = Integer.parseInt(getNodesNamedItem(node, "d"));
			hitting_onbase_t = Integer.parseInt(getNodesNamedItem(node, "t"));
			hitting_onbase_hr = Integer.parseInt(getNodesNamedItem(node, "hr"));
			hitting_onbase_bb = Integer.parseInt(getNodesNamedItem(node, "bb"));
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_onbase_h = Integer.parseInt(getNodesNamedItem(node, "h"));
			pitching_onbase_s = Integer.parseInt(getNodesNamedItem(node, "s"));
			pitching_onbase_d = Integer.parseInt(getNodesNamedItem(node, "d"));
			pitching_onbase_t = Integer.parseInt(getNodesNamedItem(node, "t"));
			pitching_onbase_hr = Integer.parseInt(getNodesNamedItem(node, "hr"));
			pitching_onbase_bb = Integer.parseInt(getNodesNamedItem(node, "bb"));
			
		}
	}
	
	/**
	 * Gets the data of all "runs" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadRunsData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			hitting_runs_earned = Integer.parseInt(getNodesNamedItem(node, "earned"));
			hitting_runs_total = Integer.parseInt(getNodesNamedItem(node, "total"));
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_runs_earned = Integer.parseInt(getNodesNamedItem(node, "earned"));
			pitching_runs_total = Integer.parseInt(getNodesNamedItem(node, "total"));
		}
	}
	
	/**
	 * Gets the data of all "Strike-outs" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadStrikeOutsData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			hitting_outs_ktotal = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_outs_ktotal = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
		}
	}
	
	/**
	 * Gets the data of all "Steals" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting or
	 *            pitching
	 */
	private void loadStealData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			hitting_steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
		}
	}
	
	/**
	 * Gets the data of all "Games" statistics based on the field that the player is
	 * classified as
	 * 
	 * @param node
	 *            Holds loaded data.
	 * @param parentNodeName
	 *            Used to determine the field that player is classified under: batting,
	 *            pitching, or fielding
	 */
	private void loadGamesData(Node node, String parentNodeName)
	{
		if (parentNodeName.equals("hitting"))
		{
			hitting_games_play = Integer.parseInt(getNodesNamedItem(node, "play"));
		}
		else if (parentNodeName.equals("pitching"))
		{
			pitching_games_play = Integer.parseInt(getNodesNamedItem(node, "play"));
		}
	}
	
	/**
	 * First gets the player's data and then gets the team data based on the player
	 * followed by identifying the child tag (i.e. their classifications) then gets the
	 * parent node's name and loads that data based on the attributes that were relevant
	 * to its child tag
	 * 
	 * @param node
	 *            Holds loaded data.
	 */
	public void loadDataFromNode(Node node)
	{
		loadPlayerData(node);
		
		NodeList child1Nodes = node.getChildNodes();
		for (int j = 0; j < child1Nodes.getLength(); j++)
		{
			Node teamNode = child1Nodes.item(j);
			if (teamNode instanceof Element)
			{
				loadTeamData(teamNode);
				
				NodeList child2Nodes = teamNode.getChildNodes();
				for (int k = 0; k < child2Nodes.getLength(); k++)
				{
					Node c1Node = child2Nodes.item(k);
					if (c1Node instanceof Element)
					{
						String parentNodeName = null;
						
						switch (c1Node.getNodeName())
						{
							case "hitting":
								loadHittingData(c1Node);
								break;
							case "pitching":
								loadPitchingData(c1Node);
								break;
						}
						
						parentNodeName = c1Node.getNodeName();
						
						NodeList child3Nodes = c1Node.getChildNodes();
						for (int l = 0; l < child3Nodes.getLength(); l++)
						{
							Node c2Node = child3Nodes.item(l);
							if (c2Node instanceof Element)
							{
								switch (c2Node.getNodeName())
								{
									case "onbase":
										loadOnbaseData(c2Node, parentNodeName);
										break;
									case "runs":
										loadRunsData(c2Node, parentNodeName);
										break;
									case "outs":
										loadStrikeOutsData(c2Node, parentNodeName);
										break;
									case "steal":
										loadStealData(c2Node, parentNodeName);
										break;
									case "games":
										loadGamesData(c2Node, parentNodeName);
										break;
								}
							}
						}
					}
				}
			}
		}
	}
}
