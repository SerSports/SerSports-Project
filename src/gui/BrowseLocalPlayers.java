/*
File: BrowseLocalPlayers.java
Author:	
Date:	

Description: GUI for displaying/searching the Local Players database

 */

package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

/**
 * Class: BrowseLocalPlayers
 * 
 * Description: GUI for displaying/searching Local Players database
 */
public class BrowseLocalPlayers extends JPanel {

	// Protected Members
	protected JTextField txtFirstName;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	protected JButton SubmitLocalSearch;
	protected JButton btnSeePlayerStats;
	protected JTable table;
	protected JTable fieldingTable;
	protected JTable pitchingTable;
	protected JTable battingTable;

	// Private Members
	private JLabel mlbBatting;
	private JLabel mlbPitching;

	/**
	 * Method: Constructor Inputs: None Returns:
	 * 
	 * Description: Creates the panel
	 */
	public BrowseLocalPlayers() {
		setPreferredSize(new Dimension(1000, 600));
		setBackground(new Color(47, 52, 64));
		setLayout(null);

		// Menu Indicator
		JLabel diamond = new JLabel("");
		diamond.setBounds(603, -48, 64, 64);
		Image img2 = new ImageIcon(this.getClass().getResource(
				"/images/diamond.png")).getImage();
		add(diamond);
		diamond.setIcon(new ImageIcon(img2));
		Image imgBorder = new ImageIcon(this.getClass().getResource(
				"/images/Border.png")).getImage();

		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource(
				"/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 23, 636, 132);
		add(scrollPane);

		table = new JTable(new DefaultTableModel(null, new Object[] {
				"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(48, 40, 176, 29);
		add(txtFirstName);
		txtFirstName.setText("First Name");
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setBounds(48, 67, 176, 29);
		add(txtLastName);
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);

		txtTeam = new JTextField();
		txtTeam.setBounds(48, 105, 176, 29);
		add(txtTeam);
		txtTeam.setText("Team");
		txtTeam.setColumns(10);

		SubmitLocalSearch = new JButton("Submit");
		SubmitLocalSearch.setBounds(73, 165, 117, 29);
		add(SubmitLocalSearch);

		btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(547, 165, 126, 29);
		add(btnSeePlayerStats);

		JLabel lblIndividualStatistics = new JLabel("Individual Statistics");
		lblIndividualStatistics.setForeground(Color.WHITE);
		lblIndividualStatistics.setBounds(22, 187, 234, 36);
		add(lblIndividualStatistics);
		lblIndividualStatistics.setFont(new Font("Lucida Grande", Font.PLAIN,
				25));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(160, 381, 636, 79);
		add(scrollPane_2);

		fieldingTable = new JTable(new DefaultTableModel(null, new Object[] {
				"GP", "Wins", "Losses", "PO", "Err", "Assist", "F%" }));
		scrollPane_2.setViewportView(fieldingTable);

		JLabel lblFielding = new JLabel("Fielding");
		lblFielding.setForeground(Color.WHITE);
		lblFielding.setBounds(73, 403, 61, 16);
		add(lblFielding);

		JLabel lblPitching = new JLabel("Pitching");
		lblPitching.setForeground(Color.WHITE);
		lblPitching.setBounds(73, 332, 61, 16);
		add(lblPitching);

		JLabel lblBatting = new JLabel("Batting");
		lblBatting.setForeground(Color.WHITE);
		lblBatting.setBounds(73, 270, 61, 16);
		add(lblBatting);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(160, 316, 636, 71);
		add(scrollPane_3);

		pitchingTable = new JTable(new DefaultTableModel(null,
				new Object[] { "GP", "W", "L", "ERA", "SAVES", "HITS", "HOLDS",
						"RUNS", "HBP" }));
		scrollPane_3.setViewportView(pitchingTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(160, 246, 636, 79);
		add(scrollPane_1);

		battingTable = new JTable(new DefaultTableModel(null, new Object[] {
				"GP", "AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR",
				"SO", "BA" }));
		scrollPane_1.setViewportView(battingTable);
		
				// border
				JLabel lblBorderlayout = new JLabel("");
				lblBorderlayout.setBounds(16, 16, 968, 483);
				add(lblBorderlayout);
				lblBorderlayout.setIcon(new ImageIcon(imgBorder));

	}
}