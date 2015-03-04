<<<<<<< HEAD
package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

import sersports.mlb.MlbPlayerStatistics;
import javax.swing.JScrollPane;

public class MlbStatsGui extends JPanel {

	private JPanel contentPane;
	private JTable tblStats;
	
	private String[] pitchingColumns = {"ERA", "Pitch Count", "Innings Pitched", "Balls", "Strike Outs", "Runs Earned", "On Base HR"};
	private String[] battingColumns = {"At Bat", "AVG", "Slugging", "On Base Percentage", "ISO", "RBI", "AB/HR"};
	private String[] fieldingColumns = {"Home Runs", "Stolen Bases", "HBP", "Hits", "Base on Balls" , "Fielders Choice", "Total bases"};


    public static int randInt(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
	
	/**
	 * Create the frame.
	 */
	public MlbStatsGui(MlbPlayerStatistics iPlayer) {
		
		try {
		
			final MlbPlayerStatistics player = iPlayer;
			
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			
			JButton btnBatting = new JButton("Batting");
			btnBatting.setBounds(10, 11, 89, 23);
			contentPane.add(btnBatting);
			
			JButton btnFielding = new JButton("Fielding");
			btnFielding.setBounds(174, 11, 89, 23);
			contentPane.add(btnFielding);
			
			JButton btnPitching = new JButton("Pitching");

			btnPitching.setBounds(335, 11, 89, 23);
			contentPane.add(btnPitching);
			
			tblStats = new JTable();
			tblStats.setBounds(10, 131, 414, 120);
			contentPane.add(tblStats);
			
			JLabel lblPlayerName = new JLabel(player.returnFullName());
			lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setBounds(131, 97, 181, 23);
			contentPane.add(lblPlayerName);
			
			JScrollPane jScroll = new JScrollPane(tblStats);
			jScroll.setBounds(10, 131, 434, 131);
			contentPane.add(jScroll);
			
			btnPitching.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Float[] returnedData = player.returnData("PITCHING");
					DefaultTableModel newTable = new DefaultTableModel();
					for (int i = 0; i < 7; i++)
					{
						newTable.addColumn(pitchingColumns[i]);
					}
					newTable.addRow(returnedData);
					tblStats.setModel(newTable);
				}
			});
			
			btnFielding.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Float[] returnedData = player.returnData("ONBASE");
					DefaultTableModel newTable = new DefaultTableModel();
					for (int i = 0; i < 7; i++)
					{
						newTable.addColumn(fieldingColumns[i]);
					}
					newTable.addRow(returnedData);
					tblStats.setModel(newTable);
				}
			});
			
			btnBatting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Float[] returnedData = player.returnData("BATTING");
					DefaultTableModel newTable = new DefaultTableModel();
					for (int i = 0; i < 7; i++)
					{
						newTable.addColumn(battingColumns[i]);
					}
					newTable.addRow(returnedData);
					tblStats.setModel(newTable);
				}
			});
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
=======
/*
File: MlbStatsGui.java
Author:	
Date:	

Description: GUI for displaying/searching the MLB Stats database

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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


/**
Class: MlbStatsGui

Description: GUI for Mlb Stats database
*/
public class MlbStatsGui extends JPanel {
	protected JTextField txtFirstName;
	protected JTable table;
	protected JTextField txtLastName;
	protected JTextField txtTeam;
	//protected JButton btnSeePlayerStats;
	//protected JButton btnCompareToPlayer;
	protected JButton SubmitPlayerSearchButton;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public MlbStatsGui() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		getDBconnection();
		getResultsSet();
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
		SubmitPlayerSearchButton = new JButton("Submit");
		SubmitPlayerSearchButton.setBounds(581, 234, 117, 29);
		add(SubmitPlayerSearchButton);
		SubmitPlayerSearchButton.setActionCommand("SubmitPlayerSearchButton");
		SubmitPlayerSearchButton.setBackground(new Color(255,237,203));
	    //getContentPane().add(SubmitPlayerSearchButton);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First Name");
		txtFirstName.setBounds(549, 118, 180, 29);
		add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 288, 478, 246);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team"/* "Position" */}));
		scrollPane.setViewportView(table);
		
		/*btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(421, 594, 200, 50);
		btnSeePlayerStats.setActionCommand("SeePlayerStats");
		add(btnSeePlayerStats);
		
		(btnCompareToPlayer = new JButton("Compare to Player");
		btnCompareToPlayer.setBounds(656, 594, 200, 50);
		btnCompareToPlayer.setActionCommand("CompareToPlayer");
		add(btnCompareToPlayer);*/
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(549, 153, 180, 28);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(549, 193, 180, 28);
		add(txtTeam);
	}

	private void getResultsSet() {
		// TODO Auto-generated method stub
		
	}

	private void getDBconnection() {
		// TODO Auto-generated method stub
		
	}
}
>>>>>>> BrowseMLB
