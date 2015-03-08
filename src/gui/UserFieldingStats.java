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
	private JTextField txtDate;
	private JTextField txtGP;
	private JTextField txtINN;
	private JTextField txtA;
	private JTextField txtE;
	private JTextField txtFpct;
	private JTextField txtSB;
	private JTextField txtCS;

	private JTable table;
	private JTextField txtPo;

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
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
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
		
		txtPo = new JTextField();
		txtPo.setText("PO");
		txtPo.setColumns(10);
		txtPo.setBounds(414, 118, 77, 28);
		add(txtPo);

		
		txtINN = new JTextField();
		txtINN.setText("INN");
		txtINN.setColumns(10);
		txtINN.setBounds(511, 118, 77, 28);
		add(txtINN);
		
		txtA = new JTextField();
		txtA.setText("A");
		txtA.setColumns(10);
		txtA.setBounds(620, 118, 77, 28);
		add(txtA);
		
		txtE = new JTextField();
		txtE.setText("E");
		txtE.setColumns(10);
		txtE.setBounds(709, 118, 77, 28);
		add(txtE);
		
		txtFpct = new JTextField();
		txtFpct.setText("Fpct");
		txtFpct.setColumns(10);
		txtFpct.setBounds(798, 118, 77, 28);
		add(txtFpct);
		
		txtSB = new JTextField();
		txtSB.setText("SB");
		txtSB.setColumns(10);
		txtSB.setBounds(887, 118, 77, 28);
		add(txtSB);
		
		txtCS = new JTextField();
		txtCS.setText("CS");
		txtCS.setColumns(10);
		txtCS.setBounds(976, 118, 77, 28);
		add(txtCS);
		
		
		JButton SubmitFieldingStats = new JButton("Submit");
		SubmitFieldingStats.setBounds(580, 181, 117, 29);
		add(SubmitFieldingStats);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);
		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(table);
	}
}