/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

*/
package gui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//import client.MlbStatsGuiClient;
//import client.UserBattingStatsClient;
import client.*;

import javax.swing.border.BevelBorder;


/**
Class: MainGUI

Description: GUI for main navigation of site
*/
public class MainGUI {
	protected JTextField txtUserName;
	protected JTextField txtUserName_1;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JButton btnSubmit ;
	protected JButton btnCreateAccount;
	JFrame mainFrame = new JFrame("SERSports");	
    JPanel panelContainer = new JPanel();
    ApplicationGUI panelApplication = new ApplicationGUI();
    JPanel Login = new JPanel();
    CreateAccount createAccountGUI = new CreateAccount();

    CardLayout c1 = new CardLayout();
   
    public MainGUI(){
		JLabel lblUserName = new JLabel("User Name");
		Login.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		Login.add(lblPassword);
		
		textField = new JTextField();
		Login.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		Login.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		Login.add(btnSubmit);
		
		JButton btnCreateAccount = new JButton("Create Account");
		Login.add(btnCreateAccount);

    	panelContainer.setLayout(c1);
    	panelContainer.add(Login, "1");
    	panelContainer.add(panelApplication,"2");
    	panelContainer.add(createAccountGUI, "3");
    	c1.show(panelContainer, "1");

    
    	btnSubmit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelContainer, "2");
    		}
    	});
    	
    	btnCreateAccount.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelContainer, "3");
    		}
    	});
    	
    	mainFrame.add(panelContainer);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.pack();
    	mainFrame.setVisible(true);
    	mainFrame.setExtendedState(mainFrame.MAXIMIZED_BOTH);
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
					new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});     
    }




}