/*
File: 
Author:	
Date:	

Description: 

*/
package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.TextField;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


/**
Class: UserLoginGUI

Description: GUI for UserLogin
*/
public class UserLoginGUI extends JFrame {
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	  Method: main
	  Inputs: String[] args
	  Returns: NA

	  Description: Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI frame = new UserLoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Create the frame.
	*/
	public UserLoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 517);
		getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(300, 174, 154, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblUsername.setBounds(349, 152, 56, 20);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblPassword.setBounds(349, 226, 56, 15);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 245, 154, 20);
		getContentPane().add(passwordField);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSignIn.setBounds(332, 288, 89, 23);
		getContentPane().add(btnSignIn);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(307, 331, 140, 23);
		getContentPane().add(btnCreateAccount);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 748, 20);
		getContentPane().add(menuBar);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JMenu mnContactUs = new JMenu("Contact Us");
		menuBar.add(mnContactUs);
		
		JMenuItem mntmContactUs = new JMenuItem("Contact Us");
		mnContactUs.add(mntmContactUs);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(327, 32, 100, 100);
		getContentPane().add(label);
	}
}