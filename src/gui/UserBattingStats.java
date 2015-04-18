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

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.SwingConstants;

/**
Class: UserBattingStats

Description: GUI for User Batting stats
*/
public class UserBattingStats extends JPanel {	
	
	private String dateTxt = "YYYY-MM-DD";
	private String abTxt = "At Bats";
	private String hitsTxt = "Hits";
	private String rbiTxt = "RBI";
	private String b1Txt = "Single";
	private String b2Txt = "Double";
	private String b3Txt = "Triple";
	private String runsTxt = "Runs";
	private String sbTxt = "Stolen Bases";
	private String hrTxt = "Home Runs";
	private String soTxt = "Strikeouts";
	
	protected JTable table;
	protected ModifiedJTextField txtAB = new ModifiedJTextField();
	protected ModifiedJTextField txtH = new ModifiedJTextField();
	protected ModifiedJTextField txtRBI = new ModifiedJTextField();
	protected ModifiedJTextField txtb_1 = new ModifiedJTextField();
	protected ModifiedJTextField txtb_2 = new ModifiedJTextField();
	protected ModifiedJTextField txtb_3 = new ModifiedJTextField();
	protected ModifiedJTextField txtRuns = new ModifiedJTextField();
	protected ModifiedJTextField txtSB = new ModifiedJTextField();
	protected ModifiedJTextField txtHR = new ModifiedJTextField();
	protected ModifiedJTextField txtSO = new ModifiedJTextField();
	protected ModifiedJTextField txtDate = new ModifiedJTextField();
	protected ModifiedJButtonStyle1 btnUpdateStatistic = new ModifiedJButtonStyle1("Update Statistic");
	protected ModifiedJButtonStyle1 btnDeleteStatistic = new ModifiedJButtonStyle1("Delete Statistic");	
	protected ModifiedJButtonStyle1 submitBattingStats = new ModifiedJButtonStyle1("Submit");

	/**
	  Method: Constructor
	  Inputs: None
	  Returns: 

	  Description: Creates the panel
	*/
	public UserBattingStats() {	
		setLayout(null);
		setPreferredSize(new Dimension(800, 650));
		setBackground(new Color(47, 52, 64));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		JLabel lblEnter = new JLabel("Enter a New Game Stats");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(278, 37, 244, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setBounds(65, 97, 158, 31);
		txtDate.setText(dateTxt);
		add(txtDate);
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, dateTxt));
		
		txtAB.setBounds(230, 97, 158, 31);
		txtAB.setText(abTxt);
		add(txtAB);
		txtAB.addFocusListener(new ModifiedFocusAdapter(txtAB, abTxt));
		
		txtH.setBounds(394, 97, 158, 31);
		txtH.setText(hitsTxt);
		add(txtH);
		txtH.addFocusListener(new ModifiedFocusAdapter(txtH, hitsTxt));
		
		txtRBI.setBounds(560, 97, 158, 31);
		txtRBI.setText(rbiTxt);
		add(txtRBI);
		txtRBI.addFocusListener(new ModifiedFocusAdapter(txtRBI, rbiTxt));
		
		txtb_1.setBounds(65, 140, 158, 31);
		txtb_1.setText(b1Txt);
		add(txtb_1);
		txtb_1.addFocusListener(new ModifiedFocusAdapter(txtb_1, b1Txt));
		
		txtb_2.setBounds(230, 140, 158, 31);
		txtb_2.setText(b2Txt);
		add(txtb_2);
		txtb_2.addFocusListener(new ModifiedFocusAdapter(txtb_2, b2Txt));
		
		txtb_3.setBounds(394, 140, 158, 31);
		txtb_3.setText(b3Txt);
		add(txtb_3);
		txtb_3.addFocusListener(new ModifiedFocusAdapter(txtb_3, b3Txt));
		
		txtRuns.setBounds(560, 140, 158, 31);
		txtRuns.setText(runsTxt);
		add(txtRuns);
		txtRuns.addFocusListener(new ModifiedFocusAdapter(txtRuns, runsTxt));
		
		txtSB.setBounds(65, 183, 158, 31);
		txtSB.setText(sbTxt);
		add(txtSB);
		txtSB.addFocusListener(new ModifiedFocusAdapter(txtSB, sbTxt));
		
		txtHR.setBounds(230, 183, 158, 31);
		txtHR.setText(hrTxt);
		add(txtHR);
		txtHR.addFocusListener(new ModifiedFocusAdapter(txtHR, hrTxt));
		
		txtSO.setBounds(394, 183, 158, 31);
		txtSO.setText(soTxt);
		add(txtSO);
		txtSO.addFocusListener(new ModifiedFocusAdapter(txtSO, soTxt));
		
		//JButton 
		submitBattingStats.setBounds(340, 230, 117, 29);
		add(submitBattingStats);
		submitBattingStats.setActionCommand("SubmitBattingStats");	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 266, 734, 145);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane.setViewportView(table);
		
		
		btnUpdateStatistic.setBounds(250, 421, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
	
		btnDeleteStatistic.setBounds(405, 421, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(-184, 16, 968, 483);
		add(lblBorderlayout);
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
		JLabel diamond = new JLabel("");
		diamond.setBounds(167, -48, 64, 64);
		diamond.setIcon(new ImageIcon(img2));
		add(diamond);

		
	}
	
	public boolean checkTextFields(){
		boolean result;
		
		//Batting
		if (txtDate.getText() != dateTxt ||
			txtAB.getText() != abTxt ||
			txtH.getText() != hitsTxt ||
			txtRBI.getText() != rbiTxt ||
			txtb_1.getText() != b1Txt ||
			txtb_2.getText() != b2Txt ||
			txtb_3.getText() != b3Txt ||
			txtRuns.getText() != runsTxt ||
			txtSB.getText() != sbTxt ||
			txtHR.getText() != hrTxt ||
			txtSO.getText() != soTxt){
			//System.out.println("batter - dateTxt: "+dateTxt);
			//System.out.println("batter - txtDate: "+txtDate);
			result = false;
	
		}
		else{
			result = true;
		}
		return result;
	}
}