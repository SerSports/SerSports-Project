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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;


/**
Class: UserBattingStats

Description: GUI for User Batting stats
*/
public class UserBattingStats extends JPanel {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1844009740643893414L;
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
		
		JLabel lblYouAre = new JLabel("Enter a New Game Stats");
		lblYouAre.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblYouAre.setBounds(278, 37, 244, 31);
		lblYouAre.setForeground(new Color(244, 229, 192));
		add(lblYouAre);
		
		txtAB.setBounds(230, 97, 158, 31);
		txtAB.setText("At Bat");
		add(txtAB);
		txtAB.addFocusListener(new ModifiedFocusAdapter(txtAB, "At Bat"));
		
		txtH.setBounds(394, 97, 158, 31);
		txtH.setText("Hits");
		txtH.setColumns(10);
		add(txtH);
		txtH.addFocusListener(new ModifiedFocusAdapter(txtH, "Hits"));
		
		txtRBI.setBounds(560, 97, 158, 31);
		txtRBI.setText("RBI");
		txtRBI.setColumns(10);
		add(txtRBI);
		txtRBI.addFocusListener(new ModifiedFocusAdapter(txtRBI, "RBI"));
		
		txtb_1.setBounds(65, 140, 158, 31);
		txtb_1.setText("1B");
		txtb_1.setColumns(10);
		add(txtb_1);
		txtb_1.addFocusListener(new ModifiedFocusAdapter(txtb_1, "1B"));
		
		txtb_2.setBounds(230, 140, 158, 31);
		txtb_2.setText("2B");
		txtb_2.setColumns(10);
		add(txtb_2);
		txtb_2.addFocusListener(new ModifiedFocusAdapter(txtb_2, "2B"));
		
		txtb_3.setBounds(394, 140, 158, 31);
		txtb_3.setText("3B");
		txtb_3.setColumns(10);
		add(txtb_3);
		txtb_3.addFocusListener(new ModifiedFocusAdapter(txtb_3, "3B"));
		
		txtRuns.setBounds(560, 140, 158, 31);
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		add(txtRuns);
		txtRuns.addFocusListener(new ModifiedFocusAdapter(txtRuns, "Runs"));
		
		txtSB.setBounds(65, 183, 158, 31);
		txtSB.setText("Stolen Bases");
		txtSB.setColumns(10);
		add(txtSB);
		txtSB.addFocusListener(new ModifiedFocusAdapter(txtSB, "Stolen Bases"));
		
		txtHR.setBounds(230, 183, 158, 31);
		txtHR.setText("Home Runs");
		txtHR.setColumns(10);
		add(txtHR);
		txtHR.addFocusListener(new ModifiedFocusAdapter(txtHR, "Home Runs"));
		
		txtSO.setBounds(394, 183, 158, 31);
		txtSO.setText("Strikeouts");
		txtSO.setColumns(10);
		add(txtSO);
		txtSO.addFocusListener(new ModifiedFocusAdapter(txtSO, "Strikeouts"));
		
		//Submitting stats button
		submitBattingStats.setBounds(340, 230, 117, 29);
		add(submitBattingStats);
		submitBattingStats.setActionCommand("SubmitBattingStats");	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 281, 734, 145);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane.setViewportView(table);
		
		txtDate.setBounds(65, 97, 158, 31);
		txtDate.setText("YYYY-MM-DD");
		add(txtDate);		
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, "YYYY-MM-DD"));
		
		btnUpdateStatistic.setBounds(278, 438, 117, 29);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
	
		btnDeleteStatistic.setBounds(405, 438, 117, 29);
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
		//Batting
		if (txtDate.getText() != "MM/DD/YYYY" ||
			txtAB.getText() != "AB" ||
			txtH.getText() != "H" ||
			txtRBI.getText() != "RBI" ||
			txtb_1.getText() != "1B" ||
			txtb_2.getText() != "2B" ||
			txtb_3.getText() != "3B" ||
			txtRuns.getText() != "Runs" ||
			txtSB.getText() != "SB" ||
			txtHR.getText() != "HR" ||
			txtSO.getText() != "SO"	){
			
			return false;
	
		}
		else{
			return true;
		}
	}
}