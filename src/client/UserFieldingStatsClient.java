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
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
	}
}