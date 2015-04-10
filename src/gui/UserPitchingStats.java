/*
File: UserPitchingStats.java
Author:	
Date:	

Description: GUI for User input of Pitching Stats

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
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;

	protected JButton SubmitPitchingStats;
	protected JPanel scrollContainer = new JPanel();
	protected JScrollPane inputStatsScroll = new JScrollPane(this.scrollContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the panel.
	*/
	public UserPitchingStats() {
		this.scrollContainer.setBounds(0, 0, 864, 600);
		this.scrollContainer.setPreferredSize(new Dimension(864, 600));
		
		setLayout(null);
		add(inputStatsScroll);
		inputStatsScroll.setBounds(0, 0, 864, 600);
		inputStatsScroll.setViewportView(scrollContainer);
		
		scrollContainer.setLayout(null);
		scrollContainer.setBackground(new Color(47, 52, 64));
		
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(20, 124, 119, 16);
		scrollContainer.add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setText("Games Played");
		txtGP.setBounds(302, 121, 109, 22);
		scrollContainer.add(txtGP);
		txtGP.setColumns(10);
		
		txtW = new JTextField();
		txtW.setText("Wins");
		txtW.setColumns(10);
		txtW.setBounds(423, 121, 51, 22);
		scrollContainer.add(txtW);
		
		txtL = new JTextField();
		txtL.setText("Loss");
		txtL.setColumns(10);
		txtL.setBounds(486, 121, 51, 22);
		scrollContainer.add(txtL);
		
		txtERA = new JTextField();
		txtERA.setText("ERA");
		txtERA.setColumns(10);
		txtERA.setBounds(549, 118, 77, 28);
		scrollContainer.add(txtERA);
		
		txtSaves = new JTextField();
		txtSaves.setText("Saves");
		txtSaves.setColumns(10);
		txtSaves.setBounds(638, 118, 77, 28);
		scrollContainer.add(txtSaves);
		
		txtHits = new JTextField();
		txtHits.setText("Hits");
		txtHits.setColumns(10);
		txtHits.setBounds(735, 118, 77, 28);
		scrollContainer.add(txtHits);
		
		txtHolds = new JTextField();
		txtHolds.setText("Holds");
		txtHolds.setColumns(10);
		txtHolds.setBounds(824, 118, 77, 28);
		scrollContainer.add(txtHolds);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(930, 118, 77, 28);
		scrollContainer.add(txtRuns);
		
		txtHBP = new JTextField();
		txtHBP.setText("HBP");
		txtHBP.setColumns(10);
		txtHBP.setBounds(1040, 118, 77, 28);
		scrollContainer.add(txtHBP);
		
		//JButton
		SubmitPitchingStats = new JButton("Submit");
		SubmitPitchingStats.setBounds(580, 181, 117, 29);
		scrollContainer.add(SubmitPitchingStats);
		SubmitPitchingStats.setActionCommand("SubmitPitchingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 239);
		scrollContainer.add(scrollPane);		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setColumns(10);
		txtDate.setBounds(166, 121, 109, 22);
		scrollContainer.add(txtDate);
		
		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(469, 504, 143, 28);
		scrollContainer.add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(674, 504, 143, 28);
		scrollContainer.add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");
		
	}
}