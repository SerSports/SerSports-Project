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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
Class: UserBattingStatsClient

Description:
*/
public class UserBattingStatsClient extends UserBattingStats implements ActionListener, ItemListener {
	
	private static final boolean debugOn = true;
	
    /**
	  Method: UserBattingStatsClient
	  Inputs: none
	  Returns:

	  Description:
	*/
    public UserBattingStatsClient() {
        //debug("Test in UserBattingStatsClient method");
    	SubmitBattingStats.addActionListener(this);
    	
    	//loadUserInfoIntoControl();
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
		//debug("Test");
		if (e.getActionCommand().equals("SubmitBattingStats")) {
			try {
				debug("you clicked Submit in User Stats/Batting page");
				
				String date = textDate.getText();
				String gp = txtGP.getText();
				String ab = txtAB.getText();
				String h = txtH.getText();
				String rbi = txtRBI.getText();
				String b1 = txtb_1.getText();
				String b2 = txtb_2.getText();
				String b3 = txtb_3.getText();
				String runs = txtRuns.getText();
				String sb = txtSB.getText();
				String hr = txtHR.getText();
				String so = txtSO.getText();
				
				// Check for empty or invalid String
                if (date.length() == 0 || date.equals("Date")) {
                    date = null;
            	}
                if (gp.length() == 0 || gp.equals("Games Played")) {
                    gp = null;
            	}
                if (ab.length() == 0 || ab.equals("AB")) {
                    ab = null;
                }
                if (h.length() == 0 || h.equals("H")) {
                    h = null;
            	}
                if (rbi.length() == 0 || rbi.equals("RBI")) {
                    rbi = null;
            	}
                if (b1.length() == 0 || b1.equals("1B")) {
                    b1 = null;
                }
                if (b2.length() == 0 || b2.equals("2B")) {
                    b2 = null;
            	}
                if (b3.length() == 0 || b3.equals("3B")) {
                    b3 = null;
            	}
                if (runs.length() == 0 || runs.equals("Runs")) {
                    runs = null;
                }
                if (sb.length() == 0 || sb.equals("SB")) {
                    sb = null;
            	}
                if (hr.length() == 0 || hr.equals("HR")) {
                    hr = null;
            	}
                if (so.length() == 0 || so.equals("SO")) {
                    so = null;
                }
			
                /*
				debug("Your entry:");
				debug("Date: "+date+" Games Played: "+gp+" AB: "+ab+" H: "+h+" RBI: "+rbi+" 1B: "+b1);
				debug(" 2B: "+b2+" 3B: "+b3+" Runs: "+runs+" SB: "+sb+" HR: "+hr+" SO: "+so);
                 */
                
                
                //Add input into user database, then display all game statistics
                LocalPlayerBattingStatistics.addLocalPlayerBattingStatistics(date, gp, ab, h, rbi, b1, b2, b3, runs, sb, hr, so);
                
                //reload statistics into table
                loadUserInfoIntoControls();
                
			} catch (RuntimeException ex){
				throw ex;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void populateLocalPlayersBattingTable() {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID", "Date", "Games Played",
				"AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO"}, 0);

		if(User.getCurrentUser() != null){
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			// Get a list of Local Players
			ArrayList<LocalPlayerBattingStatistics> currentPlayerBattingStatistics = LocalPlayerBattingStatistics.getStatisticsFromDatabase(id_in); 
			
			// Add the Local Players to the List
			for (LocalPlayerBattingStatistics m : currentPlayerBattingStatistics) {
				Object[] row = { m.getLocalPlayerId(), m.getGame_date(), m.getHitting_games_play(), m.getHitting_ab(),
						m.getHitting_onbase_h(), m.getHitting_rbi(), m.getHitting_onbase_s(), m.getHitting_onbase_d(),
						m.getHitting_onbase_t(), m.getHitting_runs_total(), m.getHitting_steal_stolen(), 
						m.getHitting_onbase_hr(), m.getHitting_outs_ktotal() };
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
		}		
	}
	
	public void loadUserInfoIntoControls(){
		// Reload the Local Players Batting Statistics Table
		populateLocalPlayersBattingTable();
	}
}