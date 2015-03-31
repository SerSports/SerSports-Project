package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.MlbPlayer;
import gui.BrowseMlbPlayers;
import database.MlbPlayerStatistics;
import database.MlbPlayerFieldingStatistics;
import database.MlbPlayerPitchingStatistics;
import database.MlbPlayerBattingStatistics;

public class BrowseMLBPlayersClient extends BrowseMlbPlayers implements
		ActionListener {

	/**
	 * Method: BrowseMLBPlayersClient
	 *  Inputs: none
	 *  Returns: NA
	 * 
	 * Description: Constructor
	 */
	public BrowseMLBPlayersClient() {

		// Add ourself as an action listener to the command buttons
		SubmitMlbSearch.addActionListener(this);
		btnSeePlayerStats.addActionListener(this);

		// Populate the Mlb players Table
		populateMLBPlayersTable();
	}

	/**
	 * Method: actionPerformed
	 *  Inputs: ActionEvent e
	 *   Returns: NA
	 * 
	 * Description:
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Submit Mlb Search Clicked
		if (e.getActionCommand().equals("Submit")) {
			
			// Reload the Table
			populateMLBPlayersTable();

			// See Player Stats
		} else if (e.getActionCommand().equals("See Player Stats")) {
			
			// Load the Selected Player
			loadSelectedPlayer();
		}
	}

	private void populateMLBPlayersTable() {
		
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
     
        // Get a list of Mlb Players
        ArrayList<MlbPlayer> players = MlbPlayer.getPlayersFromDatabase("", firstName, lastName, team);
        
        // Add the Mlb Players to the List
        for(MlbPlayer m: players) {
            Object[] row = {m.getId() ,m.getFirstName(), m.getLastName(), m.getTeam()};
            newTable.addRow(row);
        }
        table.setModel(newTable);
        table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadSelectedPlayer() {
		
		// Get the value from the table - Key is in first hidden row
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0) {
			int MLBPlayerId = (Integer) table.getModel().getValueAt(selectedRow, 0);	
	
			// Get the Selected Player
			ArrayList<MlbPlayer> playerList = MlbPlayer.getPlayersFromDatabase(Integer.toString(MLBPlayerId) , "", "", "");
			if (playerList != null) {
				MlbPlayer selectedPlayer = playerList.get(0);
				
				// Load the Player's Data into the controls
				loadBattingGameData(selectedPlayer);
				loadFieldingGameData(selectedPlayer);
				loadPitchingGameData(selectedPlayer);
			}
		}
	}
	
	private void loadBattingGameData(MlbPlayer player) {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO"}, 0);
		
        // Get a list of Mlb Players
        ArrayList<MlbPlayerBattingStatistics> players = MlbPlayerBattingStatistics.getStatisticsFromDatabase(Integer.parseInt(player.getId()));
        
        // Add the Mlb Players to the List
        for(MlbPlayerBattingStatistics m: players) {
            Object[] row = {m.getHitting_games_play(), m.getHitting_ab(), m.getHitting_onbase_h(), m.getHitting_rbi(), 
            				m.getHitting_onbase_s(), m.getHitting_onbase_d(), m.getHitting_onbase_t(),
            				m.getHitting_runs_total(), m.getHitting_steal_stolen(), m.getHitting_onbase_hr(), m.getHitting_outs_ktotal()};
            newTable.addRow(row);
        }
        battingTable.setModel(newTable);
        battingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadFieldingGameData(MlbPlayer player) {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}, 0);
		
        // Get a list of Mlb Players
        ArrayList<MlbPlayerFieldingStatistics> players = MlbPlayerFieldingStatistics.getStatisticsFromDatabase(Integer.parseInt(player.getId()));
        
        // Add the Mlb Players to the List
        for(MlbPlayerFieldingStatistics m: players) {
            Object[] row = {m.getFielding_games_play(), m.getFielding_games_win(), m.getFielding_games_loss(),
            				m.getFielding_po(), m.getFielding_error(), m.getFielding_a(), m.getFielding_fpct()};
            newTable.addRow(row);
        }
        fieldingTable.setModel(newTable);
        fieldingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	private void loadPitchingGameData(MlbPlayer player) {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}, 0);
		
        // Get a list of Mlb Players
        ArrayList<MlbPlayerPitchingStatistics> players = MlbPlayerPitchingStatistics.getStatisticsFromDatabase(Integer.parseInt(player.getId()));
        
        // Add the Mlb Players to the List
        for(MlbPlayerPitchingStatistics m: players) {
            Object[] row = {m.getPitching_games_play(), m.getPitching_games_win(), m.getPitching_games_loss(), m.getPitching_era(), 
            				m.getPitching_games_save(), m.getPitching_onbase_h(), m.getPitching_games_hold(), m.getPitching_runs_total(),
            				0};
            newTable.addRow(row);
        }
        pitchingTable.setModel(newTable);
        pitchingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
}
