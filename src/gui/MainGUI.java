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
Class: MainGUI

Description: GUI for main navigation of site
*/
public class MainGUI{
	
	private static MainGUI singleton = null;
	JFrame mainFrame = new JFrame("SERSports");	
	protected ApplicationGUI panelApplication = null;
	private static final boolean debugOn = true;
	protected JTextField txtUserName;
	protected JPasswordField pwdPassword = new JPasswordField();
	private JButton btnSubmit = new JButton("SIGN IN");
	private JButton btnCreateAccount;
    JPanel panelContainer = new JPanel();//keep in MainGUI
    JPanel login = new JPanel();
    CreateAccount createAccountGUI = new CreateAccount(this);
    CardLayout c1 = new CardLayout(); 
    JScrollPane scrollPane = new JScrollPane();
    
    public void ShowMainGUI(){
    	c1.show(panelContainer, "2");
    }    
    
    public void ShowLoginGUI(){
    	c1.show(panelContainer, "1");
    }
    
    public static void setApplicationToClose(){
    	singleton.mainFrame.dispose();
    	singleton = new MainGUI();
    }
       
    public MainGUI(){    	
    	mainFrame.getContentPane().add(scrollPane);
    	scrollPane.setBorder(BorderFactory.createEmptyBorder());
    	scrollPane.setViewportView(panelContainer);
    	login.setLayout(null);
    	txtUserName = new JTextField();
    	txtUserName.setBackground(new Color(244, 229, 192));
    	txtUserName.setBounds(432, 199, 135, 28);
    	txtUserName.setText("ser_sports");
    	login.add(txtUserName);
    	txtUserName.setColumns(10);
    	pwdPassword.setBackground(new Color(244, 229, 192));
    	pwdPassword.setBounds(432, 246, 135, 28);
    	pwdPassword.setColumns(10);
    	pwdPassword.setText("admin");
    	login.add(pwdPassword);	
    	
    	btnSubmit.setBounds(456, 319, 88, 29);
    	login.add(btnSubmit);
    	btnSubmit.setBorder(BorderFactory.createEmptyBorder());
    	btnSubmit.setContentAreaFilled(false);
    	btnSubmit.setForeground(new Color(244, 229, 192));
    	btnSubmit.setFont(new Font("jaf lapture", Font.PLAIN, 18));
    	
    	JButton btnCreateAccount_1 = new JButton("CREATE ACCOUNT");
    	btnCreateAccount_1.setBounds(417, 360, 166, 28);
    	login.add(btnCreateAccount_1);	
    	btnCreateAccount_1.setBorder(BorderFactory.createEmptyBorder());
    	btnCreateAccount_1.setContentAreaFilled(false);
    	btnCreateAccount_1.setForeground(new Color(244, 229, 192));
    	btnCreateAccount_1.setFont(new Font("jaf lapture", Font.PLAIN, 18));
    	
    	
    			//create and index the Panels
    			panelApplication = new ApplicationGUI();
    			panelContainer.setLayout(c1);
    			panelContainer.add(login, "1");
    			Image img = new ImageIcon(this.getClass().getResource("/images/Backgroundimage.png")).getImage();
    			
    			JLabel line = new JLabel("");
    			line.setBounds(350, 253, 300, 107);
    			login.add(line);
    			Image lineimg = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
    			line.setIcon(new ImageIcon(lineimg));
    			
    			JLabel lblbackgroundImage = new JLabel("");
    			lblbackgroundImage.setBounds(-908, -627, 3456, 1446);
    			login.add(lblbackgroundImage);
    			lblbackgroundImage.setIcon(new ImageIcon(img));
    			
    			
    			panelContainer.add(panelApplication,"2");
    			panelContainer.add(createAccountGUI, "3");
    			c1.show(panelContainer, "1");
    			
    			   	btnSubmit.addActionListener(new ActionListener(){
    			   		public void actionPerformed(ActionEvent arg0){
    			   			// Authenticate User
    			   			User user = User.authenticateUser(txtUserName.getText(), new String(pwdPassword.getPassword()));
    			   			if (user != null) {
    			   				loadUserInfoIntoControls();
    			   				c1.show(panelContainer, "2");
    			   			} else {
    			   		        JOptionPane.showMessageDialog(null, "Invalid Username / Password!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
    			   			}
    			   		}
    			   	});
    			   	
    			   	btnCreateAccount_1.addActionListener(new ActionListener(){
    			   		public void actionPerformed(ActionEvent arg0){
    			   			c1.show(panelContainer, "3");
 
    			   		}
    			   	});
    			   	
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.pack();
    	mainFrame.setVisible(true);
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
    	
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
					singleton = new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});     
    }
    
    private void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
    
    public void loadUserInfoIntoControls() {
    	panelApplication.loadUserInfoIntoControls();
    }
}