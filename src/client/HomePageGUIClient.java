package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.ComparePlayers;
import database.LocalPlayer;
import database.LocalPlayerBattingStatistics;
import database.LocalPlayerFieldingStatistics;
import database.MlbPlayer;
import database.User;
import gui.HomePageGUI;
import gui.MainGUI;

public class HomePageGUIClient extends HomePageGUI implements ActionListener, ItemListener {
	
	public HomePageGUIClient() {
		btnSignOut.addActionListener(this);
		btnFindBestComparison.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//debug("Test");
		if (e.getActionCommand().equals("Sign Out")) {
			MainGUI.setApplicationToClose(); 
		} else if (e.getActionCommand().equals("Find Best Comparison")) {
			
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
		
		// Add the Local Players to the List
		for (MlbPlayer m : players) {
			Object[] row = {m.getId(), m.getFirst_name(), m.getLast_name(), m.getTeam_name(), 0.5};
			newTable.addRow(row);
		}

		comparisonTable.setModel(newTable);
		comparisonTable.removeColumn(comparisonTable.getColumnModel().getColumn(0));
	}
}
