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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.User;

/**
Class: MainGUI

Description: GUI for main navigation of site
*/
public class MainGUI{
	
	private static MainGUI singleton = null;
	protected JScrollPane inputStatsScroll = new JScrollPane(this.panelContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JFrame mainFrame = new JFrame("SERSports");	
	protected ApplicationGUI panelApplication = null;
	private static final boolean debugOn = true;
	protected JTextField txtUserName;
	private final JPasswordField pwdPassword = new JPasswordField();
	protected JButton btnSubmit;
	protected JButton btnCreateAccount;

    JPanel panelContainer = new JPanel();
    JPanel login = new JPanel();
    CreateAccount createAccountGUI = new CreateAccount(this);
    CardLayout c1 = new CardLayout(); 
    
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
		login.setLayout(null);
		txtUserName = new JTextField();
		txtUserName.setBounds(244, 5, 134, 28);
		txtUserName.setText("ser_sports");
		login.add(txtUserName);
		txtUserName.setColumns(10);
		pwdPassword.setBounds(383, 5, 134, 28);
		pwdPassword.setColumns(10);
		pwdPassword.setText("admin");
		login.add(pwdPassword);	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(522, 5, 88, 29);
		login.add(btnSubmit);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(615, 5, 140, 29);
		login.add(btnCreateAccount);

		//create and index the Panels
		panelApplication = new ApplicationGUI();
    	panelContainer.setLayout(c1);
    	panelContainer.add(login, "1");
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
    	
    	btnCreateAccount.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelContainer, "3");
 
    		}
    	});
    	
    	mainFrame.getContentPane().add(panelContainer);
    	mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	mainFrame.pack();
    	mainFrame.setVisible(true);
    	mainFrame.setSize(1024, 768);
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