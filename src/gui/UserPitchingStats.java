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
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the panel.
	*/
	public UserPitchingStats() {
		setPreferredSize(new Dimension(1300, 600));
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(-184, 16, 968, 483);
		add(lblBorderlayout);
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(29, 25, 119, 16);
		add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setText("Games Played");
		txtGP.setBounds(56, 140, 105, 22);
		add(txtGP);
		txtGP.setColumns(10);
		
		txtW = new JTextField();
		txtW.setText("Wins");
		txtW.setColumns(10);
		txtW.setBounds(56, 184, 105, 22);
		add(txtW);
		
		txtL = new JTextField();
		txtL.setText("Loss");
		txtL.setColumns(10);
		txtL.setBounds(215, 96, 105, 22);
		add(txtL);
		
		txtERA = new JTextField();
		txtERA.setText("ERA");
		txtERA.setColumns(10);
		txtERA.setBounds(215, 140, 105, 22);
		add(txtERA);
		
		txtSaves = new JTextField();
		txtSaves.setText("Saves");
		txtSaves.setColumns(10);
		txtSaves.setBounds(215, 184, 105, 22);
		add(txtSaves);
		
		txtHits = new JTextField();
		txtHits.setText("Hits");
		txtHits.setColumns(10);
		txtHits.setBounds(378, 93, 77, 28);
		add(txtHits);
		
		txtHolds = new JTextField();
		txtHolds.setText("Holds");
		txtHolds.setColumns(10);
		txtHolds.setBounds(378, 137, 77, 28);
		add(txtHolds);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(378, 181, 77, 28);
		add(txtRuns);
		
		txtHBP = new JTextField();
		txtHBP.setText("HBP");
		txtHBP.setColumns(10);
		txtHBP.setBounds(494, 93, 77, 28);
		add(txtHBP);
		
		//JButton
		SubmitPitchingStats = new JButton("Submit");
		SubmitPitchingStats.setBounds(504, 138, 117, 29);
		add(SubmitPitchingStats);
		SubmitPitchingStats.setActionCommand("SubmitPitchingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 225, 691, 239);
		add(scrollPane);		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setText("MM/DD/YYYY");
		txtDate.setColumns(10);
		txtDate.setBounds(56, 96, 105, 22);
		add(txtDate);
		
		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(205, 504, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(405, 504, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
		JLabel diamond = new JLabel("");
		diamond.setBounds(167, -48, 64, 64);
		diamond.setIcon(new ImageIcon(img2));
		add(diamond);
		
	}
	
	public void checkTextFields(){
		//Pitching
		txtDate.getText();
		txtGP.getText();
		txtW.getText();
		txtL.getText();
		txtERA.getText();
		txtSaves.getText();
		txtHits.getText();
		txtHolds.getText();
		txtRuns.getText();
		txtHBP.getText();
	}
}