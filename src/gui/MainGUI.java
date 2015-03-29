/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

*/
package gui;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import database.User;

/**
Class: MainGUI

Description: GUI for main navigation of site
*/
public class MainGUI{
	private static final boolean debugOn = true;
	
	protected JTextField txtUserName;
	JFrame mainFrame = new JFrame("SERSports");	
	
    JPanel panelContainer = new JPanel();
    ApplicationGUI panelApplication = new ApplicationGUI();
    JPanel login = new JPanel();
    CreateAccount createAccountGUI = new CreateAccount(this);
    CardLayout c1 = new CardLayout();
    private final JPasswordField pwdPassword = new JPasswordField();
   
    public void ShowMainGUI(){
    	c1.show(panelContainer, "2");
    }    
    
    private void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
       
    public MainGUI(){
		txtUserName = new JTextField();
		txtUserName.setText("User Name");
		login.add(txtUserName);
		txtUserName.setColumns(10);
		pwdPassword.setColumns(10);
		pwdPassword.setText("Password");
		login.add(pwdPassword);	
		
		JButton btnSubmit = new JButton("Submit");
		login.add(btnSubmit);
		
		JButton btnCreateAccount = new JButton("Create Account");
		login.add(btnCreateAccount);

		//create and index the Panels
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