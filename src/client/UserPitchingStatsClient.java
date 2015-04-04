/*
File: UserPitchingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Pitching Stats GUI (UserPitchingStats.java)

*/
package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import gui.*;
import database.*;

/**
Class: UserPitchingStatsClient

Description:
*/
public class UserPitchingStatsClient extends UserPitchingStats implements ActionListener, ItemListener {

	private static final boolean debugOn = true;
	
	/**
	  Method: UserPitchingStatsClient
	  Inputs: none
	  Returns:

	  Description:
	*/
  public UserPitchingStatsClient() {
      SubmitPitchingStats.addActionListener(this);
      btnUpdateStatistic.addActionListener(this);
      btnDeleteStatistic.addActionListener(this);
  }
	
  /**
	  Method: debug
	  Inputs: String message
	  Returns:

	  Description:
	*/
  private void debug(String message) {
      if (debugOn){
          System.out.println("debug: " + message);
      }
  }

	
	/**
	  Method: itemStateChanged
	  Inputs: ItemEvent e
	  Returns:

	  Description:
	*/
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	  Method: actionPerformed
	  Inputs: ActionEvent e
	  Returns:

	  Description:
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SubmitPitchingStats")) {
			try {
				debug("you clicked Submit in User Stats/Pitching page");
				String date = txtDate.getText();
				String gp = txtGP.getText();
				String w = txtW.getText();
				String l = txtL.getText();
				String era = txtERA.getText();
				String saves = txtSaves.getText();
				String hits = txtHits.getText();
				String holds = txtHolds.getText();
				String runs = txtRuns.getText();
				String hbp = txtHBP.getText();

				boolean valid = isValidDate(date);
				
				//collect values if user entered the correct date format
				if (valid == true){
					// Check for empty or invalid String
	                if (date.length() == 0 || date.equals("Date")) {
	                    date = null;
	            	}
	                if (gp.length() == 0 || gp.equals("Games Played")) {
	                    gp = null;
	            	}
	                if (w.length() == 0 || w.equals("W")) {
	                    w = null;
	                }
	                if (l.length() == 0 || l.equals("L")) {
	                    l = null;
	            	}
	                if (era.length() == 0 || era.equals("ERA")) {
	                    era = null;
	            	}
	                if (saves.length() == 0 || saves.equals("Saves")) {
	                    saves = null;
	                }
	                if (hits.length() == 0 || hits.equals("Hits")) {
	                    hits = null;
	            	}
	                if (holds.length() == 0 || holds.equals("Holds")) {
	                    holds = null;
	            	}
	                if (runs.length() == 0 || runs.equals("Runs")) {
	                    runs = null;
	                }
	                if (hbp.length() == 0 || hbp.equals("HBP")) {
	                    hbp = null;
	            	}
	                
	                //Add input into user database, then display all game statistics
	                LocalPlayerPitchingStatistics.addLocalPlayerPitchingStatistics(date, gp, w, l, era, saves, hits, holds, runs, hbp);
	                
	                //reload statistics into table
	                loadUserInfoIntoControls();
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid date format. Please add date in MM/DD/YYYY", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
				}
                
			} catch (RuntimeException ex){
				throw ex;	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("UpdateStatistic")) {
			debug("You clicked on update statistic in user pitching stats client");
		}
		if (e.getActionCommand().equals("DeleteStatistic")) {
			debug("You clicked on delete statistic in user pitching stats client");
		}
	}
	
	public void populateLocalPlayersPitchingTable() {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID", "Date", "GP",
				"W", "L", "ERA", "SAVES", "HITS", "HOLDS", "RUNS", "HBP"}, 0);

		if(User.getCurrentUser() != null){
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			// Get a list of Local Players
			ArrayList<LocalPlayerPitchingStatistics> currentPlayerPitchingStatistics = 
					LocalPlayerPitchingStatistics.getStatisticsFromDatabase(id_in); 
			
			// Add the Local Players to the List
			for (LocalPlayerPitchingStatistics m : currentPlayerPitchingStatistics) {
				Object[] row = { m.getLocalPlayerId(), m.getGame_date(), m.getPitching_games_play(), m.getPitching_games_win(),
						m.getPitching_games_loss(), m.getPitching_era(), m.getPitching_games_save(), m.getPitching_games_hit(),
						m.getPitching_games_hold(), m.getPitching_runs_total(), m.getPitching_hbp()};
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
		}		
	}
	
	public void loadUserInfoIntoControls(){
		// Reload the Local Players Pitching Statistics Table
		populateLocalPlayersPitchingTable();
	}
	
	public boolean isValidDate(String gameDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		boolean result = true;
		
		try {
			Date validateDate = dateFormat.parse(gameDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//debug("Invalid date format");
			result = false;
		}
		
		return result;
	}
}