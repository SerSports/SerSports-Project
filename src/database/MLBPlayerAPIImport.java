package database;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class MlbPlayerAPIImport {
	String id;
    String first_name; //Player First Name
    String last_name; //Player Last Name

    String team_id;
    String team_name;//Team name
    
    int hitting_ab; //Batting AB
    int hitting_rbi; //Batting RBI

    //NEED to figure out the difference between onbase h for hitting and onbase H for pitching.
    //http://espn.go.com/mlb/player/stats/_/id/28963/clayton-kershaw

    float pitching_era; //Pitching ERA

    int pitching_onbase_h;//Batting H
    int pitching_onbase_s;// Batting 1B single
    int pitching_onbase_d;//Batting 2B double
    int pitching_onbase_t;//Batting 3B triple
    int pitching_onbase_hr;//Batting HR homeruns
    int pitching_onbase_bb;//Pitching BB
    int pitching_runs_earned; //Batting R //Pitching ER 
    int pitching_runs_total; //Pitching R
    int pitching_outs_ktotal; //Batting outs SO
    int pitching_steal_stolen; // steals Stolen SB
    int pitching_games_play;// GP games played //Fielding//Pitching//Batting hitting_games_play
    int pitching_games_win;//Pitching: W
    int pitching_games_loss;//Pitching: L
    int pitching_games_save;//Pitching: Saves
    int pitching_games_hold; //Pitching:Hold
    
    int hitting_onbase_h;//Batting H
    int hitting_onbase_s;// Batting 1B single
    int hitting_onbase_d;//Batting 2B double
    int hitting_onbase_t;//Batting 3B triple
    int hitting_onbase_hr;//Batting HR homeruns
    int hitting_onbase_bb;//Pitching BB
    int hitting_runs_earned; //Batting R //Pitching ER 
    int hitting_runs_total; //Pitching R
    int hitting_outs_ktotal; //Batting outs SO
    int hitting_steal_stolen; // steals Stolen SB
    int hitting_games_play;// GP games played //Fielding//Pitching//Batting hitting_games_play
    int hitting_games_win;//Pitching: W
    int hitting_games_loss;//Pitching: L
    int hitting_games_save;//Pitching: Saves
    int hitting_games_hold; //Pitching:Hold
    
    public MlbPlayerAPIImport(Node node)
    {
        // Initialize from XML Node
        loadDataFromNode(node);
    }
    
    private String getNodesNamedItem(Node node, String namedItem)
    {
        String returnVal = new String("0");
        
        // Check the attribute exists
        if (node.getAttributes().getNamedItem(namedItem) != null)
            returnVal = node.getAttributes().getNamedItem(namedItem).getNodeValue();

        return returnVal;
    }
    
    private void loadPlayerData(Node node)
    {
        // Get "player" data
        id               = getNodesNamedItem(node, "id");
        first_name       = getNodesNamedItem(node, "first_name");
        last_name        = getNodesNamedItem(node, "last_name");
    }
    
    private void loadTeamData(Node node)
    {
        // Get "team" data
        team_id      = getNodesNamedItem(node, "id");
        team_name    = getNodesNamedItem(node, "name");
    }
    
    private void loadHittingData(Node node)
    {
        // Get the "hitting" data
        hitting_ab       = Integer.parseInt(getNodesNamedItem(node, "ab"));
        hitting_rbi      = Integer.parseInt(getNodesNamedItem(node, "rbi"));
    }
    
    private void loadPitchingData(Node node)
    {
        pitching_era    = Float.parseFloat(getNodesNamedItem(node, "era"));
    }
    
    private void loadOnbaseData(Node node, String parentNodeName)
    {
        // Load "onbase" data
    	if (parentNodeName.equals("hitting"))
    	{
	        hitting_onbase_h     = Integer.parseInt(getNodesNamedItem(node, "h"));
	        hitting_onbase_s     = Integer.parseInt(getNodesNamedItem(node, "s"));
	        hitting_onbase_d     = Integer.parseInt(getNodesNamedItem(node, "d"));
	        hitting_onbase_t     = Integer.parseInt(getNodesNamedItem(node, "t"));
	        hitting_onbase_hr    = Integer.parseInt(getNodesNamedItem(node, "hr"));
	        hitting_onbase_bb    = Integer.parseInt(getNodesNamedItem(node, "bb"));
    	} else if (parentNodeName.equals("pitching")) {
	        pitching_onbase_h     = Integer.parseInt(getNodesNamedItem(node, "h"));
	        pitching_onbase_s     = Integer.parseInt(getNodesNamedItem(node, "s"));
	        pitching_onbase_d     = Integer.parseInt(getNodesNamedItem(node, "d"));
	        pitching_onbase_t     = Integer.parseInt(getNodesNamedItem(node, "t"));
	        pitching_onbase_hr    = Integer.parseInt(getNodesNamedItem(node, "hr"));
	        pitching_onbase_bb    = Integer.parseInt(getNodesNamedItem(node, "bb"));
 
    	}
    }
    
    private void loadRunsData(Node node, String parentNodeName)
    {
        // Load "runs" data
    	if (parentNodeName.equals("hitting")) {
	        hitting_runs_earned      = Integer.parseInt(getNodesNamedItem(node, "earned"));
	        hitting_runs_total       = Integer.parseInt(getNodesNamedItem(node, "total"));
    	} else if (parentNodeName.equals("pitching")) {
	        pitching_runs_earned      = Integer.parseInt(getNodesNamedItem(node, "earned"));
	        pitching_runs_total       = Integer.parseInt(getNodesNamedItem(node, "total"));
    	}
    }
    

    private void loadOutsData(Node node, String parentNodeName)
    {
        // Load "outs" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_outs_ktotal  = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_outs_ktotal  = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
    	}
    }
    
    private void loadStealData(Node node, String parentNodeName)
    {
        // Load "steal" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
    	}
    }
    
    private void loadGamesData(Node node, String parentNodeName)
    {
        // Load "games" data
    	if (parentNodeName.equals("hitting")) {
    		hitting_games_play       = Integer.parseInt(getNodesNamedItem(node, "play"));
    	} else if (parentNodeName.equals("pitching")) {
    		pitching_games_play       = Integer.parseInt(getNodesNamedItem(node, "play"));
    	}
    }
    
    public void loadDataFromNode(Node node)
    {
        // Get "player" data
        loadPlayerData(node);
        
        NodeList child1Nodes = node.getChildNodes();
        for (int j = 0; j < child1Nodes.getLength(); j++)
        {
            Node teamNode = child1Nodes.item(j);
            if (teamNode instanceof Element)
            {
                // Get "team" data
                loadTeamData(teamNode);
                
                NodeList child2Nodes = teamNode.getChildNodes();
                for (int k = 0; k < child2Nodes.getLength(); k++)
                {
                    Node c1Node = child2Nodes.item(k);
                    if (c1Node instanceof Element)
                    {
                    	String parentNodeName = null;

                        //Identifying the child tag
                        switch (c1Node.getNodeName())
                        {
                        case "hitting":
                            loadHittingData(c1Node);
                            break;
                        case "pitching":
                            loadPitchingData(c1Node);
                            break;
                        }
                        
                        // Get Parent Node Lame
                        parentNodeName = c1Node.getNodeName();
                        
                        // Load the Node data
                        NodeList child3Nodes = c1Node.getChildNodes();
                        for (int l = 0; l < child3Nodes.getLength(); l++)
                        {
                            Node c2Node = child3Nodes.item(l);
                            if (c2Node instanceof Element)
                            {
                                //Identifying the child tag
                                switch (c2Node.getNodeName())
                                {
                                    case "onbase":
                                        loadOnbaseData(c2Node, parentNodeName);
                                        break;
                                    case "runs":
                                        loadRunsData(c2Node, parentNodeName);
                                        break;
                                    case "outs":
                                        loadOutsData(c2Node, parentNodeName);
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