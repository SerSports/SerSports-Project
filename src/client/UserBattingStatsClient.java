/*
File: UserBattingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Batting Stats GUI (UserBattingStats.java)

*/
package client;

import gui.MlbStatsGui;
import database.LocalPlayer;
import gui.UserBattingStats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import database.*;

/**
Class: UserBattingStatsClient

Description:
*/
public class UserBattingStatsClient extends UserBattingStats implements ActionListener, ItemListener {

	//private User currentUser = null;
	
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
                
                /*
                 * Add input into user database, then display all game statistics
                 */ 
                //get username/id
                User currentUser = User.getCurrentUser();
                //add batting statistics to database
                String currentLocalPlayerId = Integer.toString(currentUser.getLocalPlayerId());
                String [] battingStatistics = {currentLocalPlayerId, date, gp, ab, h, rbi,
                		b1, b2, b3, runs, sb, hr, so}; 
                
                
                //add batting statistics to user's db
                //LocalPlayerStatistics.setLocalUserBattingStatistics(battingStatistics);
                
                //display for user
                                
                
			} catch (RuntimeException ex){
				throw ex;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}