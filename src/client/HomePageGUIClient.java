package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.ComparePlayers;
import database.ComparisonResult;
import database.LocalPlayer;
import database.MlbPlayer;
import database.User;
import gui.HomePageGUI;
import gui.ModifiedJTable;

/**
 * Generates a list of the ten most similar players compared to the current user's
 * personal statistics and displays a percentage value that represents the overall
 * similarity between the two players.
 * 
 * @author SerSports
 */
public class HomePageGUIClient extends HomePageGUI implements ActionListener,
		ItemListener
{
	/**
	 * Adds action listener to the Find Best Comparison button and calls the Find Best
	 * Comparison method to populate the most similar player
	 */
	public HomePageGUIClient()
	{
		btnFindBestComparison.addActionListener(this);
		
		findBestComparisons();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * Evaluates the most similar player taking into account the current user's personal
	 * statistics
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Find Best Comparison"))
		{
			findBestComparisons();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		// TODO Auto-generated method stub
	}
	
	/**
	 * Retrieves a Local Player from the generated list based on an assigned Player ID
	 * field as well as a list of similar player matches based on the similarity of each
	 * relevant statistic. Populates the table with the matched players and displays a
	 * percentage of similarity and shows the results.
	 */
	private void findBestComparisons()
	{
		
		if (User.getCurrentUser() != null)
		{
			ArrayList<LocalPlayer> list = LocalPlayer.getPlayersFromDatabase(User
					.getCurrentUser().getLocalPlayerId(), null, null, 0, null);
			LocalPlayer userPlayer = list.get(0);
			
			ArrayList<ComparisonResult> matches = ComparePlayers.compareToPlayerList(
					userPlayer, MlbPlayer.getListOfPlayersFromDatabase());
			
			populateTable(matches);
			
			ComparisonResult result = matches.get(0);
			MlbPlayer player = result.getPlayer();
			label.setText(Math.round(result.getScore() * 1000.0) / 10.0 + "%");
			lblInsertPlayersName.setText(player.getFirst_name() + " "
					+ player.getLast_name());
		}
	}
	
	/**
	 * Sets up the table with the default values for comparison and appends the first ten
	 * players with the most similar statistics to the selected player to the list.
	 * 
	 * @param comparisonResults
	 */
	private void populateTable(ArrayList<ComparisonResult> comparisonResults)
	{
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID",
				"First Name", "Last Name", "Team", "Similarity %" }, 0);
		
		for (int i = 0; i < comparisonResults.size() && i < 10; i++)
		{
			ComparisonResult result = comparisonResults.get(i);
			MlbPlayer m = result.getPlayer();
			
			if (result.getScore() > 0) {
				Object[] row = { m.getId(), m.getFirst_name(), m.getLast_name(),
						m.getTeam_name(), 100 * result.getScore() };
				newTable.addRow(row);
			}
		}
		
		comparisonTable.setModel(newTable);
		comparisonTable.removeColumn(comparisonTable.getColumnModel().getColumn(0));
		((ModifiedJTable) comparisonTable).updateRowHeights();
	}
	
	/**
	 * Reloads the current user.
	 */
	public void loadUserInfoIntoControls()
	{
		currentUser = User.getCurrentUser();
		if (currentUser != null)
		{
			userFirstName.setText(currentUser.getUserName());
			findBestComparisons();
		}
	}
}
