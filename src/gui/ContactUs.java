/*
File: ContactUs.java
Author:	
Date:	

Description: GUI for the Contact Us page

*/
package gui;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;


/**
Class: ContactUs

Description: GUI for the Contact Us Page
*/
public class ContactUs extends JPanel {
	private JTextField txtTypeQuestion;
	protected JButton btnSignOut;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public ContactUs() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
		
		JLabel logo = new JLabel("Logo");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(20, 20, 100, 100);
		add(logo);
		

	}
}