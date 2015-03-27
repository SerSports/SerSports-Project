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

//import client.MlbStatsGuiClient;
//import client.UserBattingStatsClient;
import client.*;
import javax.swing.border.BevelBorder;


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
    	//JFrame title
        setTitle("SERSports");
        //JFrame exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Content Pane of Jframe
		getContentPane().setBackground(Color.WHITE);
        getContentPane().setLayout(new BorderLayout(0, 0));    
        //ApplicationgGUI
       
        JPanel panelContainer = new JPanel();
        ApplicationGUI panelApplication = new ApplicationGUI();
        getContentPane().add(panelApplication);
        
        //User login panel
        UserLoginGUI Login = new UserLoginGUI();
        getContentPane().add(Login);
 
        
        //need to add user login panel if statement 

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