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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.*;
import gui.*;

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

	                //Add input into user database, then display all game statistics
	                LocalPlayerFieldingStatistics.addLocalPlayerFieldingStatistics(date, gp, wins, loss, po, error, assist, fpct);
				
	                //reload statistics into table
	                loadUserInfoIntoControls();
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid date format. Please add date in MM/DD/YYYY", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
				}
                
            } catch (RuntimeException ex){
				throw ex;
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
	}
	
	public void populateLocalPlayersFieldingTable() {
		
		// Set up the table
		DefaultTableModel newTable = new DefaultTableModel(new Object[] { "ID", "Date", "GP", "Wins",
				"Losses", "PO", "Err", "Assist", "F%"}, 0);

		if(User.getCurrentUser() != null){
			User currentLoggedInUser = User.getCurrentUser();
			Integer id_in = currentLoggedInUser.getLocalPlayerId();
			
			// Get a list of Local Players
			ArrayList<LocalPlayerFieldingStatistics> currentPlayerFieldingStatistics = 
					LocalPlayerFieldingStatistics.getStatisticsFromDatabase(id_in); 
			
			// Add the Local Players to the List
			for (LocalPlayerFieldingStatistics m : currentPlayerFieldingStatistics) {
				Object[] row = { m.getLocalPlayerId(), m.getGame_date(), m.getFielding_games_play(),
						m.getFielding_games_win(), m.getFielding_games_loss(), m.getFielding_po(),
						m.getFielding_error(), m.getFielding_fpct()};
				newTable.addRow(row);
			}

			table.setModel(newTable);
			table.removeColumn(table.getColumnModel().getColumn(0));
		}		
	}

	public void loadUserInfoIntoControls(){
		// Reload the Local Players Fielding Statistics Table
		populateLocalPlayersFieldingTable();
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