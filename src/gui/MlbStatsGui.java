/*
File: MlbStatsGui.java
Author:	
Date:	

Description: GUI for displaying/searching the MLB Stats database

 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * Class: MlbStatsGui
 * 
 * Description: GUI for Mlb Stats database
 */
public class MlbStatsGui extends JPanel {

	private static final long serialVersionUID = 1L;
	protected ModifiedJTextField txtFirstName = new ModifiedJTextField();
	protected ModifiedJTextField txtLastName = new ModifiedJTextField();
	protected ModifiedJTextField txtTeam = new ModifiedJTextField();
	protected ModifiedJTable table;
	protected ModifiedJButtonStyle1 btnSeePlayerStats;
	protected ModifiedJButtonStyle1 btnCompareToPlayer;
	protected ModifiedJButtonStyle1 submitPlayerSearchButton = new ModifiedJButtonStyle1("Submit");
	protected ModifiedJTable mlbbattingTable;
	protected ModifiedJTable mlbfieldingTable;
	protected ModifiedJTable mlbpitchingTable;
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
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		setPreferredSize(new Dimension(1000, 600));
		setBackground(new Color(47, 52, 64));
		setLayout(null);

		// Menu Indicator
		JLabel diamond = new JLabel("");
		diamond.setBounds(834, -48, 64, 64);
		Image img2 = new ImageIcon(this.getClass().getResource(
				"/images/diamond.png")).getImage();
		add(diamond);
		diamond.setIcon(new ImageIcon(img2));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		JLabel line = new JLabel("");
		line.setBounds(721, 76, 261, 4);
		add(line);
		Image imgline = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
		line.setIcon(new ImageIcon(imgline));

		ModifiedJScrollPane scrollPane = new ModifiedJScrollPane();
		scrollPane.setBounds(30, 251, 433, 171);
		add(scrollPane);
		
		JLabel lblIndividualStatistics = new JLabel("MLB Player Statistics");
		lblIndividualStatistics.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIndividualStatistics.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 26));
		lblIndividualStatistics.setBounds(711, 38, 257, 41);
		lblIndividualStatistics.setForeground(new Color(244, 229, 192));
		add(lblIndividualStatistics);

		table = new ModifiedJTable(new DefaultTableModel(null, new Object[] {
				"First Name", "Last Name", "Team"}));
		scrollPane.setViewportView(table);

		btnSeePlayerStats = new ModifiedJButtonStyle1("See Player Stats");
		btnSeePlayerStats.setBounds(250, 443, 125, 28);
		btnSeePlayerStats.setActionCommand("SeePlayerStats");
		add(btnSeePlayerStats);

		btnCompareToPlayer = new ModifiedJButtonStyle1("Compare to Player");
		btnCompareToPlayer.setBounds(100, 443, 125, 28);
		btnCompareToPlayer.setActionCommand("CompareToPlayer");
		add(btnCompareToPlayer);

		txtFirstName.setText("First Name");
		txtFirstName.setBounds(134, 64, 225, 31);
		txtFirstName.addFocusListener(new ModifiedFocusAdapter(txtFirstName, "First Name"));
		add(txtFirstName);

		txtLastName.setBounds(134, 103, 225, 31);
		txtLastName.setText("Last Name");
		txtLastName.addFocusListener(new ModifiedFocusAdapter(txtLastName, "Last Name"));
		add(txtLastName);

		txtTeam.setBounds(134, 142, 225, 31);
		txtTeam.setText("Team");
		txtTeam.addFocusListener(new ModifiedFocusAdapter(txtTeam, "Team"));
		add(txtTeam);


		submitPlayerSearchButton.setBounds(184, 197, 125, 28);
		add(submitPlayerSearchButton);
		submitPlayerSearchButton.setActionCommand("submitPlayerSearchButton");

		lblMlbPlayerName = new JLabel("");
		lblMlbPlayerName.setForeground(Color.WHITE);
		lblMlbPlayerName.setBounds(54, 223, 189, 16);
		add(lblMlbPlayerName);

		lblMlbPlayerTeam = new JLabel("");
		lblMlbPlayerTeam.setForeground(Color.WHITE);
		lblMlbPlayerTeam.setBounds(261, 223, 189, 16);
		add(lblMlbPlayerTeam);
		
		ModifiedJScrollPane scrollPane_3 = new ModifiedJScrollPane();
		scrollPane_3.setBounds(475, 249, 493, 97);
		add(scrollPane_3);

		mlbpitchingTable = new ModifiedJTable(
				new DefaultTableModel(null, new Object[] { "GP", "W", "L",
						"ERA", "SAVES", "HITS", "HOLDS", "RUNS", "BB" }));
		scrollPane_3.setViewportView(mlbpitchingTable);

		ModifiedJScrollPane scrollPane_2 = new ModifiedJScrollPane();
		scrollPane_2.setBounds(475, 372, 493, 97);
		add(scrollPane_2);

		mlbfieldingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {
				"GP", "Wins", "Losses", "PO", "Err", "Assist", "F%" }));
		scrollPane_2.setViewportView(mlbfieldingTable);

		
		ModifiedJScrollPane scrollPane_1 = new ModifiedJScrollPane();
		scrollPane_1.setBounds(475, 126, 493, 97);
		add(scrollPane_1);
		
		mlbbattingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {
				"GP", "AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR",
				"SO", "BA" }));
		scrollPane_1.setViewportView(mlbbattingTable);
		
		JLabel lblBatting = new JLabel("BATTING STATS");
		lblBatting.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatting.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 16));
		lblBatting.setBounds(475, 111, 165, 16);
		lblBatting.setForeground(new Color(244, 229, 192));
		add(lblBatting);

		JLabel lblFielding = new JLabel("FIELDING STATS");
		lblFielding.setHorizontalAlignment(SwingConstants.LEFT);
		lblFielding.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 16));
		lblFielding.setBounds(475, 357, 165, 16);
		lblFielding.setForeground(new Color(244, 229, 192));
		add(lblFielding);
		
		JLabel lblPitching = new JLabel("PITCHING STATS");
		lblPitching.setHorizontalAlignment(SwingConstants.LEFT);
		lblPitching.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 16));
		lblPitching.setBounds(475, 234, 165, 16);
		lblPitching.setForeground(new Color(244, 229, 192));
		add(lblPitching);
		
				// border
				JLabel lblBorderlayout = new JLabel("");
				lblBorderlayout.setBounds(16, 16, 968, 483);
				add(lblBorderlayout);
				lblBorderlayout.setIcon(new ImageIcon(imgBorder));

	}
}