package database;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class MLBPlayerAPIImport {
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

    int onbase_h;//Batting H
    int onbase_s;// Batting 1B single
    int onbase_d;//Batting 2B double
    int onbase_t;//Batting 3B triple
    int onbase_hr;//Batting HR homeruns
    int onbase_bb;//Pitching BB

    int runs_earned; //Batting R //Pitching ER 
    int runs_total; //Pitching R
    int outs_ktotal; //Batting outs SO
    int steal_stolen; // steals Stolen SB
    int games_play;// GP games played //Fielding//Pitching//Batting hitting_games_play
    int games_win;//Pitching: W
    int games_loss;//Pitching: L
    int games_save;//Pitching: Saves
    int games_hold; //Pitching:Hold
    
    public MLBPlayerAPIImport(Node node)
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
    
    private void loadOnbaseData(Node node)
    {
        // Load "onbase" data
        onbase_h     = Integer.parseInt(getNodesNamedItem(node, "h"));
        onbase_s     = Integer.parseInt(getNodesNamedItem(node, "s"));
        onbase_d     = Integer.parseInt(getNodesNamedItem(node, "d"));
        onbase_t     = Integer.parseInt(getNodesNamedItem(node, "t"));
        onbase_hr    = Integer.parseInt(getNodesNamedItem(node, "hr"));
        onbase_bb    = Integer.parseInt(getNodesNamedItem(node, "bb"));
    }
    
    private void loadRunsData(Node node)
    {
        // Load "runs" data
        runs_earned      = Integer.parseInt(getNodesNamedItem(node, "earned"));
        runs_total       = Integer.parseInt(getNodesNamedItem(node, "total"));
    }
    

    private void loadOutsData(Node node)
    {
        // Load "outs" data

        outs_ktotal  = Integer.parseInt(getNodesNamedItem(node, "ktotal"));
    }
    
    private void loadStealData(Node node)
    {
        // Load "steal" data
        steal_stolen = Integer.parseInt(getNodesNamedItem(node, "stolen"));
    }
    
    private void loadGamesData(Node node)
    {
        // Load "games" data
        games_play       = Integer.parseInt(getNodesNamedItem(node, "play"));
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
                                        loadOnbaseData(c2Node);
                                        break;
                                    case "runs":
                                        loadRunsData(c2Node);
                                        break;
                                    case "outs":
                                        loadOutsData(c2Node);
                                        break;
                                    case "steal":
                                        loadStealData(c2Node);
                                        break;
                                    case "games":
                                        loadGamesData(c2Node);
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public String toString()
    {
        return new String("id: " + id + "\n" +
                          "first_name: " + first_name + "\n" +
                          "last_name: " + last_name + "\n" +
                          "team_id: " + team_id + "\n" +
                          "team_name: " + team_name + "\n" +
                          
                          "hitting_ab: " + hitting_ab + "\n" +
                          "hitting_rbi: " + hitting_rbi + "\n" +
     
                          "pitching_era: " + pitching_era + "\n" +

                          "onbase_h: " + onbase_h + "\n" +
                          "onbase_s: " + onbase_s + "\n" +
                          "onbase_d: " + onbase_d + "\n" +
                          "onbase_t: " + onbase_t + "\n" +
                          "onbase_hr: " + onbase_hr + "\n" +
                          "onbase_bb: " + onbase_bb + "\n" +

                          "runs_earned: " + runs_earned + "\n" +
                          "runs_total: " + runs_total + "\n" +
                          

                          "outs_ktotal: " + outs_ktotal + "\n" +

                          "steal_stolen: " + steal_stolen + "\n" +
                          
                          "games_play: " + games_play + "\n"

                          );
    }

}