/*
File: UserPitchingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Pitching Stats GUI (UserPitchingStats.java)

 */
package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import gui.*;
import database.*;

/**
 * Class: UserPitchingStatsClient
 * 
 * Description:
 */
public class UserPitchingStatsClient extends UserPitchingStats implements
		ActionListener {

	private static final boolean debugOn = true;

	/**
	 * Method: UserPitchingStatsClient Inputs: none Returns:
	 * 
	 * Description:
	 */
	public UserPitchingStatsClient() {
		SubmitPitchingStats.addActionListener(this);
		btnUpdateStatistic.addActionListener(this);
		btnDeleteStatistic.addActionListener(this);
	}

	/**
	 * Method: debug 
	 * Inputs: String message Returns:
	 * 
	 * Description:
	 */
	public void debug(String message) {
		if (debugOn) {
			System.out.println("debug: " + message);
		}
	}
	
	/**
	 * Method: actionPerformed Inputs: ActionEvent e Returns:
	 * 
	 * Description:
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SubmitPitchingStats")) {
			try {
				submitPitchingStatistic();
			} catch (RuntimeException ex) {
				throw ex;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("UpdateStatistic")) {

			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0) {
				
				//ask user if the statistic they selected is the one they really want to update
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the highlighted game statistic?", null,
						JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION){
					updatePitchingStatistic();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a row in which you would like to update", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if (e.getActionCommand().equals("DeleteStatistic")) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0) {

				// ask user if the statistic they selected is the one they really want to update
				int result = JOptionPane.showConfirmDialog(
						null, "WARNING: Are you sure you want to delete the highlighted game statistic?",
						null, JOptionPane.YES_NO_CANCEL_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					deletePitchingStatistic();
				}
			} else {
				JOptionPane.showMessageDialog(
						null, "Please select a row in which you would like to delete",
						"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void populateLocalPlayersPitchingTable() {

		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] {
				"StatID", "Date", "ERA", "SAVES", "HITS",
				"HOLDS", "RUNS", "HBP" }, 0);
		/*
		DefaultTableModel newTable = new DefaultTableModel(new Object[] {
				"StatID", "Date", "W", "L", "ERA", "SAVES", "HITS",
				"HOLDS", "RUNS", "HBP" }, 0);
		*/

		if (User.getCurrentUser() != null) {
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();

			// Get a list of Local Players
			ArrayList<LocalPlayerPitchingStatistics> currentPlayerPitchingStatistics = 
					LocalPlayerPitchingStatistics.getStatisticsFromDatabase(id_in);

			// Add the Local Players to the List
			for (LocalPlayerPitchingStatistics m : currentPlayerPitchingStatistics) {
				Object[] row = { m.getLocalPlayersPitchingStatisticsID(),
						m.getGame_date(), m.getPitching_game_won(),
						m.getPitching_era(), m.getPitching_games_save(),
						m.getPitching_games_hit(), m.getPitching_games_hold(),
						m.getPitching_runs(), m.getPitching_hbp() };
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));

			table.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e){
							int selectedRow = table.getSelectedRow();
							txtDate.setText(table.getValueAt(selectedRow, 0).toString());
							txtERA.setText(table.getValueAt(selectedRow, 1).toString());
							txtSaves.setText(table.getValueAt(selectedRow, 2).toString());
							txtHits.setText(table.getValueAt(selectedRow, 3).toString());
							txtHolds.setText(table.getValueAt(selectedRow, 4).toString());
							txtRuns.setText(table.getValueAt(selectedRow, 5).toString());
							txtHBP.setText(table.getValueAt(selectedRow, 6).toString());
						}
					});
		}
	}
	
	public void submitPitchingStatistic(){
		String date = txtDate.getText();
		String era = txtERA.getText();
		String saves = txtSaves.getText();
		String hits = txtHits.getText();
		String holds = txtHolds.getText();
		String runs = txtRuns.getText();
		String hbp = txtHBP.getText();
		Boolean won = (comboBox.getSelectedItem().toString().equals("Win"));

		boolean valid = isValidDate(date);

		// collect values if user entered the correct date format
		if (valid == true) {
			// Check for empty or invalid String
			isValidInput(date);
			isValidInput(saves);
			isValidInput(hits);
			isValidInput(holds);
			isValidInput(runs);
			isValidInput(hbp);

			// Add input into user database, then display all game statistics
			LocalPlayerPitchingStatistics.addLocalPlayerPitchingStatistics(date, won,
							era, saves, hits, holds, runs, hbp);

			// reload statistics into table
			loadUserInfoIntoControls();
			
			resetTextFields();
			
		} else {
			JOptionPane.showMessageDialog(
					null, "Please add correct date in YYYY-MM-DD format",
					"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void deletePitchingStatistic() {
		// get currently highlighted row
		int selectedRow = table.getSelectedRow();

		// get localPlayersHittingStatisticsID from that row and delete that row
		int selectedStatisticID = (int) table.getModel().getValueAt(selectedRow, 0);
		LocalPlayerPitchingStatistics.deleteLocalPlayerPitchingStatistic(selectedStatisticID);

		// reload statistics into table
		loadUserInfoIntoControls();
	}
	
	public void updatePitchingStatistic(){
		//delete statistic
		deletePitchingStatistic();
		
		//replace with new statistic
		submitPitchingStatistic();
	}
	
	public void loadUserInfoIntoControls() {
		// Reload the Local Players Pitching Statistics Table
		populateLocalPlayersPitchingTable();
	}

	public boolean isValidDate(String gameDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		boolean result = true;

		try {
			dateFormat.parse(gameDate);
		} catch (ParseException e) {
			result = false;
		}

		return result;
	}

	public String isValidInput(String userInput){
		String result;
		
		if(userInput.equals("") || userInput.length() == 0){
			result = null;
		}
		else{
			result = userInput;
		}
		
		try{
			Integer.parseInt(userInput);
		} catch (Exception e){
			result = null;
		}
			
		return result;
	}

	public void resetTextFields(){
		txtDate.setText(getDateTxt());
		txtW.setText(getWinsTxt());
		txtL.setText(getLossesTxt());
		txtERA.setText(getERATxt());
		txtSaves.setText(getSavesTxt());
		txtHits.setText(getHitsTxt());
		txtHolds.setText(getHoldsTxt());
		txtRuns.setText(getRunsTxt());
	}
}