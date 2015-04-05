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
		setBackground(new Color(107, 185, 240));
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(590, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("FAQ & Help");
		lblYouAre.setBounds(600, 118, 80, 16);
		add(lblYouAre);
		
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