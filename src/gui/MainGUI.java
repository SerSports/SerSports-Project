/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

 */
package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.User;

import java.awt.BorderLayout;

/**
 * Class: MainGUI
 * 
 * Description: GUI for main navigation of site
 */
public class MainGUI {

	private static MainGUI singleton = null;
	JFrame mainFrame = new JFrame("SERSports");
	protected static ApplicationGUI panelApplication = null;
	private static final boolean debugOn = true;
	static JPanel panelContainer = new JPanel();
	UserLoginGUI login = new UserLoginGUI();
	CreateAccount createAccountGUI = new CreateAccount(this);
	static CardLayout c1 = new CardLayout();
	JScrollPane scrollPane = new JScrollPane();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public static void showLoginGUI() {
		c1.show(panelContainer, "1");
	}

	public static void showApplicationGUI() {
		panelApplication.loadUserInfoIntoControls();
		c1.show(panelContainer, "2");
		
	}

	public static void showCreateAccount() {
		c1.show(panelContainer, "3");
	}

	public static void setApplicationToClose() {
		singleton.mainFrame.dispose();
		singleton = new MainGUI();
	}

	public MainGUI() {
		mainFrame.getContentPane().add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportView(panelContainer);
		panelContainer.setLayout(c1);

		c1.show(panelContainer, "1");
		panelApplication = new ApplicationGUI();
		panelContainer.add(login, "1");
		panelContainer.add(panelApplication, "2");
		panelContainer.add(createAccountGUI, "3");

		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
				dim.height / 2 - mainFrame.getSize().height / 2);

	}

	/**
	 * Method: main Inputs: String[] args Returns: NA
	 * 
	 * Description:
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					singleton = new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void debug(String message) {
		if (debugOn) {
			System.out.println("debug: " + message);
		}
	}

	public void loadUserInfoIntoControls() {
		panelApplication.loadUserInfoIntoControls();
	}
}