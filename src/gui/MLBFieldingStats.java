/*
File: MLBFieldingStats.java
Author:	
Date:	

Description: GUI for displaying the MLB Player's Fielding stats

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
Class: MLBFieldingStats

Description: GUI for displaying MLB Player Fielding Stats
*/
public class MLBFieldingStats extends JPanel {
	private JTextField txtMLBFieldingDate;
	private JTextField txtMLBFieldingAverage;
	private JTextField txtMLBFieldingAb;
	private JTextField txtMLBFieldingb;
	private JTextField txtMLBFieldingb_1;
	private JTextField txtMLBFieldingb_2;
	private JTextField txtMLBFieldingRuns;
	private JTextField txtMLBFieldingSo;
	private JTextField txtMLBFieldingSos;
	private JTextField txtMLBFieldingBb;
	private JTable mlbfieldingTable;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel.
	*/
	public MLBFieldingStats() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);

		mlbfieldingTable = new JTable(new DefaultTableModel(null, new Object[]{"GP", "Wins","Losses","PO","Err","Assist", "F%"}));
		scrollPane.setViewportView(mlbfieldingTable);
	}
}