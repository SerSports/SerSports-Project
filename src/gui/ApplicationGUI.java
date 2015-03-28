package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

//import client.MlbStatsGuiClient;
import client.*;

import javax.swing.border.LineBorder;

public class ApplicationGUI extends JTabbedPane {
		JTabbedPane jtp = new JTabbedPane();
	public ApplicationGUI() {
		jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jtp.setTabPlacement(JTabbedPane.TOP);
		add(jtp);
		jtp.setBounds(2, 2, 1200, 650);
		JTabbedPane MultipleStats = new JTabbedPane();
		//MultipleStats.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Calling Jpanel classes and putting them into tabbedPanes
		
		//Home Page
		HomePageGUI jp1 = new HomePageGUI();
		jtp.addTab("Home", jp1);
		
		//UserStats
		jtp.add("User Stats", MultipleStats);
		UserBattingStats batting = new UserBattingStatsClient();
		UserFieldingStats fielding = new UserFieldingStatsClient();
		UserPitchingStats pitching = new UserPitchingStatsClient();
		MultipleStats.add("Batting", batting);
		MultipleStats.add("Fielding", fielding);
		MultipleStats.add("Pitching", pitching);

		//Browse Local Players
		BrowseLocalPlayers jp3 = new BrowseLocalPlayers();
		jtp.addTab("Browse Local Players", jp3);
		
		//MlbStats Browse
		MlbStatsGui jp4 = new MlbStatsGuiClient();
		jtp.addTab("Choose MLB Players", jp4);
		
		//Help
		Help jp5 = new Help();
		jtp.addTab("Help", jp5);
		
		//Contact Us
		ContactUs jp6 = new ContactUs();
		jtp.addTab("Contact Us", jp6);

	}

}
