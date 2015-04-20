/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

 */
package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;



/**
 * Class: MainGUI
 * 
 * Description: GUI for main navigation of site
 */
public class MainGUI {
	private static MainGUI singleton = null;
	JFrame mainFrame = new JFrame("SERSports");
	protected static ApplicationGUI panelApplication = new ApplicationGUI();
	static JPanel panelContainer = new JPanel();
	UserLoginGUI login = new UserLoginGUI();
	CreateAccount createAccountGUI = new CreateAccount(this);
	static CardLayout c1 = new CardLayout();
	JScrollPane scrollPane = new JScrollPane();
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	ImageIcon icon = new ImageIcon ( Toolkit.getDefaultToolkit().getImage(getClass().getResource("../LogoImage/Logo1.png")));


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
		mainFrame.setIconImage(icon.getImage());
		try {
			mainFrame.setIconImage(ImageIO.read(new File("res/icon.png")));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		mainFrame.getContentPane().add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportView(panelContainer);
		panelContainer.setLayout(c1);
		
		c1.show(panelContainer, "1");
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

	public void loadUserInfoIntoControls() {
		panelApplication.loadUserInfoIntoControls();
	}
}