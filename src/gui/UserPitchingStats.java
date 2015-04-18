/*
File: UserPitchingStats.java
Author:	
Date:	

Description: GUI for User input of Pitching Stats

*/
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
Class: UserPitchingStats

Description: Creates a panel for the User Batting Stats
*/
public class UserPitchingStats extends JPanel {
	private String dateTxt = "YYYY-MM-DD";
	private String winsTxt = "Wins";
	private String lossesTxt = "Loss";
	private String earnedRunAverageTxt = "ERA";
	private String savesTxt = "Saves";
	private String hitsTxt = "Hits";
	private String holdsTxt = "Holds";
	private String runsTxt = "Runs";
	private String hitByPitchTxt = "HBP";
	
	protected JTable table;
	protected ModifiedJTextField txtDate = new ModifiedJTextField();
	protected ModifiedJTextField txtW = new ModifiedJTextField();
	protected ModifiedJTextField txtL = new ModifiedJTextField();
	protected ModifiedJTextField txtERA = new ModifiedJTextField();
	protected ModifiedJTextField txtSaves = new ModifiedJTextField();
	protected ModifiedJTextField txtHits = new ModifiedJTextField();
	protected ModifiedJTextField txtHolds = new ModifiedJTextField();
	protected ModifiedJTextField txtRuns = new ModifiedJTextField();
	protected ModifiedJTextField txtHBP = new ModifiedJTextField();
	protected ModifiedJButtonStyle1 btnUpdateStatistic = new ModifiedJButtonStyle1("Update Statistic");
	protected ModifiedJButtonStyle1 btnDeleteStatistic = new ModifiedJButtonStyle1("DeleteStatistic");
	protected ModifiedJButtonStyle1 SubmitPitchingStats = new ModifiedJButtonStyle1("Submit");
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the panel.
	*/
	public UserPitchingStats() {
		setPreferredSize(new Dimension(800, 650));
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(244, 229, 192));
		lblDate.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblDate.setBounds(19, 104, 34, 16);
		add(lblDate);
		
		JLabel lblEnter = new JLabel("Enter a New Game Stats");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(278, 37, 244, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setText(dateTxt);
		txtDate.setBounds(65, 97, 158, 31);
		add(txtDate);
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, dateTxt));
		
		txtW.setText(winsTxt);
		txtW.setBounds(230, 97, 158, 31);
		add(txtW);
		txtW.addFocusListener(new ModifiedFocusAdapter(txtW, winsTxt));
		
		txtL.setText(lossesTxt);
		txtL.setBounds(395, 97, 158, 31);
		add(txtL);
		txtL.addFocusListener(new ModifiedFocusAdapter(txtL, lossesTxt));
		
		txtERA.setText(earnedRunAverageTxt);
		txtERA.setBounds(560, 97, 158, 31);
		add(txtERA);
		txtERA.addFocusListener(new ModifiedFocusAdapter(txtERA, earnedRunAverageTxt));
		
		txtSaves.setText(savesTxt);
		txtSaves.setBounds(65, 137, 158, 31);
		add(txtSaves);
		txtSaves.addFocusListener(new ModifiedFocusAdapter(txtSaves, savesTxt));
		
		txtHits.setText(hitsTxt);
		txtHits.setBounds(230, 137, 158, 31);
		add(txtHits);
		txtHits.addFocusListener(new ModifiedFocusAdapter(txtHits, hitsTxt));
		
		txtHolds.setText(holdsTxt);
		txtHolds.setBounds(395, 137, 158, 31);
		add(txtHolds);
		txtHolds.addFocusListener(new ModifiedFocusAdapter(txtHolds, holdsTxt));
		
		txtRuns.setText(runsTxt);
		txtRuns.setBounds(560, 137, 158, 31);
		add(txtRuns);
		txtRuns.addFocusListener(new ModifiedFocusAdapter(txtRuns, runsTxt));
		
		txtHBP.setText(hitByPitchTxt);
		txtHBP.setBounds(65, 176, 158, 31);
		add(txtHBP);
		txtHBP.addFocusListener(new ModifiedFocusAdapter(txtHBP, hitByPitchTxt));
		
		//JButton
		SubmitPitchingStats.setBounds(230, 177, 158, 31);
		add(SubmitPitchingStats);
		SubmitPitchingStats.setActionCommand("SubmitPitchingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 260, 691, 145);
		add(scrollPane);		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane.setViewportView(table);
		
		btnUpdateStatistic.setBounds(250, 421, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic.setBounds(405, 421, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");

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
	
	public String getERATxt(){
		return earnedRunAverageTxt;
	}
	
	public String getSavesTxt(){
		return savesTxt;
	}
	
	public String getHitsTxt(){
		return hitsTxt;
	}
	
	public String getHoldsTxt(){
		return holdsTxt;
	}
	
	public String getRunsTxt(){
		return runsTxt;
	}
	
	public String getHBPTxt(){
		return hitByPitchTxt;
	}
	
	public boolean checkTextFields(){
		boolean result;
		
		//Pitching
		if(txtDate.getText() != dateTxt ||
		txtW.getText() != winsTxt ||
		txtL.getText() != lossesTxt ||
		txtERA.getText() != earnedRunAverageTxt ||
		txtSaves.getText() != savesTxt ||
		txtHits.getText() != hitsTxt ||
		txtHolds.getText() != holdsTxt ||
		txtRuns.getText() != runsTxt ||
		txtHBP.getText() != hitByPitchTxt){
			
			result = false;
		}
		else{
			result = true;
		}
		
		return result;
	}
}