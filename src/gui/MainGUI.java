/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

*/
package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import client.MlbStatsGuiClient;


/**
Class: MainGUI

Description: GUI for main navigation of site
*/
public class MainGUI extends JFrame {
    
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
    public MainGUI() {
        setTitle("SERSports");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp,BorderLayout.CENTER);
        
        JTabbedPane MultipleStats = new JTabbedPane();
        MultipleStats.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePageGUI jp1 = new HomePageGUI();
        JPanel jp2 = new JPanel();
        BrowseLocalPlayers jp3 = new BrowseLocalPlayers();
        MlbStatsGui jp4 = new MlbStatsGuiClient();
        Help jp5 = new Help();
        ContactUs jp6 = new ContactUs();
        MLBPlayerProfile jp7 = new MLBPlayerProfile();
        UserBattingStats batting = new UserBattingStats();
        //UserFieldingStats fielding = new UserFieldingStats();
        UserPitchingStats pitching = new UserPitchingStats();
        jtp.addTab("Home", jp1);
        MultipleStats.add("Batting", batting);
        //MultipleStats.add("Fielding", fielding);
        MultipleStats.add("Pitching", pitching);
        jtp.add("User Stats", MultipleStats);
        jtp.addTab("Browse Local Players", jp3);
        jtp.addTab("Choose MLB Players", jp4);
        jtp.addTab("Help", jp5);
        jtp.addTab("Contact Us", jp6);
        jtp.addTab("PlayerProfile", jp7);      
    }
    
    /**
	  Method: main
	  Inputs: String[] args
	  Returns: NA

	  Description: 
	*/
    public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});     
    }
}