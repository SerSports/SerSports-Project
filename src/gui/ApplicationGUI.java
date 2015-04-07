package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//import client.MlbStatsGuiClient;
import client.*;
import database.*;

import javax.swing.border.LineBorder;


public class ApplicationGUI extends JTabbedPane{
	HomePageGUIClient jp1;
	UserBattingStatsClient batting;
	UserFieldingStatsClient fielding;
	UserPitchingStatsClient pitching;
	User currentUser;
	MainGUI mainGuiObj = null;
	
	public ApplicationGUI() {
		
		this.setTabPlacement(JTabbedPane.EAST);
		JTabbedPane MultipleStats = new JTabbedPane();
		MultipleStats.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Calling Jpanel classes and putting them into tabbedPanes
		
		//Home Page
		jp1 = new HomePageGUIClient();
		this.addTab("Home", jp1);
		this.setTabComponentAt(0, getLabel("", "/images/HomeTab.png"));
		
		//UserStats
		this.add("User Stats", MultipleStats);
		batting = new UserBattingStatsClient();
		fielding = new UserFieldingStatsClient();
		pitching = new UserPitchingStatsClient();
		MultipleStats.add("Batting", batting);
		MultipleStats.add("Fielding", fielding);
		MultipleStats.add("Pitching", pitching);

		//Browse Local Players
		BrowseLocalPlayers jp3 = new BrowseLocalPlayersClient();
		this.addTab("Browse Local Players", jp3);
		
		//MlbStats Browse
		MlbStatsGui jp4 = new MlbStatsGuiClient();
		this.addTab("Choose MLB Players", jp4);
		
		//Help
		Help jp5 = new Help();
		this.addTab("Help", jp5);
		
		//Contact Us
		ContactUs jp6 = new ContactUs();
		this.addTab("Contact Us", jp6);

	}


protected JLabel getLabel(String title, String icon) {
	        JLabel label = new JLabel(title);
	        try {
	            label.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(icon))));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return label;
	    }
	public void loadUserInfoIntoControls() {
		jp1.loadUserInfoIntoControls();
		batting.loadUserInfoIntoControls();
		fielding.loadUserInfoIntoControls();
		pitching.loadUserInfoIntoControls();
	}

}
