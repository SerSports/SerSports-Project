/*
File: UserFieldingStats.java
Author:	
Date:	

Description: GUI for handling the User Fielding stats input

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
Class: UserFieldingStats

Description: GUI for the User Fielding Stats
*/
public class UserFieldingStats extends JPanel {
	protected JTextField txtDate;
	protected JTextField txtGP;
	protected JTextField txtINN;
	protected JTextField txtA;
	protected JTextField txtE;
	protected JTextField txtFpct;
	protected JTextField txtSB;
	protected JTextField txtCS;

	protected JTable table;
	protected JTextField txtPo;
	protected JTextField txtWins;
	protected JTextField txtLoss;
	protected JButton btnSignOut;
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;

	protected JButton SubmitFieldingStats;
	protected JPanel scrollContainer = new JPanel();
	protected JScrollPane inputStatsScroll = new JScrollPane(this.scrollContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
	/**
	 * Create the panel.
	 */
	public UserFieldingStats() {
		this.scrollContainer.setBounds(0, 0, 864, 600);
		this.scrollContainer.setPreferredSize(new Dimension(864, 600));
		
		setLayout(null);
		add(inputStatsScroll);
		inputStatsScroll.setBounds(0, 0, 864, 600);
		inputStatsScroll.setViewportView(scrollContainer);
		
		scrollContainer.setLayout(null);
		scrollContainer.setBackground(new Color(47, 52, 64));
		
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(31, 25, 119, 16);
		scrollContainer.add(lblYouAre);
		
		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setBounds(56, 96, 105, 22);
		scrollContainer.add(txtDate);
		txtDate.setColumns(10);
		
		txtGP = new JTextField();
		txtGP.setText("GP");
		txtGP.setColumns(10);
		txtGP.setBounds(56, 140, 105, 22);
		scrollContainer.add(txtGP);
		
		txtWins = new JTextField();
		txtWins.setText("Wins");
		txtWins.setColumns(10);
		txtWins.setBounds(56, 184, 105, 22);
		scrollContainer.add(txtWins);

		
		txtLoss = new JTextField();
		txtLoss.setText("Losses");
		txtLoss.setColumns(10);
		txtLoss.setBounds(215, 96, 105, 22);
		scrollContainer.add(txtLoss);
		
		txtPo = new JTextField();
		txtPo.setText("PO");
		txtPo.setColumns(10);
		txtPo.setBounds(215, 140, 105, 22);
		scrollContainer.add(txtPo);
		
		txtE = new JTextField();
		txtE.setText("Err");
		txtE.setColumns(10);
		txtE.setBounds(215, 184, 105, 22);
		scrollContainer.add(txtE);
		
		txtA = new JTextField();
		txtA.setText("Assist");
		txtA.setColumns(10);
		txtA.setBounds(352, 96, 105, 22);
		scrollContainer.add(txtA);
		
		txtFpct = new JTextField();
		txtFpct.setText("F%");
		txtFpct.setColumns(10);
		txtFpct.setBounds(352, 140, 105, 22);
		scrollContainer.add(txtFpct);
		
		
		SubmitFieldingStats = new JButton("Submit");
		SubmitFieldingStats.setBounds(524, 117, 117, 29);
		scrollContainer.add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 243, 691, 235);
		scrollContainer.add(scrollPane);
		
		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(227, 504, 143, 28);
		scrollContainer.add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(423, 504, 143, 28);
		scrollContainer.add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(table);
		
	}
}