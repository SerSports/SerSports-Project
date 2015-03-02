/*
File: MLBBattingsStatsClient.java
Author:	
Date:	

Description: ActionListeners and ItemListeners for the MLB Batting Stats GUI (MLBBattingStats.java)

*/
package client;

import gui.MLBBattingStats;
import gui.MlbStatsGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
Class:	MLBBattingStatsClient

Description:
*/
public class MLBBattingStatsClient extends MLBBattingStats implements ActionListener, ItemListener {

	public MLBBattingStatsClient(String player) {
		super(player);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}
}