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
        btnSeePlayerStats.addActionListener(this);
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
        } else if (e.getActionCommand().equals("SeePlayerStats")) {
            try {
            	
				ApplicationGUI firstPanel = new ApplicationGUI();
		        firstPanel.setOpaque(true);

		        MLBPlayerProfile secondPanel = new MLBPlayerProfile();
		        secondPanel.setOpaque(true);

		        //check to see if this method gets called when SeePlayerStats button is pushed 
				debug("you clicked SeePlayerStats");
				
				loadSelectedPlayer();
	       
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
    }
    private void loadSelectedPlayer() {
	
	// Get the value from the table - Key is in first hidden row
		int selectedRow = table.getSelectedRow();
		//System.out.println("selected row: " + selectedRow);
		
		if (selectedRow >= 0) {	
			String MlbPlayerId = (String) table.getModel().getValueAt(selectedRow, 0);
			//System.out.println("mlb player id: " + MlbPlayerId);
	
			// Get the Selected Player
			ArrayList<MlbPlayer> playerList = MlbPlayer.getPlayersFromDatabase(MlbPlayerId, null, null, null);
			if (playerList != null) {
				MlbPlayer selectedPlayer = playerList.get(0);
				
				// Load the Player's Data into the controls
				loadGameData(selectedPlayer);
			}
		}
    }
				
	private void loadGameData(MlbPlayer player) {
		// Get a list of the Mlb Player's Stats
        ArrayList<MlbPlayer> players = MlbPlayer.getStatisticsFromDatabase(player.getId()); 
        
		// Set up the Hitting table
		DefaultTableModel bTable = new DefaultTableModel(new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO"}, 0);		      
        // Create the row of Hitting Stats
        Object[] hRow = {player.getHitting_games_play(), player.getHitting_ab(), player.getHitting_onbase_h(), player.getHitting_rbi(), 
        				player.getHitting_onbase_s(), player.getHitting_onbase_d(), player.getHitting_onbase_t(),
        				player.getHitting_runs_total(), player.getHitting_steal_stolen(), player.getHitting_onbase_hr(), player.getHitting_outs_ktotal()};
        bTable.addRow(hRow);
        mlbbattingTable.setModel(bTable);
        mlbbattingTable.removeColumn(table.getColumnModel().getColumn(0));
		
        // Set up the Fielding Table
    	DefaultTableModel fTable = new DefaultTableModel(new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}, 0);
        // Create the row of Fielding Stats
    	Object[] fRow = {player.getFielding_games_play(), player.getFielding_games_win(), player.getFielding_games_loss(),
				player.getFielding_po(), player.getFielding_error(), player.getFielding_a(), player.getFielding_fpct()};
    	fTable.addRow(fRow);
        fTable.addRow(fRow);
        mlbfieldingTable.setModel(fTable);
        mlbfieldingTable.removeColumn(table.getColumnModel().getColumn(0));
        
        // Set up the Pitching Table
		DefaultTableModel pTable = new DefaultTableModel(new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","BB"}, 0);
		// Create the row of Pitching Stats
        Object[] pRow = {player.getPitching_games_play(), player.getPitching_games_win(), player.getPitching_games_loss(), player.getPitching_era(), 
        				player.getPitching_games_save(), player.getPitching_onbase_h(), player.getPitching_games_hold(), player.getPitching_runs_total(),
        				player.getPitching_onbase_bb()};
        pTable.addRow(pRow);
        mlbpitchingTable.setModel(pTable);
        mlbpitchingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
}