/*
File: MlbStatsGui.java
Author:	
Date:	

Description: GUI for displaying/searching the MLB Stats database

 */
package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Class: MlbStatsGui
 * 
 * Description: GUI for Mlb Stats database
 */
public class MlbStatsGui extends JPanel {

	private static final long serialVersionUID = 1L;
	protected JTextField txtFirstName;
	protected JTable table;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	protected JButton btnSeePlayerStats;
	protected JButton btnCompareToPlayer;
	protected JButton submitPlayerSearchButton;
	protected JTable mlbbattingTable;
	protected JLabel mlbBatting;
	protected JLabel mlbPitching;
	protected JLabel mlbFielding;
	protected JTable mlbfieldingTable;
	protected JTable mlbpitchingTable;
	protected JLabel lblMlbPlayerName;
	protected JLabel lblMlbPlayerTeam;

	/**
	 * Method: Constructor Inputs: None Returns:
	 * 
	 * Description: Creates the panel
	 */
	public MlbStatsGui() {
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource(
				"/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		setPreferredSize(new Dimension(1000, 600));
		setBackground(new Color(47, 52, 64));
		setLayout(null);

		// Menu Indicator
		JLabel diamond = new JLabel("");
		diamond.setBounds(830, -48, 64, 64);
		Image img2 = new ImageIcon(this.getClass().getResource(
				"/images/diamond.png")).getImage();
		add(diamond);
		diamond.setIcon(new ImageIcon(img2));

		// border
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(16, 16, 968, 483);
		add(lblBorderlayout);
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 47, 480, 174);
		add(scrollPane);

		table = new JTable(new DefaultTableModel(null, new Object[] {
				"First Name", "Last Name", "Team"/* "Position" */}));
		scrollPane.setViewportView(table);

		btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(751, 151, 200, 50);
		btnSeePlayerStats.setActionCommand("SeePlayerStats");
		add(btnSeePlayerStats);

		btnCompareToPlayer = new JButton("Compare to Player");
		btnCompareToPlayer.setBounds(751, 75, 200, 50);
		btnCompareToPlayer.setActionCommand("CompareToPlayer");
		add(btnCompareToPlayer);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(36, 40, 125, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(62, 23, 80, 29);
		add(lblFirstName);

		txtLastName = new JTextField();
		txtLastName.setBounds(36, 93, 125, 28);
		add(txtLastName);
		txtLastName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(62, 70, 80, 29);
		add(lblLastName);

		txtTeam = new JTextField();
		txtTeam.setBounds(36, 133, 125, 28);
		add(txtTeam);
		txtTeam.setColumns(10);

		JLabel lblTeamName = new JLabel("Team");
		lblTeamName.setForeground(Color.WHITE);
		lblTeamName.setBounds(82, 118, 80, 29);
		add(lblTeamName);

		submitPlayerSearchButton = new JButton("Submit");
		submitPlayerSearchButton.setBounds(44, 173, 117, 29);
		add(submitPlayerSearchButton);
		submitPlayerSearchButton.setActionCommand("submitPlayerSearchButton");
		submitPlayerSearchButton.setBackground(new Color(255, 237, 203));

		lblMlbPlayerName = new JLabel("");
		lblMlbPlayerName.setForeground(Color.WHITE);
		lblMlbPlayerName.setBounds(282, 219, 189, 16);
		add(lblMlbPlayerName);

		lblMlbPlayerTeam = new JLabel("");
		lblMlbPlayerTeam.setForeground(Color.WHITE);
		lblMlbPlayerTeam.setBounds(604, 219, 189, 16);
		add(lblMlbPlayerTeam);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(191, 388, 653, 67);
		add(scrollPane_3);

		mlbpitchingTable = new JTable(
				new DefaultTableModel(null, new Object[] { "GP", "W", "L",
						"ERA", "SAVES", "HITS", "HOLDS", "RUNS", "BB" }));
		scrollPane_3.setViewportView(mlbpitchingTable);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(191, 328, 653, 67);
		add(scrollPane_2);

		mlbfieldingTable = new JTable(new DefaultTableModel(null, new Object[] {
				"GP", "Wins", "Losses", "PO", "Err", "Assist", "F%" }));
		scrollPane_2.setViewportView(mlbfieldingTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(191, 275, 653, 61);
		add(scrollPane_1);

		mlbbattingTable = new JTable(new DefaultTableModel(null, new Object[] {
				"GP", "AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR",
				"SO", "BA" }));
		scrollPane_1.setViewportView(mlbbattingTable);

		mlbBatting = new JLabel("Batting");
		mlbBatting.setForeground(Color.WHITE);
		mlbBatting.setBounds(117, 289, 61, 16);
		add(mlbBatting);

		mlbFielding = new JLabel("Fielding");
		mlbFielding.setForeground(Color.WHITE);
		mlbFielding.setBounds(117, 346, 61, 16);
		add(mlbFielding);

		mlbPitching = new JLabel("Pitching");
		mlbPitching.setForeground(Color.WHITE);
		mlbPitching.setBounds(117, 406, 61, 16);
		add(mlbPitching);

	}
}