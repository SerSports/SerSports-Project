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
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;

	protected JButton SubmitFieldingStats;
	
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
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(-184, 16, 968, 483);
		add(lblBorderlayout);
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(1300, 600));
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(31, 25, 119, 16);
		add(lblYouAre);
		
		txtDate = new JTextField();
		txtDate.setText("YYYY-MM-DD");
		txtDate.setBounds(56, 96, 105, 22);
		add(txtDate);
		txtDate.setColumns(10);
		
		txtGP = new JTextField();
		txtGP.setText("GP");
		txtGP.setColumns(10);
		txtGP.setBounds(56, 140, 105, 22);
		add(txtGP);
		
		txtWins = new JTextField();
		txtWins.setText("Wins");
		txtWins.setColumns(10);
		txtWins.setBounds(56, 184, 105, 22);
		add(txtWins);

		
		txtLoss = new JTextField();
		txtLoss.setText("Losses");
		txtLoss.setColumns(10);
		txtLoss.setBounds(215, 96, 105, 22);
		add(txtLoss);
		
		txtPo = new JTextField();
		txtPo.setText("PO");
		txtPo.setColumns(10);
		txtPo.setBounds(215, 140, 105, 22);
		add(txtPo);
		
		txtE = new JTextField();
		txtE.setText("Err");
		txtE.setColumns(10);
		txtE.setBounds(215, 184, 105, 22);
		add(txtE);
		
		txtA = new JTextField();
		txtA.setText("Assist");
		txtA.setColumns(10);
		txtA.setBounds(352, 96, 105, 22);
		add(txtA);
		
		txtFpct = new JTextField();
		txtFpct.setText("F%");
		txtFpct.setColumns(10);
		txtFpct.setBounds(352, 140, 105, 22);
		add(txtFpct);
		
		
		SubmitFieldingStats = new JButton("Submit");
		SubmitFieldingStats.setBounds(524, 117, 117, 29);
		add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 243, 691, 235);
		add(scrollPane);
		
		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(227, 504, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(423, 504, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(table);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
		JLabel diamond = new JLabel("");
		diamond.setBounds(167, -48, 64, 64);
		diamond.setIcon(new ImageIcon(img2));
		add(diamond);

		
	}
	public void checkTextFields(){
		//Fielding
		txtDate.getText();
		txtGP.getText();
		txtWins.getText();
		txtLoss.getText();
		txtPo.getText();
		txtE.getText();
		txtA.getText();
		txtFpct.getText();
	}
}