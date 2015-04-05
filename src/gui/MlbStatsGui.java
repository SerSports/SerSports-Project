/*
File: MlbStatsGui.java
Author:	
Date:	

Description: GUI for displaying/searching the MLB Stats database

*/
package gui;


import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private static final long serialVersionUID = 1L;
	protected JTextField txtFirstName;
	protected JTable table;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	protected JButton btnSeePlayerStats;
	protected JButton btnCompareToPlayer;
	protected JButton submitPlayerSearchButton;
	protected JTable mlbbattingTable;
	protected JLabel mlbBatting;
	protected JLabel mlbPitching;
	protected JLabel mlbFielding;
	protected JTable mlbfieldingTable;
	protected JTable mlbpitchingTable;
	protected JButton btnSignOut;
	protected JLabel lblMlbPlayerName;
	protected JLabel lblMlbPlayerLast;
	protected JLabel lblMlbPlayerTeam;


	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public MlbStatsGui() {
		setPreferredSize(new Dimension(1000, 600));
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(104, 463, 653, 67);
		add(scrollPane_3);
		
		mlbpitchingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","BB"}));
		scrollPane_3.setViewportView(mlbpitchingTable);
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(20, 20, 100, 100);
		add(logo);
		
		submitPlayerSearchButton = new JButton("Submit");
		submitPlayerSearchButton.setBounds(82, 253, 117, 29);
		add(submitPlayerSearchButton);
		submitPlayerSearchButton.setActionCommand("submitPlayerSearchButton");
		submitPlayerSearchButton.setBackground(new Color(255,237,203));
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(59, 132, 180, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 47, 480, 174);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team"/* "Position" */}));
		scrollPane.setViewportView(table);
		
		btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(751, 151, 200, 50);
		btnSeePlayerStats.setActionCommand("SeePlayerStats");
		add(btnSeePlayerStats);
		
		btnCompareToPlayer = new JButton("Compare to Player");
		btnCompareToPlayer.setBounds(751, 75, 200, 50);
		btnCompareToPlayer.setActionCommand("CompareToPlayer");
		add(btnCompareToPlayer);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(59, 173, 180, 28);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(59, 213, 180, 28);
		add(txtTeam);
		
		lblMlbPlayerName = new JLabel("MLB Player First Name");
		lblMlbPlayerName.setBounds(20, 305, 149, 16);
		add(lblMlbPlayerName);
		
		lblMlbPlayerLast = new JLabel("MLB Player Last Name");
		lblMlbPlayerLast.setBounds(181, 305, 149, 16);
		add(lblMlbPlayerLast);
		
		lblMlbPlayerTeam = new JLabel("MLB Player Team");
		lblMlbPlayerTeam.setBounds(342, 305, 149, 16);
		add(lblMlbPlayerTeam);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(104, 345, 653, 61);
		add(scrollPane_1);
		
		mlbbattingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane_1.setViewportView(mlbbattingTable);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(104, 402, 653, 67);
		add(scrollPane_2);

		mlbfieldingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane_2.setViewportView(mlbfieldingTable);
		
		mlbBatting = new JLabel("Batting");
		mlbBatting.setBounds(38, 371, 61, 16);
		add(mlbBatting);
		
		mlbPitching = new JLabel("Pitching");
		mlbPitching.setBounds(38, 488, 61, 16);
		add(mlbPitching);
		
		mlbFielding = new JLabel("Fielding");
		mlbFielding.setBounds(38, 428, 61, 16);
		add(mlbFielding);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(852, 20, 117, 29);
		add(btnSignOut);
		
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI.setApplicationToClose(); 
    		}
    	});
	}
}