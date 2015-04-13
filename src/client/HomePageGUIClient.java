package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.ComparePlayers;
import database.LocalPlayer;
import database.MlbPlayer;
import database.User;
import gui.HomePageGUI;

public class HomePageGUIClient extends HomePageGUI implements ActionListener, ItemListener {
	
	public HomePageGUIClient() {

		// Add Action Listeners
		btnFindBestComparison.addActionListener(this);
		
		// Populate the Most Similar Player
		populateMostSimilarPlayer();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//debug("Test");
		if (e.getActionCommand().equals("Find Best Comparison")) {
			
			// Get Local Player
			ArrayList<LocalPlayer> list = LocalPlayer.getPlayersFromDatabase(User.getCurrentUser().getLocalPlayerId(), null, null, 0, null);
			LocalPlayer userPlayer = list.get(0);
			
			// Get List of similar players
			ArrayList<MlbPlayer> matches = ComparePlayers.compareToPlayerList(userPlayer, MlbPlayer.getListOfPlayersFromDatabase());
			
			// Add players to table
			populateTable(matches);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void populateTable(ArrayList<MlbPlayer> players) {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] {"ID","First Name", "Last Name","Team","Similarity %"}, 0);
		
		// Add the first 10 player matches to the list
		for (int i = 0; i < players.size() && i < 10; i++) {
			MlbPlayer m = players.get(i);
			
			Object[] row = {m.getId(), m.getFirst_name(), m.getLast_name(), m.getTeam_name(), 0.5};
			newTable.addRow(row);
		}

		comparisonTable.setModel(newTable);
		comparisonTable.removeColumn(comparisonTable.getColumnModel().getColumn(0));
	}
	
	private void populateMostSimilarPlayer() {

		// Get Local Player
		if (User.getCurrentUser() != null)
		{
			ArrayList<LocalPlayer> list = LocalPlayer.getPlayersFromDatabase(User.getCurrentUser().getLocalPlayerId(), null, null, 0, null);
			LocalPlayer userPlayer = list.get(0);
			
			// Get List of similar players
			ArrayList<MlbPlayer> matches = ComparePlayers.compareToPlayerList(userPlayer, MlbPlayer.getListOfPlayersFromDatabase());
			
			// Show the result
			label.setText("30");
			MlbPlayer player = matches.get(0);
			lblInsertPlayersName.setText(player.getFirst_name() + " " + player.getLast_name());
		}
	}
	
	//method to reload name
	public void loadUserInfoIntoControls()
	{
		// Reload the Current User
		currentUser = User.getCurrentUser();
		if (currentUser != null) {
			userFirstName.setText(currentUser.getUserName());
			populateMostSimilarPlayer();
		}
	}
}
