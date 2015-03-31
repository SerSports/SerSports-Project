package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.LocalPlayer;
import database.LocalPlayerBattingStatistics;
import gui.BrowseLocalPlayers;

public class BrowseLocalPlayersClient extends BrowseLocalPlayers implements
		ActionListener {

	/**
	 * Method: MlbStatsGuiClient Inputs: none Returns:
	 * 
	 * Description:
	 */
	public BrowseLocalPlayersClient() {

		// Add ourself as an action listener to the command buttons
		SubmitLocalSearch.addActionListener(this);
		btnSeePlayerStats.addActionListener(this);

		// Populate the Local players Table
		populateLocalPlayersTable();
	}

	/**
	 * Method: MlbStatsGuiClient Inputs: none Returns:
	 * 
	 * Description:
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Submit Local Search Clicked
		if (e.getActionCommand().equals("Submit")) {
			
			// Reload the Table
			populateLocalPlayersTable();

			// See Player Stats
		} else if (e.getActionCommand().equals("See Player Stats")) {
			
			// Load the Selected Player
			loadSelectedPlayer();
		}
	}

	private void populateLocalPlayersTable() {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[]{"ID", "First Name", "Last Name", "Team"/* "Position" */}, 0);
		
		// Get the search values
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String team = txtTeam.getText();

		// Check for empty or invalid String
        if (firstName.length() == 0 || firstName.equals("First Name")) {
        	firstName = null;
    	}
        if (lastName.length() == 0 || lastName.equals("Last Name")) {
        	lastName = null;
    	}
        if (team.length() == 0 || team.equals("Team")) {
            team = null;
        }
     
        // Get a list of Local Players
        ArrayList<LocalPlayer> players = LocalPlayer.getPlayersFromDatabase(0, firstName, lastName, 0, team);
        
        // Add the Local Players to the List
        for(LocalPlayer m: players) {
            Object[] row = {m.getLocalPlayerId() ,m.getFirstName(), m.getLastName(), m.getTeamName()};
            newTable.addRow(row);
        }
        table.setModel(newTable);
        table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadSelectedPlayer() {
		
		// Get the value from the table - Key is in first hidden row
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			int localPlayerId = (Integer) table.getModel().getValueAt(selectedRow, 0);	
	
			// Get the Selected Player
			ArrayList<LocalPlayer> playerList = LocalPlayer.getPlayersFromDatabase(localPlayerId, null, null, 0, null);
			if (playerList != null) {
				LocalPlayer selectedPlayer = playerList.get(0);
				
				// Load the Player's Data into the controls
				loadBattingGameData(selectedPlayer);
				loadFieldingGameData(selectedPlayer);
				loadPitchingGameData(selectedPlayer);
			}
		}
	}
	
	private void loadBattingGameData(LocalPlayer player) {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[]{"GP","AB","H","RBI","Runs","SB","HR","SO"}, 0);
		
        // Get a list of Local Players
        ArrayList<LocalPlayerBattingStatistics> players = LocalPlayerBattingStatistics.getStatisticsFromDatabase(player.getLocalPlayerId());
        
        // Add the Local Players to the List
        for(LocalPlayerBattingStatistics m: players) {
            Object[] row = {m.getHitting_games_play(), m.getHitting_ab(), m.getHitting_onbase_h(), m.getHitting_rbi(), 
            				m.getHitting_runs_total(), m.getHitting_steal_stolen(), m.getHitting_onbase_hr(), m.getHitting_outs_ktotal()};
            newTable.addRow(row);
        }
        battingTable.setModel(newTable);
        battingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadFieldingGameData(LocalPlayer player) {
		
	}
	
	private void loadPitchingGameData(LocalPlayer player) {
		
	}
}
