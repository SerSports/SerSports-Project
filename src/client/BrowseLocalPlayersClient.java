package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import database.LocalPlayer;
import database.LocalPlayerBattingStatistics;
import database.LocalPlayerFieldingStatistics;
import database.LocalPlayerPitchingStatistics;
import gui.BrowseLocalPlayers;

/**
 * Manages Local Players and all relevant information pertaining to Local Players
 * including the batting, fielding, and pitching statistics specific to the currently
 * selected player. Populates the selected table with the Local Player's data if the user
 * chooses to do so.
 * 
 * @author SerSports
 */
public class BrowseLocalPlayersClient extends BrowseLocalPlayers implements
		ActionListener
{
	/**
	 * Adds action listener's to the two appropriate buttons and calls method to populate
	 * the Local Player's Table.
	 */
	public BrowseLocalPlayersClient()
	{
		SubmitLocalSearch.addActionListener(this);
		btnSeePlayerStats.addActionListener(this);
		
		populateLocalPlayersTable();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * Reloads the Local Player's Table if the "Submit" button is clicked and loads the
	 * selected player's statistics if "See Player Stats" is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Submit"))
		{
			populateLocalPlayersTable();
		}
		else if (e.getActionCommand().equals("See Player Stats"))
		{
			loadSelectedPlayer();
		}
	}
	
	/**
	 * Populates the default model for Local Player's Table and retrieves search values if
	 * applicable. Checks the search value fields for empty or invalid strings and then
	 * gets a list of local players and adds the valid local players to that list.
	 */
	private void populateLocalPlayersTable()
	{
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID",
				"First Name", "Last Name", "Team" }, 0);
		
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		String team = txtTeam.getText();
		
		if (firstName.length() == 0 || firstName.equals("First Name"))
		{
			firstName = null;
		}
		if (lastName.length() == 0 || lastName.equals("Last Name"))
		{
			lastName = null;
		}
		if (team.length() == 0 || team.equals("Team"))
		{
			team = null;
		}
		
		ArrayList<LocalPlayer> players = LocalPlayer.getPlayersFromDatabase(0, firstName,
				lastName, 0, team);
		
		for (LocalPlayer m : players)
		{
			Object[] row = { m.getLocalPlayerId(), m.getFirstName(), m.getLastName(),
					m.getTeamName() };
			newTable.addRow(row);
		}
		
		table.setModel(newTable);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	/**
	 * Retrieves the currently selected player by acquiring its assigned Player ID and
	 * then loads that player's data into the controls.
	 */
	private void loadSelectedPlayer()
	{
		/*
		 * Get the value from the table, the key is in the first hidden row of the table.
		 */
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0)
		{
			int localPlayerId = (Integer) table.getModel().getValueAt(selectedRow, 0);
			
			ArrayList<LocalPlayer> playerList = LocalPlayer.getPlayersFromDatabase(
					localPlayerId, null, null, 0, null);
			LocalPlayer selectedPlayer = playerList.get(0);
			
			loadBattingGameData(selectedPlayer);
			loadFieldingGameData(selectedPlayer);
			loadPitchingGameData(selectedPlayer);
		}
	}
	
	/**
	 * Sets up table with default values for batting statistics, retrieves a list of Local
	 * Players and then adds their corresponding statistics to the table.
	 * 
	 * @param player
	 */
	private void loadBattingGameData(LocalPlayer player)
	{
		
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "Won", "AB", "H",
				"RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO" }, 0);
		
		ArrayList<LocalPlayerBattingStatistics> players = LocalPlayerBattingStatistics
				.getStatisticsFromDatabase(player.getLocalPlayerId());
		
		for (LocalPlayerBattingStatistics m : players)
		{
			String won = new String(m.getBatting_game_won() == 1 ? "X" : "");
			Object[] row = { won, m.getBatting_ab(), m.getBatting_onbase_h(),
					m.getBatting_rbi(), m.getBatting_onbase_s(), m.getBatting_onbase_d(),
					m.getBatting_onbase_t(), m.getBatting_runs_total(),
					m.getBatting_steal_stolen(), m.getBatting_onbase_hr(),
					m.getBatting_outs_ktotal() };
			newTable.addRow(row);
		}
		
		battingTable.setModel(newTable);
		battingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	/**
	 * Sets up table with default values for fielding statistics, retrieves a list of
	 * Local Players and then adds their corresponding statistics to the table.
	 * 
	 * @param player
	 */
	private void loadFieldingGameData(LocalPlayer player)
	{
		
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "Won",
				"Losses", "PO", "Err", "Assist", "F%" }, 0);
		
		ArrayList<LocalPlayerFieldingStatistics> players = LocalPlayerFieldingStatistics
				.getStatisticsFromDatabase(player.getLocalPlayerId());
		
		for (LocalPlayerFieldingStatistics m : players)
		{
			String won = new String(m.getFielding_game_won() == 1 ? "X" : "");
			Object[] row = { won, m.getFielding_po(), m.getFielding_error(), m.getFielding_assist(), m.getFielding_fpct() };
			newTable.addRow(row);
		}
		
		fieldingTable.setModel(newTable);
		fieldingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	/**
	 * Sets up table with default values for pitching statistics, retrieves a list of
	 * Local Players and then adds their corresponding statistics to the table.
	 * 
	 * @param player
	 */
	private void loadPitchingGameData(LocalPlayer player)
	{
		
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "Won",
				"ERA", "SAVES", "HITS", "HOLDS", "RUNS", "HBP" }, 0);
		
		ArrayList<LocalPlayerPitchingStatistics> players = LocalPlayerPitchingStatistics
				.getStatisticsFromDatabase(player.getLocalPlayerId());
		
		for (LocalPlayerPitchingStatistics m : players)
		{
			String won = new String(m.getPitching_game_won() == 1 ? "X" : "");
			Object[] row = { won,
					m.getPitching_era(), m.getPitching_games_save(),
					m.getPitching_games_hit(), m.getPitching_games_hold(),
					m.getPitching_runs(), m.getPitching_hbp() };
			newTable.addRow(row);
		}
		
		pitchingTable.setModel(newTable);
		pitchingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
}
