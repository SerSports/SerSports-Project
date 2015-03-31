/*
File: UserPitchingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Pitching Stats GUI (UserPitchingStats.java)

*/
package client;

import gui.MlbStatsGui;
import gui.UserPitchingStats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import database.LocalPlayerStatistics;
import database.User;

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

                /*
				debug("Your entry:");
				debug("Date: "+date+" Games Played: "+gp+" W: "+w+" L: "+l+" ERA: "+era+" Saves: "+saves);
				debug(" Hits: "+hits+" Holds: "+holds+" Runs: "+runs+" HBP: "+hbp);
                 */
                
                //Add input into user database, then display all game statistics
                LocalPlayerStatistics.setLocalPlayerPitchingStatistics(date, gp, w, l, era, saves, hits, holds, runs, hbp);
                
                
			} catch (RuntimeException ex){
				throw ex;	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}