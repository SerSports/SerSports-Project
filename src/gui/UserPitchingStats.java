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
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;


/**
Class: UserPitchingStats

Description: Creates a panel for the User Batting Stats
*/
public class UserPitchingStats extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1923519864816674774L;
	private String dateTxt = "YYYY-MM-DD";
	private String winsTxt = "Wins";
	private String lossesTxt = "Loss";
	private String earnedRunAverageTxt = "ERA";
	private String savesTxt = "Saves";
	private String hitsTxt = "Hits";
	private String holdsTxt = "Holds";
	private String runsTxt = "Runs";
	private String hitByPitchTxt = "HBP";
	private JLabel lineTitle = new JLabel("");
	private Image imgunderLine = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
	
	protected ModifiedJTable table = new ModifiedJTable(new DefaultTableModel(null, new Object[]{"Date","GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
	private ModifiedJScrollPane scrollPane = new ModifiedJScrollPane();
	protected ModifiedJTextField txtDate = new ModifiedJTextField();
	protected ModifiedJTextField txtERA = new ModifiedJTextField();
	protected ModifiedJTextField txtSaves = new ModifiedJTextField();
	protected ModifiedJTextField txtHits = new ModifiedJTextField();
	protected ModifiedJTextField txtHolds = new ModifiedJTextField();
	protected ModifiedJTextField txtRuns = new ModifiedJTextField();
	protected ModifiedJTextField txtHBP = new ModifiedJTextField();
	protected ModifiedJButtonStyle1 btnUpdateStatistic = new ModifiedJButtonStyle1("Update Statistic");
	protected ModifiedJButtonStyle1 btnDeleteStatistic = new ModifiedJButtonStyle1("Delete Statistic");
	protected ModifiedJButtonStyle1 SubmitPitchingStats = new ModifiedJButtonStyle1("Submit");
	protected String[] comboBoxInput = {"Win","Loss"};
	protected JComboBox comboBox = new JComboBox(comboBoxInput);
	
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
		
		lineTitle.setBounds(-16, 77, 196, 3);
		lineTitle.setIcon(new ImageIcon(imgunderLine));
		add(lineTitle);
		
		JLabel lblEnter = new JLabel("Enter New Stats:");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(6, 50, 158, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setText(dateTxt);
		txtDate.setBounds(65, 97, 158, 31);
		add(txtDate);
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, dateTxt));
		
		txtERA.setText(earnedRunAverageTxt);
		txtERA.setBounds(230, 97, 158, 31);
		add(txtERA);
		txtERA.addFocusListener(new ModifiedFocusAdapter(txtERA, earnedRunAverageTxt));
		
		txtSaves.setText(savesTxt);
		txtSaves.setBounds(394, 97, 158, 31);
		add(txtSaves);
		txtSaves.addFocusListener(new ModifiedFocusAdapter(txtSaves, savesTxt));
		
		txtHits.setText(hitsTxt);
		txtHits.setBounds(558, 97, 158, 31);
		add(txtHits);
		txtHits.addFocusListener(new ModifiedFocusAdapter(txtHits, hitsTxt));
		
		txtHolds.setText(holdsTxt);
		txtHolds.setBounds(65, 135, 158, 31);
		add(txtHolds);
		txtHolds.addFocusListener(new ModifiedFocusAdapter(txtHolds, holdsTxt));
		
		txtRuns.setText(runsTxt);
		txtRuns.setBounds(230, 135, 158, 31);
		add(txtRuns);
		txtRuns.addFocusListener(new ModifiedFocusAdapter(txtRuns, runsTxt));
		
		txtHBP.setText(hitByPitchTxt);
		txtHBP.setBounds(394, 135, 158, 31);
		add(txtHBP);
		txtHBP.addFocusListener(new ModifiedFocusAdapter(txtHBP, hitByPitchTxt));
		
		//JButton
		SubmitPitchingStats.setBounds(320, 216, 158, 31);
		add(SubmitPitchingStats);
		SubmitPitchingStats.setActionCommand("SubmitPitchingStats");
		
		//JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 266, 734, 145);
		add(scrollPane);		

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
		
		comboBox.setBounds(558, 135, 158, 31);
		add(comboBox);
		
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
		if(!(txtDate.getText()).equals(dateTxt) ||
		!(txtERA.getText()).equals(earnedRunAverageTxt) ||
		!(txtSaves.getText()).equals(savesTxt) ||
		!(txtHits.getText()).equals(hitsTxt) ||
		!(txtHolds.getText()).equals(holdsTxt) ||
		!(txtRuns.getText()).equals(runsTxt) ||
		!(txtHBP.getText()).equals(hitByPitchTxt)){
			
			result = false;
		}
		else{
			result = true;
		}
		
		return result;
	}
}