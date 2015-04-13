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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Font;


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
		setPreferredSize(new Dimension(1000, 650));
		setBackground(new Color(47, 52, 64));
		setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
		
		JLabel lblEmailUs = new JLabel("Email Us: ser.sports.asu@gmail.com");
		lblEmailUs.setFont(new Font("Bangla MN", Font.PLAIN, 18));
		lblEmailUs.setForeground(new Color(244, 229, 192));
		lblEmailUs.setBounds(81, 167, 369, 29);
		add(lblEmailUs);
		
		JLabel lblCallUs = new JLabel("Call Us: (555) 555-5555");
		lblCallUs.setFont(new Font("Bangla MN", Font.PLAIN, 18));
		lblCallUs.setForeground(new Color(244, 229, 192));
		lblCallUs.setBounds(81, 203, 251, 29);
		add(lblCallUs);
			
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI.setApplicationToClose(); 
    		}
    	});

	}
}