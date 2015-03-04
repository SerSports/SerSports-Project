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
	private JTextField txtEnterNameteamPosition;
	private JTable table;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public BrowseLocalPlayers() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
		JButton SubmitLocalSearch = new JButton("Submit");
		SubmitLocalSearch.setBounds(581, 181, 117, 29);
		add(SubmitLocalSearch);
		
		txtEnterNameteamPosition = new JTextField();
		txtEnterNameteamPosition.setText("Enter name,team or position");
		txtEnterNameteamPosition.setBounds(479, 118, 320, 28);
		add(txtEnterNameteamPosition);
		txtEnterNameteamPosition.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 222, 480, 181);
		add(scrollPane);
		
		JButton btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(422, 517, 200, 50);
		add(btnSeePlayerStats);
	
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
	}
}