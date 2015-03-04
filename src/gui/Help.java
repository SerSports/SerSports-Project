/*
File: Help.java
Author:	
Date:	

Description: GUI for the help page

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
Class: Help

Description: GUI for the help page
*/
public class Help extends JPanel {
	private JTextField txtTypeQuestion;

	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public Help() {
		setLayout(null);
		setBackground(new Color(107, 185, 240));
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(590, 6, 100, 100);
		add(logo);*/
		
		JLabel lblYouAre = new JLabel("FAQ & Help");
		lblYouAre.setBounds(600, 118, 80, 16);
		add(lblYouAre);
		
		txtTypeQuestion = new JTextField();
		txtTypeQuestion.setText("Enter Search here..");
		txtTypeQuestion.setBounds(573, 136, 134, 28);
		add(txtTypeQuestion);
		txtTypeQuestion.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(581, 177, 117, 29);
		add(btnNewButton);
	}
}