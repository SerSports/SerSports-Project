package client;

import gui.MlbStatsGui;
import database.MlbPlayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
/*import javax.swing.*;
import java.io.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.rmi.*;*/


public class MlbStatsGuiClient extends MlbStatsGui implements ActionListener, ItemListener {
	

	private static final long serialVersionUID = 1L;
	
	private static final boolean debugOn = true;
	//private gui.MlbStatsGui stats;

	public MlbStatsGuiClient() {
		btnCompareToPlayer.addActionListener(this);
		btnSeePlayerStats.addActionListener(this);
		SubmitPlayerSearchButton.addActionListener(this);
	}
	
	private void debug(String message) {
		if (debugOn)
			System.out.println("debug: " + message);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		try {			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SubmitPlayerSearchButton")) {
			try {
				debug("you clicked Submit Search");
				String fName = txtFirstName.getText().toString();
				String lName = txtLastName.getText().toString();
				String team = txtTeam.getText().toString();
				
<<<<<<< HEAD
				DefaultTableModel newTable = new DefaultTableModel(new Object[]{"ID" ,"First Name", "Last Name", "Team"/* "Position" */}, 0);
=======
				// Check for empty or invalid String
				if (fName.length() == 0 || fName.equals("First Name"))
					fName = null;
				if (lName.length() == 0 || lName.equals("Last Name"))
					lName = null;
				if (team.length() == 0 || team.equals("Team"))
					team = null;
				
				DefaultTableModel newTable = new DefaultTableModel(new Object[]{"First Name", "Last Name", "Team"/* "Position" */}, 0);
>>>>>>> 896a657ce6a738d467f8921d247483edeee7c2fb
				
				ArrayList<MlbPlayer> players = MlbPlayer.getPlayersFromDatabase(fName, lName, team);
				
				for(MlbPlayer m: players) {
					Object[] row = {m.getId() ,m.getFirstName(), m.getLastName(), m.getTeam()};
					newTable.addRow(row);
				}
				
				table.setModel(newTable);
				
				table.removeColumn(table.getColumnModel().getColumn(0));
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getActionCommand().equals("SeePlayerStats")) {
			try {
                // when user highlighted in the table
                // access Player stats
                //make new Jpanel pop up (MLBPlayerProfile.java)
				debug("you clicked See Player Stats");
				String fName = txtFirstName.getText().toString();
				String lName = txtLastName.getText().toString();
				String team = txtTeam.getText().toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (e.getActionCommand().equals("CompareToPlayer")) {
			try {
				debug("you clicked Compare to Player");
				String fName = txtFirstName.getText().toString();
				String lName = txtLastName.getText().toString();
				String team = txtTeam.getText().toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}		
	}
}
