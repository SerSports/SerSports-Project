/*
File: UserFieldingStats.java
Author:	
Date:	

Description: GUI for handling the User Fielding stats input

*/
package gui;

import java.awt.Dimension;
import java.awt.Font;
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
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(800, 650));
		
		JLabel lblEnter = new JLabel("Enter a New Game Stats");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(278, 37, 244, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setText("YYYY-MM-DD");
		txtDate.setBounds(65, 97, 158, 31);
		add(txtDate);;
		
		txtWins.setText("Wins");
		txtWins.setBounds(235, 97, 158, 31);
		add(txtWins);

		txtLoss.setText("Losses");
		txtLoss.setBounds(405, 97, 158, 31);
		add(txtLoss);
		
		txtPo.setText("PO");
		txtPo.setBounds(575, 97, 158, 31);
		add(txtPo);
		
		txtE.setText("Err");
		txtE.setBounds(65, 140, 158, 31);
		add(txtE);
		
		txtA.setText("Assist");
		txtA.setBounds(235, 140, 158, 31);
		add(txtA);
		
		txtFpct.setText("F%");
		txtFpct.setBounds(405, 140, 158, 31);
		add(txtFpct);
		
		SubmitFieldingStats.setBounds(341, 209, 117, 29);
		add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 243, 691, 145);
		add(scrollPane);
		
		btnUpdateStatistic.setBounds(250, 424, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic.setBounds(405, 424, 143, 28);
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
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(-184, 16, 968, 483);
		add(lblBorderlayout);
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
	}
	public void checkTextFields(){
		//Fielding
		txtDate.getText();
		txtWins.getText();
		txtLoss.getText();
		txtPo.getText();
		txtE.getText();
		txtA.getText();
		txtFpct.getText();
	}
}