/*
File: UserPitchingStats.java
Author:	
Date:	

Description: GUI for User input of Pitching Stats

*/
package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
Class: UserPitchingStats

Description: Creates a panel for the User Batting Stats
*/
public class UserPitchingStats extends JPanel {
	protected JTable table;
	protected JTextField txtDate;
	protected JTextField txtGP;
	protected JTextField txtW;
	protected JTextField txtL;
	protected JTextField txtERA;
	protected JTextField txtSaves;
	protected JTextField txtHits;
	protected JTextField txtHolds;
	protected JTextField txtRuns;
	protected JTextField txtHBP;

	protected JButton SubmitPitchingStats;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the panel.
	*/
	public UserPitchingStats() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(20, 124, 119, 16);
		add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setText("Games Played");
		txtGP.setBounds(302, 121, 109, 22);
		add(txtGP);
		txtGP.setColumns(10);
		
		txtW = new JTextField();
		txtW.setText("Wins");
		txtW.setColumns(10);
		txtW.setBounds(423, 121, 51, 22);
		add(txtW);
		
		txtL = new JTextField();
		txtL.setText("Loss");
		txtL.setColumns(10);
		txtL.setBounds(486, 121, 51, 22);
		add(txtL);
		
		txtERA = new JTextField();
		txtERA.setText("ERA");
		txtERA.setColumns(10);
		txtERA.setBounds(549, 118, 77, 28);
		add(txtERA);
		
		txtSaves = new JTextField();
		txtSaves.setText("Saves");
		txtSaves.setColumns(10);
		txtSaves.setBounds(638, 118, 77, 28);
		add(txtSaves);
		
		txtHits = new JTextField();
		txtHits.setText("Hits");
		txtHits.setColumns(10);
		txtHits.setBounds(735, 118, 77, 28);
		add(txtHits);
		
		txtHolds = new JTextField();
		txtHolds.setText("Holds");
		txtHolds.setColumns(10);
		txtHolds.setBounds(824, 118, 77, 28);
		add(txtHolds);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(930, 118, 77, 28);
		add(txtRuns);
		
		txtHBP = new JTextField();
		txtHBP.setText("HBP");
		txtHBP.setColumns(10);
		txtHBP.setBounds(1040, 118, 77, 28);
		add(txtHBP);
		
		//JButton
		SubmitPitchingStats = new JButton("Submit");
		SubmitPitchingStats.setBounds(580, 181, 117, 29);
		add(SubmitPitchingStats);
		SubmitPitchingStats.setActionCommand("SubmitPitchingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 239);
		add(scrollPane);		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setColumns(10);
		txtDate.setBounds(166, 121, 109, 22);
		add(txtDate);
	}
}