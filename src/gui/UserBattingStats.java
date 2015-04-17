/*
File: UserBattingStats.java
Author:	
Date:	

Description: GUI for handling the User Batting Stats input

*/
package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

/**
Class: UserBattingStats

Description: GUI for User Batting stats
*/
public class UserBattingStats extends JPanel {	
	
	protected JTable table;
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
	protected JButton btnUpdateStatistic;
	protected JButton btnDeleteStatistic;	
	protected JButton submitBattingStats;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns: 

	  Description: Creates the panel
	*/
	public UserBattingStats() {	
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		JLabel lblYouAre = new JLabel("Enter a new game");
		lblYouAre.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblYouAre.setBounds(20, 36, 164, 31);
		lblYouAre.setForeground(new Color(244, 229, 192));
		add(lblYouAre);
		
		txtAB = new JTextField();
		txtAB.setBounds(56, 184, 105, 22);
		txtAB.setText("At Bats");
		txtAB.setColumns(10);
		add(txtAB);
		
		txtH = new JTextField();
		txtH.setBounds(215, 96, 105, 22);
		txtH.setText("Hits");
		txtH.setColumns(10);
		add(txtH);
		
		txtRBI = new JTextField();
		txtRBI.setBounds(215, 140, 105, 22);
		txtRBI.setText("RBI");
		txtRBI.setColumns(10);
		add(txtRBI);
		
		txtb_1 = new JTextField();
		txtb_1.setBounds(215, 184, 105, 22);
		txtb_1.setText("1B");
		txtb_1.setColumns(10);
		add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setBounds(352, 96, 105, 22);
		txtb_2.setText("2B");
		txtb_2.setColumns(10);
		add(txtb_2);
		
		txtb_3 = new JTextField();
		txtb_3.setBounds(352, 140, 105, 22);
		txtb_3.setText("3B");
		txtb_3.setColumns(10);
		add(txtb_3);
		
		txtRuns = new JTextField();
		txtRuns.setBounds(352, 184, 105, 22);
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		add(txtRuns);
		
		txtSB = new JTextField();
		txtSB.setBounds(488, 184, 105, 22);
		txtSB.setText("Stolen Bases");
		txtSB.setColumns(10);
		add(txtSB);
		
		txtHR = new JTextField();
		txtHR.setBounds(488, 96, 105, 22);
		txtHR.setText("Home Runs");
		txtHR.setColumns(10);
		add(txtHR);
		
		txtSO = new JTextField();
		txtSO.setBounds(488, 140, 105, 22);
		txtSO.setText("Strikeouts");
		txtSO.setColumns(10);
		add(txtSO);
		
		//JButton 
		submitBattingStats = new JButton("Submit");
		submitBattingStats.setBounds(605, 138, 117, 29);
		add(submitBattingStats);
		submitBattingStats.setActionCommand("SubmitBattingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 220, 734, 235);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO", "BA"}));
		scrollPane.setViewportView(table);
		
		txtDate = new JTextField();
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(new Font("Helvetica", Font.PLAIN, 14));
		txtDate.setForeground(Color.WHITE);
		txtDate.setBackground(Color.GRAY);
		txtDate.setBounds(20, 79, 164, 36);
		txtDate.setText("(DATE) YYYY-MM-DD");
		txtDate.setColumns(10);
		add(txtDate);
		//String text = txtDate.getText();
		txtDate.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
            	if (txtDate.getText().equals("(DATE) YYYY-MM-DD")){
                txtDate.setText(""); }
            }
            @Override
            public void focusLost(FocusEvent e){
            	if (txtDate.getText().equals("")){
            	txtDate.setText("(DATE) YYYY-MM-DD");}
            }
        });
		
		

		btnUpdateStatistic = new JButton("Update Statistic");
		btnUpdateStatistic.setBounds(171, 467, 143, 28);
		add(btnUpdateStatistic);
		btnUpdateStatistic.setActionCommand("UpdateStatistic");
		
		btnDeleteStatistic = new JButton("Delete Statistic");
		btnDeleteStatistic.setBounds(339, 467, 143, 28);
		add(btnDeleteStatistic);
		btnDeleteStatistic.setActionCommand("DeleteStatistic");
		
		JLabel lblHits = new JLabel("Hits");
		lblHits.setBounds(254, 79, 40, 16);
		lblHits.setForeground(new Color(244, 229, 192));
		add(lblHits);
		
		JLabel lblRbi = new JLabel("RBI");
		lblRbi.setBounds(254, 124, 40, 16);
		lblRbi.setForeground(new Color(244, 229, 192));
		add(lblRbi);
		
		JLabel lblb = new JLabel("1B");
		lblb.setBounds(254, 168, 40, 16);
		lblb.setForeground(new Color(244, 229, 192));
		add(lblb);
		
		JLabel lblb_1 = new JLabel("2B");
		lblb_1.setBounds(384, 79, 40, 16);
		lblb_1.setForeground(new Color(244, 229, 192));
		add(lblb_1);
		
		JLabel lblb_2 = new JLabel("3B");
		lblb_2.setBounds(395, 124, 40, 16);
		lblb_2.setForeground(new Color(244, 229, 192));
		add(lblb_2);
		
		JLabel lblRuns = new JLabel("Runs");
		lblRuns.setBounds(395, 168, 40, 16);
		lblRuns.setForeground(new Color(244, 229, 192));
		add(lblRuns);
		
		JLabel lblHomeRuns = new JLabel("Home Runs");
		lblHomeRuns.setBounds(509, 79, 72, 16);
		lblHomeRuns.setForeground(new Color(244, 229, 192));
		add(lblHomeRuns);
		
		JLabel lblSo = new JLabel("SO");
		lblSo.setBounds(526, 124, 40, 16);
		lblSo.setForeground(new Color(244, 229, 192));
		add(lblSo);
		
		JLabel lblSb = new JLabel("SB");
		lblSb.setBounds(526, 168, 40, 16);
		lblSb.setForeground(new Color(244, 229, 192));
		add(lblSb);
		
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