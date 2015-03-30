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
				String date = txtDate.getText().toString();
				String gp = txtGP.getText().toString();
				String w = txtW.getText().toString();
				String l = txtL.getText().toString();
				String era = txtERA.getText().toString();
				String saves = txtSaves.getText().toString();
				String hits = txtHits.getText().toString();
				String holds = txtHolds.getText().toString();
				String runs = txtRuns.getText().toString();
				String hbp = txtHBP.getText().toString();
				
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
				
			} catch (RuntimeException ex){
				throw ex;	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}