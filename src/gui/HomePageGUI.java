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
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import database.*;
import client.*;


/**
Class: HomePageGUI

Description: GUI for the home page
*/
public class HomePageGUI extends JPanel {
	User currentUser = null;
	JLabel userFirstName = null;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public HomePageGUI() {
		
		//User currentUser = User.getCurrentUser();
		//System.out.println(currentUser.getUserName());
		//String name = currentUser.getUserName();
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(6, 6, 100, 100);
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
		lblWelcome.setBounds(153, 59, 66, 16);
		add(lblWelcome);
		
		//String userName = currentUser.getUserName();	
		//System.out.println(userName);
		//System.out.println(currentUser.getUserName());
		userFirstName = new JLabel();//currentUser.getUserName());
		userFirstName.setBounds(217, 59, 89, 16);
		add(userFirstName);
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