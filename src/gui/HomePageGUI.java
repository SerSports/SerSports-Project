/*
File: HomePageGUI.java		
Author:	
Date:	

Description: GUI for the Home Page 

*/
package gui;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import database.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;


/**
Class: HomePageGUI

Description: GUI for the home page
*/
public class HomePageGUI extends JPanel {
	protected User currentUser = null;
	protected JLabel userFirstName = null;
	protected JButton btnSignOut;
	protected JTable comparisonTable;
	protected JButton btnFindBestComparison = null;
	protected JLabel lblInsertPlayersName = null;
	protected JLabel label = null;
	protected Image imgbackground = new ImageIcon(this.getClass().getResource("/images/Backgroundimage.png")).getImage();
	protected JLabel lblbackgroundImage = new JLabel("");
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public HomePageGUI() {
		setBounds(0, 114, 1300, 597);
		setPreferredSize(new Dimension(1000, 650));
		setBackground(new Color(47, 52, 64));
		setLayout(null);
		
		JLabel diamond = new JLabel("");
		diamond.setBounds(189, -48, 64, 64);
		add(diamond);
		Image img2 = new ImageIcon(this.getClass().getResource("/images/diamond.png")).getImage();
		diamond.setIcon(new ImageIcon(img2));
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		
		JLabel line = new JLabel("");
		line.setBounds(16, 98, 508, 29);
		add(line);
		Image imgline = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
		line.setIcon(new ImageIcon(imgline));
		
		JLabel lblYouAre = new JLabel("You are");
		lblYouAre.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(490, 155, 60, 16);
		add(lblYouAre);
		
		label = new JLabel("");
		label.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		label.setForeground(new Color(244, 229, 192));
		label.setBounds(556, 156, 50, 19);
		add(label);
		
		JLabel lblPercent = new JLabel("percent like");
		lblPercent.setForeground(new Color(244, 229, 192));
		lblPercent.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblPercent.setBounds(610, 155, 100, 16);
		add(lblPercent);
		
		lblInsertPlayersName = new JLabel("Insert Players name");
		lblInsertPlayersName.setForeground(new Color(244, 229, 192));
		lblInsertPlayersName.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblInsertPlayersName.setBounds(705, 155, 211, 16);
		add(lblInsertPlayersName);		
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(new Color(244, 229, 192));
		lblWelcome.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		lblWelcome.setBounds(34, 69, 131, 29);
		add(lblWelcome);
		
		//calling name
		userFirstName = new JLabel();
		userFirstName.setForeground(new Color(244, 229, 192));
		userFirstName.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		userFirstName.setBounds(140, 69, 321, 29);
		add(userFirstName);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(259, 187, 480, 190);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		scrollPane_2.setBorder(new LineBorder(new Color(244, 229, 192), 1));
		add(scrollPane_2);

		comparisonTable =  new ModifiedJTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name","Team","Similarity %"}));
		scrollPane_2.setViewportView(comparisonTable);
		
		btnFindBestComparison = new JButton("Find Best Comparison");
		btnFindBestComparison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindBestComparison.setForeground(new Color(244, 229, 192));
		btnFindBestComparison.setFont(new Font("Bangla MN", Font.PLAIN, 16));
		btnFindBestComparison.setBounds(382, 406, 235, 46);
		add(btnFindBestComparison);
		btnFindBestComparison.setActionCommand("Find Best Comparison");
		btnFindBestComparison.setBorder(new LineBorder(new Color(244, 229, 192), 2));
		btnFindBestComparison.setBackground(new Color(47, 52, 64));
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(16, 16, 968, 483);
		add(lblBorderlayout);
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
	}
	
	
	
}