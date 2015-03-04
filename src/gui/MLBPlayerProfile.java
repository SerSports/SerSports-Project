/*
File: MLBPlayerProfile.java
Author:	
Date:	

Description: GUI for displaying the MLB Player's profile/stats

*/
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


/**
Class: MLBPlayerProfile

Description: GUI for displaying MLB Player Profiles
*/
public class MLBPlayerProfile extends JPanel {
    private MainGUI frame;
    private MLBPlayerProfile firstPanel;
    private MlbStatsGui secondPanel;
    private MLBPlayerProfile thirdPanel;
    public JButton btnbtnBackButton;
    MLBBattingStats batting = new MLBBattingStats(null);
    MLBPitchingStats pitching = new MLBPitchingStats();
    MLBFieldingStats fielding = new MLBFieldingStats();
    
    /**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel.
	*/
    public MLBPlayerProfile() {
        setLayout(null);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(6, 6, 117, 29);
        add(btnBack);
        
        JTabbedPane jtp = new JTabbedPane(JTabbedPane.BOTTOM);
        jtp.setBounds(6, 47, 1274, 569);
        add(jtp);
        
        MLBBattingStats batting = new MLBBattingStats(null);
        MLBPitchingStats pitching = new MLBPitchingStats();
        MLBFieldingStats fielding = new MLBFieldingStats();
        
        jtp.addTab("Batting", batting);
        jtp.addTab("Fielding", fielding);
        jtp.addTab("Pitching", pitching);
    }
}