/*
File: MlbStatsGui.java
Author:	
Date:	

Description: GUI for displaying/searching the MLB Stats database

*/
package gui;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


/**
Class: MlbStatsGui

Description: GUI for Mlb Stats database
*/
public class MlbStatsGui extends JPanel {
	protected JTextField txtFirstName;
	protected JTable table;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	//protected JButton btnSeePlayerStats;
	//protected JButton btnCompareToPlayer;
	protected JButton SubmitPlayerSearchButton;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public MlbStatsGui() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		getDBconnection();
		getResultsSet();
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		SubmitPlayerSearchButton = new JButton("Submit");
		SubmitPlayerSearchButton.setBounds(581, 234, 117, 29);
		add(SubmitPlayerSearchButton);
		SubmitPlayerSearchButton.setActionCommand("SubmitPlayerSearchButton");
		SubmitPlayerSearchButton.setBackground(new Color(255,237,203));
	    //getContentPane().add(SubmitPlayerSearchButton);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(549, 118, 180, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 288, 478, 246);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team"/* "Position" */}));
		scrollPane.setViewportView(table);
		
		/*btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(421, 594, 200, 50);
		btnSeePlayerStats.setActionCommand("SeePlayerStats");
		add(btnSeePlayerStats);
		
		(btnCompareToPlayer = new JButton("Compare to Player");
		btnCompareToPlayer.setBounds(656, 594, 200, 50);
		btnCompareToPlayer.setActionCommand("CompareToPlayer");
		add(btnCompareToPlayer);*/
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(549, 153, 180, 28);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(549, 193, 180, 28);
		add(txtTeam);
	}

	private void getResultsSet() {
		// TODO Auto-generated method stub
		
	}

	private void getDBconnection() {
		// TODO Auto-generated method stub
		
	}
}

