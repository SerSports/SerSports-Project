/*
File: BrowseLocalPlayers.java
Author:	
Date:	

Description: GUI for displaying/searching the Local Players database

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
Class: BrowseLocalPlayers

Description: GUI for displaying/searching Local Players database
*/
public class BrowseLocalPlayers extends JPanel {
	
	// Protected Members
	protected JTextField txtFirstName;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	protected JButton SubmitLocalSearch;
	protected JButton btnSeePlayerStats;
	protected JTable table;
	
	// Private Members
	private JTable battingTable;
	private JLabel mlbBatting;
	private JLabel mlbPitching;
	private JTable fieldingTable;
	private JTable pitchingTable;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public BrowseLocalPlayers() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(20, 20, 100, 100);
		add(logo);
		
		SubmitLocalSearch = new JButton("Submit");
		SubmitLocalSearch.setBounds(38, 255, 117, 29);
		add(SubmitLocalSearch);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(30, 134, 176, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 294, 480, 181);
		add(scrollPane);
		
		btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(205, 498, 200, 50);
		add(btnSeePlayerStats);
	
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(30, 174, 176, 29);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(30, 214, 176, 29);
		add(txtTeam);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(621, 173, 480, 85);
		add(scrollPane_1);
		
		battingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO"}));
		scrollPane_1.setViewportView(battingTable);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(621, 453, 480, 85);
		add(scrollPane_2);

		fieldingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane_2.setViewportView(fieldingTable);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(621, 317, 480, 85);
		add(scrollPane_3);
		
		pitchingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane_3.setViewportView(pitchingTable);
		
		JLabel lblBatting = new JLabel("Batting");
		lblBatting.setBounds(621, 140, 61, 16);
		add(lblBatting);
		
		JLabel lblPitching = new JLabel("Pitching");
		lblPitching.setBounds(621, 295, 61, 16);
		add(lblPitching);
		
		JLabel lblFielding = new JLabel("Fielding");
		lblFielding.setBounds(621, 431, 61, 16);
		add(lblFielding);
	}
}