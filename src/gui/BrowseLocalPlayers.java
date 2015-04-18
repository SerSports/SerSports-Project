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
		diamond.setBounds(603, -48, 64, 64);
		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
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
		scrollPane.setBounds(317, 36, 636, 98);
		add(scrollPane);

		table = new ModifiedJTable(new DefaultTableModel(null, new Object[] {
				"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);

		txtFirstName.setBounds(73, 51, 158, 31);
		add(txtFirstName);
		txtFirstName.setText("First Name");
		txtFirstName.addFocusListener(new ModifiedFocusAdapter(txtFirstName, "First Name"));

		txtLastName.setBounds(73, 94, 158, 31);
		add(txtLastName);
		txtLastName.setText("Last Name");
		txtLastName.addFocusListener(new ModifiedFocusAdapter(txtLastName, "Last Name"));

		txtTeam.setBounds(73, 137, 158, 31);
		add(txtTeam);
		txtTeam.setText("Team");
		txtTeam.addFocusListener(new ModifiedFocusAdapter(txtTeam, "Team"));

		SubmitLocalSearch.setBounds(33, 180, 125, 28);
		add(SubmitLocalSearch);

		btnSeePlayerStats.setBounds(159, 180, 125, 28);
		add(btnSeePlayerStats);

		JLabel lblIndividualStatistics = new JLabel("Individual Statistics");
		lblIndividualStatistics.setForeground(Color.WHITE);
		lblIndividualStatistics.setBounds(736, 146, 234, 36);
		add(lblIndividualStatistics);
		lblIndividualStatistics.setFont(new Font("Lucida Grande", Font.PLAIN,
				25));

		ModifiedJScrollPane scrollPane_2 = new ModifiedJScrollPane();
		scrollPane_2.setBounds(317, 402, 636, 79);
		add(scrollPane_2);

		fieldingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {"Wins", "Losses", "PO", "Err", "Assist", "F%" }));
		scrollPane_2.setViewportView(fieldingTable);

		JLabel lblFielding = new JLabel("Fielding");
		lblFielding.setForeground(Color.WHITE);
		lblFielding.setBounds(244, 427, 61, 16);
		add(lblFielding);

		JLabel lblPitching = new JLabel("Pitching");
		lblPitching.setForeground(Color.WHITE);
		lblPitching.setBounds(246, 330, 61, 16);
		add(lblPitching);

		JLabel lblBatting = new JLabel("Batting");
		lblBatting.setForeground(Color.WHITE);
		lblBatting.setBounds(246, 233, 61, 16);
		add(lblBatting);

		ModifiedJScrollPane scrollPane_3 = new ModifiedJScrollPane();
		scrollPane_3.setBounds(317, 306, 636, 71);
		add(scrollPane_3);

		pitchingTable = new ModifiedJTable(new DefaultTableModel(null,
				new Object[] {"Won","ERA", "SAVES", "HITS", "HOLDS",
						"RUNS", "HBP" }));
		scrollPane_3.setViewportView(pitchingTable);

		ModifiedJScrollPane scrollPane_1 = new ModifiedJScrollPane();
		scrollPane_1.setBounds(317, 205, 636, 79);
		add(scrollPane_1);

		battingTable = new ModifiedJTable(new DefaultTableModel(null, new Object[] {"Won","AB", "H", "RBI", "1B", "2B", "3B", "Runs", "SB", "HR",
				"SO"}));
		scrollPane_1.setViewportView(battingTable);
		
				// border
				JLabel lblBorderlayout = new JLabel("");
				lblBorderlayout.setBounds(16, 16, 968, 483);
				add(lblBorderlayout);
				lblBorderlayout.setIcon(new ImageIcon(imgBorder));

	}
}