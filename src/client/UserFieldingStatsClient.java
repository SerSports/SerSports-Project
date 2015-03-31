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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.LocalPlayerFieldingStatistics;

/**
Class: UserFieldingStatsClient

Description:
*/
public class UserFieldingStatsClient extends UserFieldingStats implements ActionListener, ItemListener  {

	private static final boolean debugOn = true;
    
    /**
    Method: UserFieldingStatsClient
    Inputs: none
    Returns:

    Description:
    */
    public UserFieldingStatsClient() {
        SubmitFieldingStats.addActionListener(this);
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
		if(e.getActionCommand().equals("SubmitFieldingStats")){
            try{
                debug("You clicked Submit in the User Stats Fielding tab");
                
                String date = txtDate.getText();
				String gp = txtGP.getText();
				String wins = txtWins.getText();
				String loss = txtLoss.getText();
				String po = txtPo.getText();
				String error = txtE.getText();
				String assist = txtA.getText();
				String fpct = txtFpct.getText();
				
				// Check for empty or invalid String
                if (date.length() == 0 || date.equals("Date")) {
                    date = null;
            	}
                if (gp.length() == 0 || gp.equals("Games Played")) {
                    gp = null;
            	}
                if (wins.length() == 0 || wins.equals("Wins")) {
                    wins = null;
                }
                if (loss.length() == 0 || loss.equals("Loss")) {
                    loss = null;
                }
                if (po.length() == 0 || po.equals("PO")) {
                    po = null;
                }
                if (error.length() == 0 || error.equals("Err")) {
                    error = null;
                }
                if (assist.length() == 0 || assist.equals("Assist")) {
                    assist = null;
                }
                if (fpct.length() == 0 || fpct.equals("F%")) {
                    fpct = null;
                }
                
                /*
				debug("Your entry:");
				debug("Date: "+date+" Games Played: "+gp+" Wins: "+wins+" Loss: "+loss+" PO: "+po+" Error: "+error);
				debug(" Assist: "+assist+" FPCT: "+fpct);
                 */
                
                //Add input into user database, then display all game statistics
                LocalPlayerFieldingStatistics.addLocalPlayerFieldingStatistics(date, gp, wins, loss, po, error, assist, fpct);
				
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
	}
}