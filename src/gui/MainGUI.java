/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

 */
package gui;

import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.*;



/**
 * Class: MainGUI
 * 
 * Description: GUI for main navigation of site
 */
public class MainGUI {
	
	private static MainGUI singleton = null;
	JFrame mainFrame = new JFrame("SERSports");
	protected final static ApplicationGUI panelApplication = new ApplicationGUI();
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
		if (singleton != null) {
			singleton.mainFrame.dispose();
			singleton.mainFrame.repaint();
			singleton = new MainGUI();
			
		}
	}
	
	public static void setHourGlass(Boolean hourGlassOn) {
		if (singleton != null) {
			if (hourGlassOn) {
				singleton.mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			} else {
				singleton.mainFrame.setCursor(Cursor.getDefaultCursor());
			}
		}
	}

	public MainGUI() {
		
		mainFrame.getContentPane().add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportView(panelContainer);
		panelContainer.setLayout(c1);
		
		c1.show(panelContainer, "1");
		panelContainer.add(login, "1");
		panelContainer.add(panelApplication, "2");
		panelContainer.add(createAccountGUI, "3");


		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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