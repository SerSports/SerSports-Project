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
	protected ModifiedJTextField txtDate = new ModifiedJTextField();
	protected ModifiedJTextField txtGP = new ModifiedJTextField();
	protected ModifiedJTextField txtINN = new ModifiedJTextField();
	protected ModifiedJTextField txtA = new ModifiedJTextField();
	protected ModifiedJTextField txtE = new ModifiedJTextField();
	protected ModifiedJTextField txtFpct = new ModifiedJTextField();
	protected ModifiedJTextField txtSB = new ModifiedJTextField();
	protected ModifiedJTextField txtCS = new ModifiedJTextField();
	protected ModifiedJTextField txtPo = new ModifiedJTextField();
	protected ModifiedJTextField txtWins = new ModifiedJTextField();
	protected ModifiedJTextField txtLoss = new ModifiedJTextField();
	protected JTable table;
	
	protected JButton btnUpdateStatistic = new JButton("Update Statistic");
	protected JButton btnDeleteStatistic = new JButton("Delete Statistic");
	protected JButton SubmitFieldingStats= new JButton("Submit");

	
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
		
		txtDate.setText("YYYY-MM-DD");
		txtDate.setBounds(56, 96, 158, 31);
		add(txtDate);
		txtDate.setColumns(10);
		
		txtGP.setText("GP");
		txtGP.setColumns(10);
		txtGP.setBounds(56, 140, 158, 31);
		add(txtGP);
		
		txtWins.setText("Wins");
		txtWins.setColumns(10);
		txtWins.setBounds(56, 184, 158, 31);
		add(txtWins);

		txtLoss.setText("Losses");
		txtLoss.setColumns(10);
		txtLoss.setBounds(215, 96, 158, 31);
		add(txtLoss);
		
		txtPo.setText("PO");
		txtPo.setColumns(10);
		txtPo.setBounds(215, 140, 158, 31);
		add(txtPo);
		
		txtE.setText("Err");
		txtE.setColumns(10);
		txtE.setBounds(215, 184, 158, 31);
		add(txtE);
		
		txtA.setText("Assist");
		txtA.setColumns(10);
		txtA.setBounds(352, 96, 158, 31);
		add(txtA);
		
		txtFpct.setText("F%");
		txtFpct.setColumns(10);
		txtFpct.setBounds(352, 140, 158, 31);
		add(txtFpct);
		
		SubmitFieldingStats.setBounds(524, 117, 117, 29);
		add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 243, 691, 235);
		add(scrollPane);
		
		btnUpdateStatistic.setBounds(227, 504, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic.setBounds(423, 504, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(table);
		
		//Main menu Indicator
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