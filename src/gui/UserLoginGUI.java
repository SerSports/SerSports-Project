/*
File: 
Author:	
Date:	

Description: 

*/
package gui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;


/**
Class: UserLoginGUI

Description: GUI for UserLogin
*/
public class UserLoginGUI extends JPanel {
	protected JTextField txtUserName;
	protected JTextField txtUserName_1;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JButton btnSubmit ;
	protected JButton btnCreateAccount;




	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the frame.
	*/
	public UserLoginGUI() {
		setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(184, 88, 82, 16);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(184, 150, 61, 16);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(154, 110, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 178, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(88, 236, 117, 29);
		add(btnSubmit);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(226, 236, 134, 28);
		add(btnCreateAccount);



	
	}
}