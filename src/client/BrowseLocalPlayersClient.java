package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.LocalPlayer;
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
}
