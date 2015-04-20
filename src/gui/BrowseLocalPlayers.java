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
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Class: BrowseLocalPlayers
 * 
 * Description: GUI for displaying/searching Local Players database
 */
public class BrowseLocalPlayers extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9139519781491923436L;
	// Protected Members
	protected ModifiedJTextField txtFirstName = new ModifiedJTextField();
	protected ModifiedJTextField txtLastName = new ModifiedJTextField();
	protected ModifiedJTextField txtTeam = new ModifiedJTextField();
	protected ModifiedJButtonStyle1 SubmitLocalSearch = new ModifiedJButtonStyle1("Submit");
	protected ModifiedJButtonStyle1 btnSeePlayerStats = new ModifiedJButtonStyle1("See Player Stats");
	protected ModifiedJTable table;
	protected ModifiedJTable fieldingTable;
	protected ModifiedJTable pitchingTable;
	protected ModifiedJTable battingTable;

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
		diamond.setBounds(617, -48, 64, 64);
		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
		
		JLabel line = new JLabel("");
		line.setBounds(721, 76, 261, 4);
		add(line);
		Image imgline = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
		line.setIcon(new ImageIcon(imgline));
		
		add(diamond);
		diamond.setIcon(new ImageIcon(img2));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();

		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource(
				"/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));

		ModifiedJScrollPane scrollPane = new ModifiedJScrollPane();
		scrollPane.setBounds(30, 251, 433, 171);
		add(scrollPane);

		table = new ModifiedJTable(new DefaultTableModel(null, new Object[] {
				"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);

		txtFirstName.setBounds(134, 64, 225, 31);
		add(txtFirstName);
		txtFirstName.setText("First Name");
		txtFirstName.addFocusListener(new ModifiedFocusAdapter(txtFirstName, "First Name"));

		txtLastName.setBounds(134, 103, 225, 31);
		add(txtLastName);
		txtLastName.setText("Last Name");
		txtLastName.addFocusListener(new ModifiedFocusAdapter(txtLastName, "Last Name"));

		txtTeam.setBounds(134, 142, 225, 31);
		add(txtTeam);
		txtTeam.setText("Team");
		txtTeam.addFocusListener(new ModifiedFocusAdapter(txtTeam, "Team"));
		
		SubmitLocalSearch.setText("Search");
		SubmitLocalSearch.setBounds(184, 197, 125, 28);
		add(SubmitLocalSearch);

		btnSeePlayerStats.setBounds(184, 443, 125, 28);
		add(btnSeePlayerStats);
	
		JLabel lblIndividualStatistics = new JLabel("Individual Statistics");
		lblIndividualStatistics.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIndividualStatistics.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 26));
		lblIndividualStatistics.setBounds(711, 38, 257, 41);
		lblIndividualStatistics.setForeground(new Color(244, 229, 192));
		add(lblIndividualStatistics);

		ModifiedJScrollPane scrollPane_2 = new ModifiedJScrollPane();
		scrollPane_2.setBounds(475, 372, 493, 97);
		add(scrollPane_2);

		fieldingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {"Wins", "Losses", "PO", "Err", "Assist", "F%" }));
		scrollPane_2.setViewportView(fieldingTable);
		
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

		JLabel lblBatting = new JLabel("BATTING STATS");
		lblBatting.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatting.setFont(new Font("Malayalam Sangam MN", Font.BOLD, 16));
		lblBatting.setBounds(475, 111, 165, 16);
		lblBatting.setForeground(new Color(244, 229, 192));
		add(lblBatting);

		ModifiedJScrollPane scrollPane_3 = new ModifiedJScrollPane();
		scrollPane_3.setBounds(475, 249, 493, 97);
		add(scrollPane_3);

		pitchingTable = new ModifiedJTable(new DefaultTableModel(null,
				new Object[] {"Won","ERA", "SAVES", "HITS", "HOLDS",
						"RUNS", "HBP" }));
		scrollPane_3.setViewportView(pitchingTable);

		ModifiedJScrollPane scrollPane_1 = new ModifiedJScrollPane();
		scrollPane_1.setBounds(475, 126, 493, 97);
		add(scrollPane_1);

		battingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {"Won","AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR",
				"SO"}));
		scrollPane_1.setViewportView(battingTable);
		battingTable.setFont(new Font("Helvetica", Font.PLAIN, 12));
				
						// border
						JLabel lblBorderlayout = new JLabel("");
						lblBorderlayout.setBounds(16, 16, 968, 483);
						add(lblBorderlayout);
						lblBorderlayout.setIcon(new ImageIcon(imgBorder));

	}
}