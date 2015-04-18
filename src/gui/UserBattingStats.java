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
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

/**
Class: UserBattingStats

Description: GUI for User Batting stats
*/
public class UserBattingStats extends JPanel {	
	
	private final String dateTxt = "YYYY-MM-DD";
	private final String abTxt = "At Bats";
	private final String hitsTxt = "Hits";
	private final String rbiTxt = "RBI";
	private final String b1Txt = "Single";
	private final String b2Txt = "Double";
	private final String b3Txt = "Triple";
	private final String runsTxt = "Runs";
	private final String sbTxt = "Stolen Bases";
	private final String hrTxt = "Home Runs";
	private final String soTxt = "Strikeouts";
	private ModifiedJScrollPane scrollPane = new ModifiedJScrollPane();
	private TextFieldDocumentListener textFieldDocList = new TextFieldDocumentListener();
	
	protected ModifiedJTable table = new ModifiedJTable(new DefaultTableModel(null, new Object[]{"Won", "AB", "H",
			"RBI", "1B", "2B", "3B", "Runs", "SB", "HR", "SO" }));
	protected ModifiedJTextField txtAB = new ModifiedJTextField();
	protected ModifiedJTextField txtHits = new ModifiedJTextField();
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
	protected String[] comboBoxInput = {"Win","Loss"};
	protected JComboBox comboBox = new JComboBox(comboBoxInput);

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
		
		JLabel lblEnter = new JLabel("Enter New Stats:");
		lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
		lblEnter.setBounds(65, 54, 158, 31);
		lblEnter.setForeground(new Color(244, 229, 192));
		add(lblEnter);
		
		txtDate.setBounds(65, 97, 158, 31);
		txtDate.setText(dateTxt);
		add(txtDate);
		txtDate.addFocusListener(new ModifiedFocusAdapter(txtDate, dateTxt));
		txtDate.getDocument().addDocumentListener(textFieldDocList);
		
		txtAB.setBounds(230, 97, 158, 31);
		txtAB.setText(abTxt);
		add(txtAB);
		txtAB.addFocusListener(new ModifiedFocusAdapter(txtAB, abTxt));
		txtAB.getDocument().addDocumentListener(textFieldDocList);
		
		txtHits.setBounds(394, 97, 158, 31);
		txtHits.setText(hitsTxt);
		add(txtHits);
		txtHits.addFocusListener(new ModifiedFocusAdapter(txtHits, hitsTxt));
		txtHits.getDocument().addDocumentListener(textFieldDocList);
		
		txtRBI.setBounds(558, 97, 158, 31);
		txtRBI.setText(rbiTxt);
		add(txtRBI);
		txtRBI.addFocusListener(new ModifiedFocusAdapter(txtRBI, rbiTxt));
		txtRBI.getDocument().addDocumentListener(textFieldDocList);
		
		txtb_1.setBounds(65, 135, 158, 31);
		txtb_1.setText(b1Txt);
		add(txtb_1);
		txtb_1.addFocusListener(new ModifiedFocusAdapter(txtb_1, b1Txt));
		txtb_1.getDocument().addDocumentListener(textFieldDocList);
		
		txtb_2.setBounds(230, 135, 158, 31);
		txtb_2.setText(b2Txt);
		add(txtb_2);
		txtb_2.addFocusListener(new ModifiedFocusAdapter(txtb_2, b2Txt));
		txtb_2.getDocument().addDocumentListener(textFieldDocList);
		
		txtb_3.setBounds(394, 135, 158, 31);
		txtb_3.setText(b3Txt);
		add(txtb_3);
		txtb_3.addFocusListener(new ModifiedFocusAdapter(txtb_3, b3Txt));
		txtb_3.getDocument().addDocumentListener(textFieldDocList);
		
		txtRuns.setBounds(558, 135, 158, 31);
		txtRuns.setText(runsTxt);
		add(txtRuns);
		txtRuns.addFocusListener(new ModifiedFocusAdapter(txtRuns, runsTxt));
		txtRuns.getDocument().addDocumentListener(textFieldDocList);
		
		txtSB.setBounds(65, 173, 158, 31);
		txtSB.setText(sbTxt);
		add(txtSB);
		txtSB.addFocusListener(new ModifiedFocusAdapter(txtSB, sbTxt));
		txtRuns.getDocument().addDocumentListener(textFieldDocList);
		
		txtHR.setBounds(230, 173, 158, 31);
		txtHR.setText(hrTxt);
		add(txtHR);
		txtHR.addFocusListener(new ModifiedFocusAdapter(txtHR, hrTxt));
		txtHR.getDocument().addDocumentListener(textFieldDocList);
		
		txtSO.setBounds(394, 173, 158, 31);
		txtSO.setText(soTxt);
		add(txtSO);
		txtSO.addFocusListener(new ModifiedFocusAdapter(txtSO, soTxt));
		txtSO.getDocument().addDocumentListener(textFieldDocList);
		
		comboBox.setBounds(558, 173, 158, 31);
		add(comboBox);
		comboBox.setBorder(new LineBorder(new Color(244, 229, 192), 1));
		//comboBox.setBackground(new Color(47, 52, 64));
		//comboBox.setForeground(new Color(244, 229, 192));
		
		//JButton 
		submitBattingStats.setBounds(320, 216, 159, 31);
		add(submitBattingStats);
		submitBattingStats.setActionCommand("SubmitBattingStats");	
		
		scrollPane.setBounds(22, 266, 734, 145);
		add(scrollPane);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
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
		lblBorderlayout.setForeground(Color.WHITE);
		lblBorderlayout.setBounds(-184, 16, 968, 483);
		add(lblBorderlayout);
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));	
	}
	
	public String getDateTxt(){
		return dateTxt;
	}
	
	public String getABTxt(){
		return abTxt;
	}
	
	public String getHitsTxt(){
		return hitsTxt;
	}
	
	public String getRBITxt(){
		return rbiTxt;
	}
	
	public String getB1Txt(){
		return b1Txt;
	}
	
	public String getB2Txt(){
		return b2Txt;
	}
	
	public String getB3Txt(){
		return b3Txt;
	}
	
	public String getRunsTxt(){
		return runsTxt;
	}
	
	public String getSBTxt(){
		return sbTxt;
	}
	
	public String getHRTxt(){
		return hrTxt;
	}
	
	public String getSOTxt(){
		return soTxt;
	}
	
	public boolean getDirtyStatus(){
		return textFieldDocList.isDirty();
	}
}