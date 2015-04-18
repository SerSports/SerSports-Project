/*
File: UserBattingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Batting Stats GUI (UserBattingStats.java)

*/
package client;

import gui.*;
import database.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
Class: UserBattingStatsClient

Description:
*/
public class UserBattingStatsClient extends UserBattingStats implements ActionListener {
	
	//private static final long serialVersionUID = 1L;
	private static final boolean debugOn = true;
	private double battingAverage = 0.0;
	
    /**
	  Method: UserBattingStatsClient
	  Inputs: none
	  Returns:

	  Description:
	*/
    public UserBattingStatsClient() {
    	submitBattingStats.addActionListener(this);
    	btnUpdateStatistic.addActionListener(this);
    	btnDeleteStatistic.addActionListener(this);
    }
	
    /**
	  Method: debug
	  Inputs: String message
	  Returns:

	  Description:
	*/
    public void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
    
    public void setBattingAverage(double hit, double atBase){
    	if (atBase != 0)
    		battingAverage = hit / atBase;
    	else
    		battingAverage = 0.0;
    }
    
    public double getBattingAverage(){
    	return battingAverage;
    }
	
	/**
	  Method: actionPerformed
	  Inputs: ActionEvent e
	  Returns:

	  Description:
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SubmitBattingStats")) {
			try {
				submitBattingStatistic();
			} catch (RuntimeException ex){
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
					updateBattingStatistic();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please select a row in which you would like to update", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if (e.getActionCommand().equals("DeleteStatistic")) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow >= 0) {
				
				//ask user if the statistic they selected is the one they really want to update
				int result = JOptionPane.showConfirmDialog(
						null, "WARNING: Are you sure you want to delete the highlighted game statistic?", 
						null, JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION){
					deleteBattingStatistic();
				}
			}
			else{
				JOptionPane.showMessageDialog(
						null, "Please select a row in which you would like to delete", 
						"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void populateLocalPlayersBattingTable() {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "StatID", "Date",
				"AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO", "BA"}, 0);

		if(User.getCurrentUser() != null){
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			// Get a list of Local Players
			ArrayList<LocalPlayerBattingStatistics> currentPlayerBattingStatistics = LocalPlayerBattingStatistics.getStatisticsFromDatabase(id_in); 
			
			// Add the Local Players to the List
			for (LocalPlayerBattingStatistics m : currentPlayerBattingStatistics) {
				setBattingAverage( (double) m.getHitting_onbase_h(), (double) m.getHitting_ab());
				Object[] row = { m.getLocalPlayersHittingStatisticsID(), 
						m.getGame_date(), 
						m.getHitting_ab(), m.getHitting_onbase_h(), 
						m.getHitting_rbi(), m.getHitting_onbase_s(), 
						m.getHitting_onbase_d(), m.getHitting_onbase_t(), 
						m.getHitting_runs_total(), m.getHitting_steal_stolen(), 
						m.getHitting_onbase_hr(), m.getHitting_outs_ktotal(),
						getBattingAverage() };
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
		}
	}
	
	public void submitBattingStatistic(){

		String date = txtDate.getText();
		String ab = txtAB.getText();
		String h = txtHits.getText();
		String rbi = txtRBI.getText();
		String b1 = txtb_1.getText();
		String b2 = txtb_2.getText();
		String b3 = txtb_3.getText();
		String runs = txtRuns.getText();
		String sb = txtSB.getText();
		String hr = txtHR.getText();
		String so = txtSO.getText();
	
		boolean valid = isValidDate(date);
		
		//collect values if user entered the correct date format
		if (valid == true){
			// Check for empty or invalid String
            isValidInput(ab);
            isValidInput(h);
            isValidInput(rbi);
            isValidInput(b1);
            isValidInput(b2);
            isValidInput(b3);
            isValidInput(runs);
            isValidInput(sb);
            isValidInput(hr);
            isValidInput(so);
            
            //Add input into user database, then display all game statistics
            LocalPlayerBattingStatistics.addLocalPlayerBattingStatistics(date, ab, h, rbi, 
            		b1, b2, b3, runs, sb, hr, so);
            
            //reload statistics into table
            loadUserInfoIntoControls();
            
            //reset fields
            resetTextFields();
		}
		else{
			JOptionPane.showMessageDialog(null, "Please add correct date in YYYY-MM-DD format", 
					"InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void deleteBattingStatistic(){
		//get currently highlighted row
		int selectedRow = table.getSelectedRow();
		
		//get localPlayersHittingStatisticsID from that row and delete row
		int selectedStatisticID = (int) table.getModel().getValueAt(selectedRow, 0);
		LocalPlayerBattingStatistics.deleteLocalPlayerBattingStatistic(selectedStatisticID);
		
		//reload statistics into table
        loadUserInfoIntoControls();
	}
	
	public void updateBattingStatistic(){
		//delete statistic
		deleteBattingStatistic();
		
		//replace with new statistic
		submitBattingStatistic();
	}

	public void loadUserInfoIntoControls(){
		// Reload the Local Players Batting Statistics Table
		populateLocalPlayersBattingTable();
	}
	
	public boolean isValidDate(String gameDate){
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
		txtAB.setText(getABTxt());
		txtHits.setText(getHitsTxt());
		txtRBI.setText(getRBITxt());
		txtb_1.setText(getB1Txt());
		txtb_2.setText(getB2Txt());
		txtb_3.setText(getB3Txt());
		txtRuns.setText(getRunsTxt());
		txtSB.setText(getSBTxt());
		txtHR.setText(getHRTxt());
		txtSO.setText(getSOTxt());
	}
}