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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.User;

/**
 * Class: MainGUI
 * 
 * Description: GUI for main navigation of site
 */
public class UserLoginGUI extends JPanel {
	protected ModifiedJTextField txtUserName = new ModifiedJTextField();
	private Image imgunderLine = new ImageIcon(this.getClass().getResource("/images/MenuLineIndicator.png")).getImage();
	protected ModifiedJPasswordField pwdPassword = new ModifiedJPasswordField();
	protected ModifiedJButtonStyle1 btnSubmit = new ModifiedJButtonStyle1("SIGN IN");
	protected ModifiedJButtonStyle1 btnCreateAccount_1 = new ModifiedJButtonStyle1("CREATE ACCOUNT");
	protected Image img = new ImageIcon(this.getClass().getResource("/images/Backgroundimage.png")).getImage();
	protected Image loginBorder = new ImageIcon(this.getClass().getResource("/images/LoginBorder.png")).getImage();
	protected JLabel loginnBorderImage = new JLabel("");
	protected JLabel lblbackgroundImage = new JLabel("");
	protected Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	MainGUI main = null;
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");

	public UserLoginGUI() {
		setLayout(null);
		setPreferredSize(new Dimension(1000, 650));
		lblPassword.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(244, 229, 192));
		lblPassword.setBounds(451, 251, 98, 16);
		
		add(lblPassword);
		lblUsername.setFont(new Font("Helvetica", Font.PLAIN, 14));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(new Color(244, 229, 192));
		lblUsername.setBounds(451, 197, 98, 16);
		
		add(lblUsername);
		
		//password text field
		pwdPassword.setLocation(400, 266);
		pwdPassword.setSize(200, 28);
		pwdPassword.setText("admin");
		add(pwdPassword);
		pwdPassword.addFocusListener(new ModifiedFocusAdapter(pwdPassword, "admin"));
		
		
		//username text field
		txtUserName.setBounds(400, 213, 200, 28);
		txtUserName.setText("Username");
		add(txtUserName);
		txtUserName.addFocusListener(new ModifiedFocusAdapter(txtUserName, "Username"));

		//sign in button
		btnSubmit.setBounds(451, 310, 109, 29);
		add(btnSubmit);
		
		//create account button
		btnCreateAccount_1.setBounds(416, 358, 183, 28);
		add(btnCreateAccount_1);
		lblbackgroundImage.setForeground(Color.WHITE);

		
		//background image
		lblbackgroundImage.setBounds(-908, -627, 3456, 1446);
		add(lblbackgroundImage);
		lblbackgroundImage.setIcon(new ImageIcon(img));
		
		/*JTextField mdfdjtxtfldHolder = new JTextField();
		mdfdjtxtfldHolder.setText("");
		mdfdjtxtfldHolder.setBounds(400, 131, 200, 28);
		mdfdjtxtfldHolder.setBackground(Color.WHITE);
		add(mdfdjtxtfldHolder);
		mdfdjtxtfldHolder.setForeground(Color.WHITE);
		//setBackground(new Color(244, 229, 192));
		mdfdjtxtfldHolder.setBorder(new LineBorder(Color.WHITE, 1));*/
		
		

		//create account button action Listener
		btnCreateAccount_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showCreateAccount();
			}
		});
		
		//sign in action button Listener
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
}