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

import client.MlbStatsGuiClient;

import javax.swing.border.LineBorder;

public class ApplicationGUI extends JTabbedPane {

	public ApplicationGUI() {
		setLayout(new BorderLayout(0, 0));
		JTabbedPane jtp = new JTabbedPane();
		jtp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jtp.setTabPlacement(JTabbedPane.TOP);
		add(jtp);
		jtp.setBounds(2, 2, 1200, 650);
		JTabbedPane MultipleStats = new JTabbedPane();
		MultipleStats.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		HomePageGUI jp1 = new HomePageGUI();
		JPanel jp2 = new JPanel();
		BrowseLocalPlayers jp3 = new BrowseLocalPlayers();
		MlbStatsGui jp4 = new MlbStatsGuiClient();
		Help jp5 = new Help();
		ContactUs jp6 = new ContactUs();
		MLBPlayerProfile jp7 = new MLBPlayerProfile();
		UserBattingStats batting = new UserBattingStats();
		UserFieldingStats fielding = new UserFieldingStats();
		UserPitchingStats pitching = new UserPitchingStats();
		jtp.addTab("Home", jp1);
		MultipleStats.add("Batting", batting);
		MultipleStats.add("Fielding", fielding);
		MultipleStats.add("Pitching", pitching);
		jtp.add("User Stats", MultipleStats);
		jtp.addTab("Browse Local Players", jp3);
		jtp.addTab("Choose MLB Players", jp4);
		jtp.addTab("Help", jp5);
		jtp.addTab("Contact Us", jp6);
		jtp.addTab("PlayerProfile", jp7);
	}

}
