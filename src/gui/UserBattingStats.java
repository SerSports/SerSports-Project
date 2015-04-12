/*
File: UserBattingStats.java
Author:	
Date:	

Description: GUI for handling the User Batting Stats input

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
import javax.swing.JFormattedTextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.User;
import client.UserBattingStatsClient;

/**
Class: UserBattingStats

Description: GUI for User Batting stats
*/
public class UserBattingStats extends JPanel {	
	
	protected JTable table;
	protected JTextField txtGP;
	protected JTextField txtAB;
	protected JTextField txtH;
	protected JTextField txtRBI;
	protected JTextField txtb_1;
	protected JTextField txtb_2;
	protected JTextField txtb_3;
	protected JTextField txtRuns;
	protected JTextField txtSB;
	protected JTextField txtHR;
	protected JTextField txtSO;
	protected JTextField txtDate;
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;	
	protected JButton submitBattingStats;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns: 

	  Description: Creates the panel
	*/
	public UserBattingStats() {	
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(-164, 21, 929, 483);
		add(lblBorderlayout);
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
		JLabel lblYouAre = new JLabel("Enter a new game");
		lblYouAre.setBounds(20, 36, 119, 16);
		lblYouAre.setForeground(new Color(244, 229, 192));
		add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setBounds(56, 140, 105, 22);
		txtGP.setText("Games Played");
		add(txtGP);
		txtGP.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setBounds(56, 184, 105, 22);
		txtAB.setText("AB");
		txtAB.setColumns(10);
		add(txtAB);
		
		txtH = new JTextField();
		txtH.setBounds(215, 96, 105, 22);
		txtH.setText("H");
		txtH.setColumns(10);
		add(txtH);
		
		txtRBI = new JTextField();
		txtRBI.setBounds(215, 140, 105, 22);
		txtRBI.setText("RBI");
		txtRBI.setColumns(10);
		add(txtRBI);
		
		txtb_1 = new JTextField();
		txtb_1.setBounds(215, 184, 105, 22);
		txtb_1.setText("1B");
		txtb_1.setColumns(10);
		add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setBounds(352, 96, 105, 22);
		txtb_2.setText("2B");
		txtb_2.setColumns(10);
		add(txtb_2);
		
		txtb_3 = new JTextField();
		txtb_3.setBounds(352, 140, 105, 22);
		txtb_3.setText("3B");
		txtb_3.setColumns(10);
		add(txtb_3);
		
		txtRuns = new JTextField();
		txtRuns.setBounds(352, 184, 105, 22);
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		add(txtRuns);
		
		txtSB = new JTextField();
		txtSB.setBounds(488, 184, 105, 22);
		txtSB.setText("SB");
		txtSB.setColumns(10);
		add(txtSB);
		
		txtHR = new JTextField();
		txtHR.setBounds(488, 96, 105, 22);
		txtHR.setText("HR");
		txtHR.setColumns(10);
		add(txtHR);
		
		txtSO = new JTextField();
		txtSO.setBounds(488, 140, 105, 22);
		txtSO.setText("SO");
		txtSO.setColumns(10);
		add(txtSO);
		
		//JButton 
		submitBattingStats = new JButton("Submit");
		submitBattingStats.setBounds(632, 138, 117, 29);
		add(submitBattingStats);
		submitBattingStats.setActionCommand("SubmitBattingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 243, 734, 235);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setBounds(56, 96, 105, 22);
		txtDate.setText("MM/DD/YYYY");
		txtDate.setColumns(10);
		add(txtDate);

		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(177, 504, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(343, 504, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");
		
		JLabel lblDatemmddyyyy = new JLabel("Date (MM/DD/YYYY)");
		lblDatemmddyyyy.setBounds(45, 79, 143, 16);
		lblDatemmddyyyy.setForeground(new Color(244, 229, 192));
		add(lblDatemmddyyyy);
		
		JLabel lblAb = new JLabel("AB");
		lblAb.setBounds(100, 168, 22, 16);
		lblAb.setForeground(new Color(244, 229, 192));
		add(lblAb);
		
		JLabel lblGamesPlayed = new JLabel("Games Played");
		lblGamesPlayed.setBounds(66, 124, 86, 16);
		lblGamesPlayed.setForeground(new Color(244, 229, 192));
		add(lblGamesPlayed);
		
		JLabel lblHits = new JLabel("Hits");
		lblHits.setBounds(254, 79, 40, 16);
		lblHits.setForeground(new Color(244, 229, 192));
		add(lblHits);
		
		JLabel lblRbi = new JLabel("RBI");
		lblRbi.setBounds(254, 124, 40, 16);
		lblRbi.setForeground(new Color(244, 229, 192));
		add(lblRbi);
		
		JLabel lblb = new JLabel("1B");
		lblb.setBounds(254, 168, 40, 16);
		lblb.setForeground(new Color(244, 229, 192));
		add(lblb);
		
		JLabel lblb_1 = new JLabel("2B");
		lblb_1.setBounds(384, 79, 40, 16);
		lblb_1.setForeground(new Color(244, 229, 192));
		add(lblb_1);
		
		JLabel lblb_2 = new JLabel("3B");
		lblb_2.setBounds(395, 124, 40, 16);
		lblb_2.setForeground(new Color(244, 229, 192));
		add(lblb_2);
		
		JLabel lblRuns = new JLabel("Runs");
		lblRuns.setBounds(395, 168, 40, 16);
		lblRuns.setForeground(new Color(244, 229, 192));
		add(lblRuns);
		
		JLabel lblHomeRuns = new JLabel("Home Runs");
		lblHomeRuns.setBounds(509, 79, 72, 16);
		lblHomeRuns.setForeground(new Color(244, 229, 192));
		add(lblHomeRuns);
		
		JLabel lblSo = new JLabel("SO");
		lblSo.setBounds(526, 124, 40, 16);
		lblSo.setForeground(new Color(244, 229, 192));
		add(lblSo);
		
		JLabel lblSb = new JLabel("SB");
		lblSb.setBounds(526, 168, 40, 16);
		lblSb.setForeground(new Color(244, 229, 192));
		add(lblSb);

		
	}
}