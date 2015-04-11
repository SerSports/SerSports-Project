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
public class UserLoginGUI extends JPanel {
	protected JPasswordField pwdPassword = new JPasswordField();
	protected JButton btnSubmit = new JButton("SIGN IN");
	protected JButton btnCreateAccount_1 = new JButton("CREATE ACCOUNT");
	protected JButton btnCreateAccount;
	protected JTextField txtUserName = new JTextField();
	protected Image img = new ImageIcon(this.getClass().getResource("/images/Backgroundimage.png")).getImage();
	protected JLabel line = new JLabel("");
	protected Image lineimg = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
	protected JLabel lblbackgroundImage = new JLabel("");
	protected Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	public UserLoginGUI() {
		setLayout(null);
		setLocation(dim.width / 2 - this.getSize().width / 2,dim.height / 2 - this.getSize().height / 2);
		txtUserName.setBackground(new Color(244, 229, 192));
		txtUserName.setBounds(432, 199, 135, 28);
		txtUserName.setText("ser_sports");
		add(txtUserName);

		pwdPassword.setBackground(new Color(244, 229, 192));
		pwdPassword.setBounds(432, 246, 135, 28);
		pwdPassword.setText("admin");
		add(pwdPassword);

		btnSubmit.setBounds(456, 319, 88, 29);
		add(btnSubmit);
		btnSubmit.setBorder(BorderFactory.createEmptyBorder());
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setForeground(new Color(244, 229, 192));
		btnSubmit.setFont(new Font("jaf lapture", Font.PLAIN, 18));

		btnCreateAccount_1.setBounds(417, 360, 166, 28);
		add(btnCreateAccount_1);
		btnCreateAccount_1.setBorder(BorderFactory.createEmptyBorder());
		btnCreateAccount_1.setContentAreaFilled(false);
		btnCreateAccount_1.setForeground(new Color(244, 229, 192));
		btnCreateAccount_1.setFont(new Font("jaf lapture", Font.PLAIN, 18));

		// create and index the Panels
		line.setBounds(350, 253, 300, 107);
		add(line);
		line.setIcon(new ImageIcon(lineimg));
		
		lblbackgroundImage.setBounds(-908, -627, 3456, 1446);
		add(lblbackgroundImage);
		lblbackgroundImage.setIcon(new ImageIcon(img));

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Authenticate User
				User user = User.authenticateUser(txtUserName.getText(),
						new String(pwdPassword.getPassword()));
				if (user != null) {
					loadUserInfoIntoControls();
					c1.show(panelContainer, "2");
				} else {
					JOptionPane.showMessageDialog(null,
							"Invalid Username / Password!",
							"InfoBox: SER SPORTS",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnCreateAccount_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainGUI.c1.show(panelContainer, "3");

			}
		});


	}

	/**
	 * Method: main Inputs: String[] args Returns: NA
	 * 
	 * Description:
	 */
	
	public void loadUserInfoIntoControls() {
		panelApplication.loadUserInfoIntoControls();
	}
}