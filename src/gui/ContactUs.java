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

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


/**
Class: ContactUs

Description: GUI for the Contact Us Page
*/
public class ContactUs extends JPanel {
	private JTextField txtTypeQuestion;
	protected JButton btnSignOut;
	MainGUI mainGUI = null;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public ContactUs() {
		MainGUI main = null;
		this.mainGUI = main;
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
		
		JLabel lblEmailUs = new JLabel("Email Us: ser.sports.asu@gmail.com");
		lblEmailUs.setBounds(81, 167, 244, 16);
		add(lblEmailUs);
		
		JLabel lblCallUs = new JLabel("Call Us: (623) 239-7644");
		lblCallUs.setBounds(81, 203, 244, 16);
		add(lblCallUs);
		
		
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI resetToMain = new MainGUI();
    			//mainGUI.setApplicationToClose(); //does not close out application yet.
 
    		}
    	});

	}
}