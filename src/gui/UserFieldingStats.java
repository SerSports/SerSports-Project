/*
File: UserFieldingStats.java
Author:	
Date:	

Description: GUI for handling the User Fielding stats input

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

	private JTable table;
	protected JTextField txtPo;
	protected JTextField txtWins;
	protected JTextField txtLoss;

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
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(90, 124, 119, 16);
		add(lblYouAre);
		
		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setBounds(221, 118, 92, 28);
		add(txtDate);
		txtDate.setColumns(10);
		
		txtGP = new JTextField();
		txtGP.setText("GP");
		txtGP.setColumns(10);
		txtGP.setBounds(325, 118, 77, 28);
		add(txtGP);
		
		txtWins = new JTextField();
		txtWins.setText("Wins");
		txtWins.setColumns(10);
		txtWins.setBounds(414, 118, 77, 28);
		add(txtWins);

		
		txtLoss = new JTextField();
		txtLoss.setText("Losses");
		txtLoss.setColumns(10);
		txtLoss.setBounds(511, 118, 77, 28);
		add(txtLoss);
		
		txtPo = new JTextField();
		txtPo.setText("PO");
		txtPo.setColumns(10);
		txtPo.setBounds(620, 118, 77, 28);
		add(txtPo);
		
		txtE = new JTextField();
		txtE.setText("Err");
		txtE.setColumns(10);
		txtE.setBounds(709, 118, 77, 28);
		add(txtE);
		
		txtA = new JTextField();
		txtA.setText("Assist");
		txtA.setColumns(10);
		txtA.setBounds(798, 118, 77, 28);
		add(txtA);
		
		txtFpct = new JTextField();
		txtFpct.setText("F%");
		txtFpct.setColumns(10);
		txtFpct.setBounds(887, 118, 77, 28);
		add(txtFpct);
		
		
		SubmitFieldingStats = new JButton("Submit");
		SubmitFieldingStats.setBounds(580, 181, 117, 29);
		add(SubmitFieldingStats);
		SubmitFieldingStats.setActionCommand("SubmitFieldingStats");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);
		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(table);
	}
}