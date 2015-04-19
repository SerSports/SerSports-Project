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

import javax.swing.JComboBox;
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
	private String dateTxt = "YYYY-MM-DD";
	private String winsTxt = "Wins";
	private String lossesTxt = "Loss";
	private String putOutTxt = "PO";
	private String errorTxt = "Error";
	private String assistTxt = "Assist";
	private String fieldPercentageTxt = "F%";
	
	protected JTable table;
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
	protected ModifiedJButtonStyle1 btnUpdateStatistic = new ModifiedJButtonStyle1("Update Statistic");
	protected ModifiedJButtonStyle1 btnDeleteStatistic = new ModifiedJButtonStyle1("Delete Statistic");
	protected ModifiedJButtonStyle1 SubmitFieldingStats = new ModifiedJButtonStyle1("Submit");
	protected String[] comboBoxInput = {"Win","Loss"};
	protected JComboBox comboBox = new JComboBox(comboBoxInput);
	
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
		
		JLabel lblEnter = new JLabel("Enter New Stats:");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(65, 54, 158, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setText(dateTxt);
		txtDate.setBounds(65, 97, 158, 31);
		add(txtDate);
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, dateTxt));

		txtWins.setText(winsTxt);
		txtWins.setBounds(235, 97, 158, 31);
		add(txtWins);
		txtWins.addFocusListener(new ModifiedFocusAdapter(txtWins, winsTxt));

		txtLoss.setText(lossesTxt);
		txtLoss.setBounds(405, 97, 158, 31);
		add(txtLoss);
		txtLoss.addFocusListener(new ModifiedFocusAdapter(txtLoss, lossesTxt));
		
		txtPo.setText(putOutTxt);
		txtPo.setBounds(575, 97, 158, 31);
		add(txtPo);
		txtPo.addFocusListener(new ModifiedFocusAdapter(txtPo, putOutTxt));
		
		txtE.setText(errorTxt);
		txtE.setBounds(65, 140, 158, 31);
		add(txtE);
		txtE.addFocusListener(new ModifiedFocusAdapter(txtE, errorTxt));
		
		txtA.setText(assistTxt);
		txtA.setBounds(235, 141, 158, 31);
		add(txtA);
		txtA.addFocusListener(new ModifiedFocusAdapter(txtA, assistTxt));
		
		comboBox.setBounds(395, 180, 158, 31);
		add(comboBox);
		
		txtFpct.setText(fieldPercentageTxt);
		txtFpct.setBounds(405, 140, 158, 31);
		add(txtFpct);
		txtFpct.addFocusListener(new ModifiedFocusAdapter(txtFpct, fieldPercentageTxt));
		
		SubmitFieldingStats.setBounds(575, 141, 158, 31);
		add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 248, 691, 145);
		add(scrollPane);
		
		btnUpdateStatistic.setBounds(250, 421, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic.setBounds(405, 421, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

		table = new JTable(new DefaultTableModel(null, new Object[]{"Won","Losses", "PO", "Err", "Assist", "F%"}));
		scrollPane.setViewportView(table);
		
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
	
	public String getDateTxt(){
		return dateTxt;
	}
	
	public String getWinsTxt(){
		return winsTxt;
	}
	
	public String getLossesTxt(){
		return lossesTxt;
	}
	
	public String getPOTxt(){
		return putOutTxt;
	}
	
	public String getErrorTxt(){
		return errorTxt;
	}
	
	public String getAssistTxt(){
		return assistTxt;
	}
	
	public String getFieldPercentageTxt(){
		return fieldPercentageTxt;
	}
}