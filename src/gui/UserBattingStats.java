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
public class UserBattingStats extends JScrollPane {	
	
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
	protected JButton btnSignOut;
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;	
	protected JButton SubmitBattingStats;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns: 

	  Description: Creates the panel
	*/
	public UserBattingStats() {
		//setPreferredSize(new Dimension(1300, 650));
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(27, 25, 119, 16);
		add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setText("Games Played");
		txtGP.setBounds(164, 84, 111, 22);
		add(txtGP);
		txtGP.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setText("AB");
		txtAB.setColumns(10);
		txtAB.setBounds(164, 118, 143, 28);
		add(txtAB);
		
		txtH = new JTextField();
		txtH.setText("H");
		txtH.setColumns(10);
		txtH.setBounds(164, 153, 77, 28);
		add(txtH);
		
		txtRBI = new JTextField();
		txtRBI.setText("RBI");
		txtRBI.setColumns(10);
		txtRBI.setBounds(164, 193, 77, 28);
		add(txtRBI);
		
		txtb_1 = new JTextField();
		txtb_1.setText("1B");
		txtb_1.setColumns(10);
		txtb_1.setBounds(164, 233, 77, 28);
		add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setText("2B");
		txtb_2.setColumns(10);
		txtb_2.setBounds(164, 272, 77, 28);
		add(txtb_2);
		
		txtb_3 = new JTextField();
		txtb_3.setText("3B");
		txtb_3.setColumns(10);
		txtb_3.setBounds(164, 312, 77, 28);
		add(txtb_3);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(164, 363, 77, 28);
		add(txtRuns);
		
		txtSB = new JTextField();
		txtSB.setText("SB");
		txtSB.setColumns(10);
		txtSB.setBounds(164, 403, 51, 28);
		add(txtSB);
		
		txtHR = new JTextField();
		txtHR.setText("HR");
		txtHR.setColumns(10);
		txtHR.setBounds(164, 440, 51, 28);
		add(txtHR);
		
		txtSO = new JTextField();
		txtSO.setText("SO");
		txtSO.setColumns(10);
		txtSO.setBounds(164, 480, 51, 28);
		add(txtSO);
		
		//JButton 
		SubmitBattingStats = new JButton("Submit");
		SubmitBattingStats.setBounds(91, 568, 117, 29);
		add(SubmitBattingStats);
		SubmitBattingStats.setActionCommand("SubmitBattingStats");
		//SubmitBattingStats.addActionListener((ActionListener) this);
		//SubmitBattingStats.setBackground(new Color(255,237,203));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 105, 691, 235);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setText("MM/DD/YYYY");
		txtDate.setColumns(10);
		txtDate.setBounds(164, 54, 143, 28);
		add(txtDate);

		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
		
		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(507, 364, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(674, 364, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");
		
		JLabel lblDatemmddyyyy = new JLabel("Date (MM/DD/YYYY)");
		lblDatemmddyyyy.setBounds(27, 60, 143, 16);
		add(lblDatemmddyyyy);
		
		JLabel lblAb = new JLabel("AB");
		lblAb.setBounds(91, 124, 61, 16);
		add(lblAb);
		
		JLabel lblGamesPlayed = new JLabel("Games Played");
		lblGamesPlayed.setBounds(66, 87, 86, 16);
		add(lblGamesPlayed);
		
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI.setApplicationToClose(); 
    		}
    	});
	}
}