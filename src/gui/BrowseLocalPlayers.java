/*
File: BrowseLocalPlayers.java
Author:	
Date:	

Description: GUI for displaying/searching the Local Players database

*/

package gui;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


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
	protected JTable fieldingTable;
	protected JTable pitchingTable;
	protected JTable battingTable;
	protected JButton btnSignOut;
	
	// Private Members
	private JLabel mlbBatting;
	private JLabel mlbPitching;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public BrowseLocalPlayers() {
		setPreferredSize(new Dimension(1000, 600));
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(183, 484, 636, 79);
		add(scrollPane_2);
		
				fieldingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}));
				scrollPane_2.setViewportView(fieldingTable);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(183, 419, 636, 71);
		add(scrollPane_3);
		
		pitchingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane_3.setViewportView(pitchingTable);
		
		SubmitLocalSearch = new JButton("Submit");
		SubmitLocalSearch.setBounds(54, 260, 117, 29);
		add(SubmitLocalSearch);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(88, 132, 176, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(316, 74, 636, 176);
		add(scrollPane);
		
		btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(171, 260, 126, 29);
		add(btnSeePlayerStats);
	
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(88, 173, 176, 29);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(88, 214, 176, 29);
		add(txtTeam);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(183, 349, 636, 79);
		add(scrollPane_1);
		
		battingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO","BA"}));
		scrollPane_1.setViewportView(battingTable);
		
		JLabel lblBatting = new JLabel("Batting");
		lblBatting.setBounds(122, 378, 61, 16);
		add(lblBatting);
		
		JLabel lblPitching = new JLabel("Pitching");
		lblPitching.setBounds(122, 440, 61, 16);
		add(lblPitching);
		
		JLabel lblFielding = new JLabel("Fielding");
		lblFielding.setBounds(122, 512, 61, 16);
		add(lblFielding);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(852, 20, 117, 29);
		add(btnSignOut);
		
		JLabel lblIndividualStatistics = new JLabel("Individual Statistics");
		lblIndividualStatistics.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblIndividualStatistics.setBounds(20, 301, 234, 36);
		add(lblIndividualStatistics);
		
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI.setApplicationToClose(); 
    		}
    	});
	}
}