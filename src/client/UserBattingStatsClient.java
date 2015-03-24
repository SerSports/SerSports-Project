/*
File: UserBattingStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the User Batting Stats GUI (UserBattingStats.java)

*/
package client;

import gui.MlbStatsGui;
import gui.UserBattingStats;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import database.MlbPlayer;

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
				
				String date = textDate.getText().toString();
				String gp = txtGP.getText().toString();
				String ab = txtAB.getText().toString();
				String h = txtH.getText().toString();
				String rbi = txtRBI.getText().toString();
				String b1 = txtb_1.getText().toString();
				String b2 = txtb_2.getText().toString();
				String b3 = txtb_3.getText().toString();
				String runs = txtRuns.getText().toString();
				String sb = txtSB.getText().toString();
				String hr = txtHR.getText().toString();
				String so = txtSO.getText().toString();
				
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
                 * Add input into user database, then display all game statistics
                 * 
                DefaultTableModel newTable = new DefaultTableModel(new Object[]{"Date", "GP", "AB", "H", "RBI",
                		"1B", "2B", "3B", "Runs", "SB", "HR", "SO"}, 0);
                		
                //add above info into user's database before display here
                
                ArrayList<UserPlayer> players = UserPlayer.getPlayersFromDatabase(txtDate, txtGP, txtAB, txtH, txtRBI,
                		txtb_1, txtb_2, txtb_3, txtRuns, txtSB, txtHR, txtSO);
                
                for(UserPlayer m: players) {
                    Object[] row = {m.getDate(), m.getGamesPlayed(), m.getAB(), m.getH(), m.getRBI(),
                    		m.get1B(), m.get2B(), m.get3B(), m.getRuns(), m.getSB(), m.getHR(), m.getSO()};
                    newTable.addRow(row); 
                }
                
                table.setModel(newTable);
                */
                
                /*
				debug("Your entry:");
				debug("Date: "+date+" Games Played: "+gp+" AB: "+ab+" H: "+h+" RBI: "+rbi+" 1B: "+b1);
				debug(" 2B: "+b2+" 3B: "+b3+" Runs: "+runs+" SB: "+sb+" HR: "+hr+" SO: "+so);
                 */
                
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}