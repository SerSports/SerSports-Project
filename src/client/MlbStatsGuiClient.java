/*
File: MlbStatsGuiClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the MLB Stats GUI (MlbStatsGui.java)

*/
package client;

import gui.*;
import database.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
Class: MlbStatsGuiClient

Description:
*/
public class MlbStatsGuiClient extends MlbStatsGui implements ActionListener, ItemListener {
    
    private static final long serialVersionUID = 1L;
    private static final byte COLUMN_VALUE = 0;
    private static final boolean debugOn = true;
    
    private ArrayList<MlbPlayer> arrListWithSelectedPlayer;
    
    /**
	  Method: MlbStatsGuiClient
	  Inputs: none
	  Returns:

	  Description:
	*/
    public MlbStatsGuiClient() {
        submitPlayerSearchButton.addActionListener(this);
    }
    
    /**
	  Method: debug
	  Inputs: String message
	  Returns:

	  Description:
	*/
    private void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
    
    /**
	  Method: itemStateChanged
	  Inputs: ItemEvent e
	  Returns:

	  Description:
	*/
    @Override
    public void itemStateChanged(ItemEvent e) {
        try {
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
	  Method: actionPerformed
	  Inputs: ActionEvent e
	  Returns:

	  Description:
	*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("submitPlayerSearchButton")) {
            try {
                debug("you clicked Submit Search");
                String fName = txtFirstName.getText();
                String lName = txtLastName.getText();
                String team = txtTeam.getText();
                
                // Check for empty or invalid String
                if (fName.length() == 0 || fName.equals("First Name")) {
                    fName = null;
            	}
                if (lName.length() == 0 || lName.equals("Last Name")) {
                    lName = null;
            	}
                if (team.length() == 0 || team.equals("Team")) {
                    team = null;
                }
                
                DefaultTableModel newTable = new DefaultTableModel(new Object[]{"ID", "First Name", "Last Name", "Team"/* "Position" */}, 0);
                
                ArrayList<MlbPlayer> players = MlbPlayer.getPlayersFromDatabase(null, fName, lName, team);
                
                for(MlbPlayer m: players) {
                    Object[] row = {m.getId() ,m.getFirstName(), m.getLastName(), m.getTeam()};
                    newTable.addRow(row);
                }
                
                table.setModel(newTable);
                table.removeColumn(table.getColumnModel().getColumn(0));
                
            } catch (RuntimeException ex){
				throw ex;    
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("See Player Stats")) {
            try {
				//MainGUI frame = new MainGUI();
				new MainGUI();
            	
				ApplicationGUI firstPanel = new ApplicationGUI();
		        firstPanel.setOpaque(true);

		        MLBPlayerProfile secondPanel = new MLBPlayerProfile();
		        secondPanel.setOpaque(true);

		        //check to see if this method gets called when SeePlayerStats button is pushed 
				debug("you clicked SeePlayerStats");

				//get the row number in which the user highlighted
				int rowSelected = table.getSelectedRow();
				
				//get the id value number in the hidden column of the selected (highlighted) row (player)
				//use that value to find the player in the database and return the player in a list
				if(rowSelected >= 0){
					String selectedPlayer = (String) table.getModel().getValueAt(rowSelected, COLUMN_VALUE);				
					loadSelectedPlayer();
					//will get the mlb player from database, can delete later
					//ArrayList<MlbPlayer> arrListWithSelectedPlayer = MlbPlayer.getPlayersFromDatabase(selectedPlayer, null, null, null);
					//arrListWithSelectedPlayer = MlbPlayer.getPlayersFromDatabase(selectedPlayer, null, null, null);

				} else {
					debug("ERROR: An MLB player has NOT been selected!");
				}
	       
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
    }
private void loadSelectedPlayer() {
		
		// Get the value from the table - Key is in first hidden row
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			int mlbPlayerId = (Integer) table.getModel().getValueAt(selectedRow, 0);	
	
			// Get the Selected Player
			ArrayList<MlbPlayer> playerList = MlbPlayer.getPlayersFromDatabase(Integer.toString(mlbPlayerId), "", "", "");
			if (playerList != null) {
				MlbPlayer selectedPlayer = playerList.get(0);
				mlbfieldingTable = new JTable(new DefaultTableModel(null, new Object[]{selectedPlayer.getFielding_games_play(), 
						selectedPlayer.getFielding_games_win(), selectedPlayer.getFielding_games_loss(),
						selectedPlayer.getFielding_po(), selectedPlayer.getFielding_error(), selectedPlayer.getFielding_a(),
						selectedPlayer.getFielding_fpct()}));
			}
		}
		
		/**
		 * mlbfieldingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		 * mlbpitchingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		 * battingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO"}));
		 */
	}
}