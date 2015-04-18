package client;

import gui.*;
import database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Gathers a list of MLB players and the statistics relevant to their position and
 * displays it in the form of a table.
 * 
 * @author SerSports
 */
public class MlbStatsGuiClient extends MlbStatsGui implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private static final boolean debugOn = true;
	
	/**
	 * Adds action listeners to relevant buttons and calls method to populate the table
	 * with the list of generated MLB players.
	 */
	public MlbStatsGuiClient()
	{
		btnCompareToPlayer.addActionListener(this);
		submitPlayerSearchButton.addActionListener(this);
		btnSeePlayerStats.addActionListener(this);
		
		populateTable();
	}
	
	/**
	 * Debugs when boolean results to true.
	 * 
	 * @param message
	 */
	private void debug(String message)
	{
		if (debugOn)
		{
			System.out.println("debug: " + message);
		}
	}
	
	/**
	 * Sets up the table with the default values for MLB players and adds the list of
	 * filtered players to the table.
	 */
	public void populateTable()
	{
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID",
				"First Name", "Last Name", "Team" }, 0);
		
		MlbPlayerFilter filter = new MlbPlayerFilter();
		filter.setFirstNameValue(txtFirstName.getText());
		filter.setLastNameValue(txtLastName.getText());
		filter.setTeamNameValue(txtTeam.getText());
		
		ArrayList<MlbPlayer> players = MlbPlayer.getPlayersFromDatabase(filter);
		for (MlbPlayer m : players)
		{
			Object[] row = { m.getId(), m.getFirst_name(), m.getLast_name(),
					m.getTeam_name() };
			newTable.addRow(row);
		}
		table.setModel(newTable);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * Calls methods relevant to the button selected by the user.
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("submitPlayerSearchButton"))
		{
			populateTable();
		}
		else if (e.getActionCommand().equals("SeePlayerStats"))
		{
			loadSelectedPlayer();
		}
		else if (e.getActionCommand().equals("CompareToPlayer"))
		{
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0)
			{
				String MlbPlayerId = (String) table.getModel().getValueAt(selectedRow, 0);
				MlbPlayer selectedPlayer = MlbPlayer.getPlayerForId(MlbPlayerId);
				
				float result = ComparePlayers.compareToPlayer(
						User.getCurrentLocalPlayer(), selectedPlayer);
				
				JOptionPane.showMessageDialog(null, "You are " + (result * 100.0)
						+ "% like this player", "Compare to Player",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	/**
	 * Retrieves the currently selected MLB player by acquiring its assigned Player ID and
	 * then loads that player's data into the controls.
	 */
	private void loadSelectedPlayer()
	{
		int selectedRow = table.getSelectedRow();
		if (selectedRow >= 0)
		{
			String MlbPlayerId = (String) table.getModel().getValueAt(selectedRow, 0);
			
			MlbPlayer selectedPlayer = MlbPlayer.getPlayerForId(MlbPlayerId);
			loadGameData(selectedPlayer);
			
			lblMlbPlayerName.setText("Name: " + selectedPlayer.getFirst_name() + " "
					+ selectedPlayer.getLast_name());
			lblMlbPlayerTeam.setText("Team: " + selectedPlayer.getTeam_name());
		}
	}
	
	/**
	 * Sets up the hitting, fielding, and pitching tables, all with rows of statistics
	 * specific to that field.
	 * 
	 * @param player
	 */
	private void loadGameData(MlbPlayer player)
	{
		/*
		 * HITTING TABLE
		 */
		DefaultTableModel bTable = new DefaultTableModel(new Object[] { "GP", "AB", "H",
				"RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO", "BA" }, 0);
		
		Object[] hRow = { player.getBatting_games_play(), player.getBatting_ab(),
				player.getBatting_onbase_h(), player.getBatting_rbi(),
				player.getBatting_onbase_s(), player.getBatting_onbase_d(),
				player.getBatting_onbase_t(), player.getBatting_runs_total(),
				player.getBatting_steal_stolen(), player.getBatting_onbase_hr(),
				player.getBatting_outs_ktotal() };
		bTable.addRow(hRow);
		mlbbattingTable.setModel(bTable);
		mlbbattingTable.removeColumn(table.getColumnModel().getColumn(0));
		
		/*
		 * FIELDING TABLE
		 */
		DefaultTableModel fTable = new DefaultTableModel(new Object[] { "GP", "Wins",
				"Losses", "PO", "Err", "Assist", "F%" }, 0);
		
		Object[] fRow = { player.getFielding_games_play(),
				player.getFielding_games_win(), player.getFielding_games_loss(),
				player.getFielding_po(), player.getFielding_error(),
				player.getFielding_a(), player.getFielding_fpct() };
		fTable.addRow(fRow);
		mlbfieldingTable.setModel(fTable);
		mlbfieldingTable.removeColumn(table.getColumnModel().getColumn(0));
		
		/*
		 * PITCHING TABLE
		 */
		DefaultTableModel pTable = new DefaultTableModel(new Object[] { "GP", "W", "L",
				"ERA", "SAVES", "HITS", "HOLDS", "RUNS", "BB" }, 0);
		
		Object[] pRow = { player.getPitching_games_play(),
				player.getPitching_games_win(), player.getPitching_games_loss(),
				player.getPitching_era(), player.getPitching_games_save(),
				player.getPitching_onbase_h(), player.getPitching_games_hold(),
				player.getPitching_runs_total(), player.getPitching_onbase_bb() };
		pTable.addRow(pRow);
		mlbpitchingTable.setModel(pTable);
		mlbpitchingTable.removeColumn(table.getColumnModel().getColumn(0));
	}
}
