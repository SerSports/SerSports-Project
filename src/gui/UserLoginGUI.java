/*
File: MainGUI.java
Author:	
Date:	

Description: Main GUI (the brain, the tabs)

 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.User;

/**
 * Class: MainGUI
 * 
 * Description: GUI for main navigation of site
 */
public class UserLoginGUI extends JPanel {
	protected JTextField txtUserName = new JTextField();
	protected JPasswordField pwdPassword = new JPasswordField();
	protected JButton btnSubmit = new JButton("SIGN IN");
	protected JButton btnCreateAccount_1 = new JButton("CREATE ACCOUNT");
	protected JButton btnCreateAccount;
	protected Image img = new ImageIcon(this.getClass().getResource(
			"/images/Backgroundimage.png")).getImage();
	protected Image lineimg = new ImageIcon(this.getClass().getResource(
			"/images/LineSignInPage.png")).getImage();
	protected JLabel lblbackgroundImage = new JLabel("");
	protected Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	MainGUI main = null;

	// private static MainGUI singleton = null;

	public UserLoginGUI() {
		setLayout(null);
		setPreferredSize(new Dimension(1000, 650));
		txtUserName.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 14));

		
		txtUserName.setBackground(new Color(47, 52, 64));
		txtUserName.setForeground(new Color(244, 229, 192));
		txtUserName.setBounds(432, 199, 135, 28);
		txtUserName.setText("ser_sports");
		add(txtUserName);
		pwdPassword.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 14));

		pwdPassword.setBackground(new Color(47, 52, 64));
		pwdPassword.setForeground(new Color(244, 229, 192));
		pwdPassword.setBounds(432, 246, 135, 28);
		pwdPassword.setText("admin");
		add(pwdPassword);

		btnSubmit.setBounds(456, 301, 88, 29);
		add(btnSubmit);
		btnSubmit.setBorder(BorderFactory.createEmptyBorder());
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setForeground(new Color(244, 229, 192));
		btnSubmit.setFont(new Font("jaf lapture", Font.PLAIN, 18));

		btnCreateAccount_1.setBounds(417, 342, 166, 28);
		add(btnCreateAccount_1);
		btnCreateAccount_1.setBorder(BorderFactory.createEmptyBorder());
		btnCreateAccount_1.setContentAreaFilled(false);
		btnCreateAccount_1.setForeground(new Color(244, 229, 192));
		btnCreateAccount_1.setFont(new Font("jaf lapture", Font.PLAIN, 18));
		
		lblbackgroundImage.setBounds(-908, -627, 3456, 1446);
		add(lblbackgroundImage);
		lblbackgroundImage.setIcon(new ImageIcon(img));


		btnCreateAccount_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showCreateAccount();

			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user = User.authenticateUser(txtUserName.getText(), new String(pwdPassword.getPassword()));
				if (user != null) {
			    main.showApplicationGUI();
				} else {
				JOptionPane.showMessageDialog(null, "Invalid Username / Password!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
				}
				

			}
			
		
		});

	}
	/*
	 * public void loadUserInfoIntoControls() {
	 *     main.loadUserInfoIntoControls();     }
	 */
}