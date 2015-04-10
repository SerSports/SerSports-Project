/*
File: HomePageGUI.java		
Author:	
Date:	

Description: GUI for the Home Page 

*/
package gui;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import database.*;
import client.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
Class: HomePageGUI

Description: GUI for the home page
*/
public class HomePageGUI extends JPanel {
	protected User currentUser = null;
	protected JLabel userFirstName = null;
	protected JButton btnSignOut;
	protected JTable comparisonTable;
	protected JButton btnFindBestComparison;
	protected JLabel lblInsertPlayersName;
	protected JLabel label;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public HomePageGUI() {
		setBounds(0, 114, 1300, 597);
		setPreferredSize(new Dimension(1000, 650));
		setBackground(new Color(47, 52, 64));
		setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 141, 42);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		
		JLabel lblYouAre = new JLabel("You are");
		lblYouAre.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(212, 109, 60, 16);
		add(lblYouAre);
		
		label = new JLabel("20");
		label.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		label.setForeground(new Color(244, 229, 192));
		label.setBounds(278, 110, 26, 19);
		add(label);
		
		JLabel lblPercent = new JLabel("percent like");
		lblPercent.setForeground(new Color(244, 229, 192));
		lblPercent.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblPercent.setBounds(305, 109, 100, 16);
		add(lblPercent);
		
		lblInsertPlayersName = new JLabel("Insert Players name");
		lblInsertPlayersName.setForeground(new Color(244, 229, 192));
		lblInsertPlayersName.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblInsertPlayersName.setBounds(400, 109, 211, 16);
		add(lblInsertPlayersName);		
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(new Color(244, 229, 192));
		lblWelcome.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		lblWelcome.setBounds(128, 58, 131, 29);
		add(lblWelcome);
		
		//calling name
		userFirstName = new JLabel();
		userFirstName.setForeground(new Color(244, 229, 192));
		userFirstName.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		userFirstName.setBounds(234, 58, 321, 29);
		add(userFirstName);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(253, 177, 480, 139);
		add(scrollPane_2);

		comparisonTable =  new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name","Team","Similarity %"}));
		comparisonTable.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 14));
		comparisonTable.setForeground(new Color(244, 229, 192));
		scrollPane_2.setViewportView(comparisonTable);
		comparisonTable.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
		comparisonTable.setOpaque(false);
		((DefaultTableCellRenderer)comparisonTable.getDefaultRenderer(Object.class)).setOpaque(false);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		comparisonTable.setShowGrid(false);
		
	
		/*
		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(850, 30, 117, 29);
		add(btnSignOut);*/
		
		btnFindBestComparison = new JButton("Find Best Comparison");
		btnFindBestComparison.setBounds(410, 334, 171, 29);
		add(btnFindBestComparison);
	}
}