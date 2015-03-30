/*
File: BrowseLocalPlayers.java
Author:	
Date:	

Description: GUI for displaying/searching the Local Players database

*/

package gui;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
Class: BrowseLocalPlayers

Description: GUI for displaying/searching Local Players database
*/
public class BrowseLocalPlayers extends JPanel {
	private JTextField txtLastEnterNameteamPosition;
	private JTable table;
	private JTextField txtLocalLastName;
	private JTextField txtLocalTeam;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public BrowseLocalPlayers() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(20, 20, 100, 100);
		add(logo);
		
		JButton SubmitLocalSearch = new JButton("Submit");
		SubmitLocalSearch.setBounds(38, 255, 117, 29);
		add(SubmitLocalSearch);
		
		txtLastEnterNameteamPosition = new JTextField();
		txtLastEnterNameteamPosition.setText("First Name");
		txtLastEnterNameteamPosition.setBounds(30, 134, 176, 29);
		add(txtLastEnterNameteamPosition);
		txtLastEnterNameteamPosition.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 294, 480, 181);
		add(scrollPane);
		
		JButton btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(422, 517, 200, 50);
		add(btnSeePlayerStats);
	
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
		
		txtLocalLastName = new JTextField();
		txtLocalLastName.setText("Last Name");
		txtLocalLastName.setColumns(10);
		txtLocalLastName.setBounds(30, 174, 176, 29);
		add(txtLocalLastName);
		
		txtLocalTeam = new JTextField();
		txtLocalTeam.setText("Team");
		txtLocalTeam.setColumns(10);
		txtLocalTeam.setBounds(30, 214, 176, 29);
		add(txtLocalTeam);
	}
}