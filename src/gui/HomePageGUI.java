/*
File: HomePageGUI.java		
Author:	
Date:	

Description: GUI for the Home Page 

*/
package gui;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import database.*;
import client.*;
import java.awt.Font;


/**
Class: HomePageGUI

Description: GUI for the home page
*/
public class HomePageGUI extends JPanel {
	User currentUser = null;
	JLabel userFirstName = null;
	protected JButton btnSignOut;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public HomePageGUI() {

		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(30, 30, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("You are");
		lblYouAre.setBounds(616, 189, 47, 16);
		add(lblYouAre);
		
		JLabel label = new JLabel("20");
		label.setBounds(675, 189, 16, 16);
		add(label);
		
		JLabel lblPercent = new JLabel("percent like");
		lblPercent.setBounds(588, 217, 74, 16);
		add(lblPercent);
		
		JLabel lblInsertPlayersName = new JLabel("Insert Players name");
		lblInsertPlayersName.setBounds(669, 217, 122, 16);
		add(lblInsertPlayersName);		
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWelcome.setBounds(159, 58, 100, 29);
		add(lblWelcome);
		
		userFirstName = new JLabel();
		userFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userFirstName.setBounds(253, 58, 321, 29);
		add(userFirstName);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
	}
	
	public void loadUserInfoIntoControls()
	{
		// Reload the Current User
		currentUser = User.getCurrentUser();
		if (currentUser != null) {
			userFirstName.setText(currentUser.getUserName());
		}
	}
}