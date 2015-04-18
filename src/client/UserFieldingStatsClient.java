/*
File: UserFieldingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Fielding Stats GUI (UserFieldingStats.java)

 */
package client;

import gui.UserFieldingStats;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import database.*;

/**
 * Class: UserFieldingStatsClient
 * 
 * Description:
 */
public class UserFieldingStatsClient extends UserFieldingStats implements ActionListener {

	private static final boolean debugOn = true;

	/**
	 * Method: UserFieldingStatsClient Inputs: none Returns:
	 * 
	 * Description:
	 */
	public UserFieldingStatsClient() {
		SubmitFieldingStats.addActionListener(this);
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
		if (e.getActionCommand().equals("SubmitFieldingStats")) {
			try {
				submitFieldingStatistic();
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
					updateFieldingStatistic();
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
					deleteFieldingStatistic();
				}
			} else {
				JOptionPane.showMessageDialog(
						null, "Please select a row in which you would like to delete",
						"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void populateLocalPlayersFieldingTable() {

		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] {
				"StatID", "Date", "Wins", "Losses", "PO", "Err",
				"Assist", "F%" }, 0);

		if (User.getCurrentUser() != null) {
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();

			// Get a list of Local Players
			ArrayList<LocalPlayerFieldingStatistics> currentPlayerFieldingStatistics = 
					LocalPlayerFieldingStatistics.getStatisticsFromDatabase(id_in);

			// Add the Local Players to the List
			for (LocalPlayerFieldingStatistics m : currentPlayerFieldingStatistics) {
				Object[] row = { m.getLocalPlayersFieldingStatisticsID(),
						m.getGame_date(),
						m.getFielding_games_win(), m.getFielding_games_loss(),
						m.getFielding_po(), m.getFielding_error(),
						m.getFielding_assist(), m.getFielding_fpct() };
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
		}
	}

	public void submitFieldingStatistic(){
		String date = txtDate.getText();
		String wins = txtWins.getText();
		String loss = txtLoss.getText();
		String po = txtPo.getText();
		String error = txtE.getText();
		String assist = txtA.getText();
		String fpct = txtFpct.getText();

		boolean valid = isValidDate(date);

		// collect values if user entered the correct date format
		if (valid == true) {
			// Check for empty or invalid String
			isValidInput(date);
			isValidInput(wins);
			isValidInput(loss);
			isValidInput(po);
			isValidInput(error);
			isValidInput(assist);
			isValidInput(fpct);
			
			// Add input into user database, then display all game statistics
			LocalPlayerFieldingStatistics.addLocalPlayerFieldingStatistics(date, wins,
							loss, po, error, assist, fpct);

			// reload statistics into table
			loadUserInfoIntoControls();
			
			resetTextFields();
			
		} else {
			JOptionPane.showMessageDialog(
					null, "Please add correct date in YYYY-MM-DD format",
					"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
		}


	}
	
	public void deleteFieldingStatistic() {
		// get currently highlighted row
		int selectedRow = table.getSelectedRow();

		// get localPlayersHittingStatisticsID from that row and delete that row
		int selectedStatisticID = (int) table.getModel().getValueAt(selectedRow, 0);
		LocalPlayerFieldingStatistics.deleteLocalPlayerFieldingStatistic(selectedStatisticID);

		// reload statistics into table
		loadUserInfoIntoControls();
	}

	public void updateFieldingStatistic(){
		//delete statistic
		deleteFieldingStatistic();
		
		//replace with new statistic
		submitFieldingStatistic();
	}
	
	public void loadUserInfoIntoControls() {
		// Reload the Local Players Fielding Statistics Table
		populateLocalPlayersFieldingTable();
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
		txtWins.setText(getWinsTxt());
		txtLoss.setText(getLossesTxt());
		txtPo.setText(getPOTxt());
		txtE.setText(getErrorTxt());
		txtA.setText(getAssistTxt());
		txtFpct.setText(getFieldPercentageTxt());
	}
}