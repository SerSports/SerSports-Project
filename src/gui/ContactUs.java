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
		setLayout(null);
		setBackground(new Color(107, 185, 240));

		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(590, 6, 100, 100);
		add(logo);	
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
	}
}