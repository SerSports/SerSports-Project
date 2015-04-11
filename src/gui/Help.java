/*
File: Help.java
Author:	
Date:	

Description: GUI for the help page

*/
package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;


/**
Class: Help

Description: GUI for the help page
*/
public class Help extends JPanel {
	private JTextField txtTypeQuestion;
	protected JButton btnSignOut;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public Help() {
		setPreferredSize(new Dimension(1000, 600));
		setLayout(null);
		setBackground(new Color(47, 52, 64));

		JLabel lblYouAre = new JLabel("FAQ & Help");
		lblYouAre.setBounds(600, 118, 80, 16);
		add(lblYouAre);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 141, 42);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		
		txtTypeQuestion = new JTextField();
		txtTypeQuestion.setText("Enter Search here..");
		txtTypeQuestion.setBounds(573, 136, 134, 28);
		add(txtTypeQuestion);
		txtTypeQuestion.setColumns(10);
		
		JButton btnHelpSubmit = new JButton("Submit");
		btnHelpSubmit.setBounds(581, 177, 117, 29);
		add(btnHelpSubmit);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(1030, 20, 117, 29);
		add(btnSignOut);
		
		btnSignOut.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			MainGUI.setApplicationToClose(); 
    		}
    	});
	}
}