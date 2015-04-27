/*
File: HomePageGUI.java		
Author:	
Date:	

Description: GUI for the Home Page 

*/
package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import database.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.swing.border.LineBorder;



/**
Class: HomePageGUI

Description: GUI for the home page
*/
public class HomePageGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8138419260517160502L;
	protected User currentUser = null;
	protected JLabel userFirstName = null;
	protected JButton btnSignOut;
	protected JTable comparisonTable;
	protected ModifiedJButtonStyle1 btnFindBestComparison = new ModifiedJButtonStyle1("Find Best Comparison");
	protected JLabel lblInsertPlayersName = null;
	protected JLabel label = null;
	protected Image imgbackground = new ImageIcon(this.getClass().getResource("/images/Backgroundimage.png")).getImage();
	protected JLabel lblbackgroundImage = new JLabel("");
	protected Image img = null;
	protected JLabel mlbImage = null;
	protected float percentScore = 0f;
	protected String mostSimilarPlayerName = "Bob Dole";
	protected JLabel lblYouAre = null;
	
	/**
	  Method: Constructor
	  Inputs: None
	  Returns:

	  Description: Creates the panel
	*/
	public HomePageGUI() {
		
        try {
            URL url = new URL("http://www.clker.com/cliparts/5/9/4/c/12198090531909861341man%20silhouette.svg.hi.png");
            img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
            
            mlbImage = new JLabel(new ImageIcon(dimg));
            mlbImage.setLocation(642, 140);
            mlbImage.setSize(250,250);
            add(mlbImage);
            mlbImage.setBorder(new LineBorder(new Color(244, 229, 192), 3));
 
        } catch (IOException e) {
        	e.printStackTrace();
        }

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
		line.setBounds(16, 98, 285, 29);
		add(line);
		Image imgline = new ImageIcon(this.getClass().getResource("/images/LineSignInPage.png")).getImage();
		line.setIcon(new ImageIcon(imgline));
		
		lblYouAre = new JLabel("You are " + (percentScore * 1000.f) / 10.f + "% percent like " + mostSimilarPlayerName);
		lblYouAre.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 18));
		lblYouAre.setForeground(new Color(244, 229, 192));
		lblYouAre.setBounds(558, 425, 411, 16);
		add(lblYouAre);	
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(new Color(244, 229, 192));
		lblWelcome.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		lblWelcome.setBounds(33, 77, 131, 29);
		add(lblWelcome);
		
		//calling name
		userFirstName = new JLabel();
		userFirstName.setForeground(new Color(244, 229, 192));
		userFirstName.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		userFirstName.setBounds(139, 77, 321, 29);
		add(userFirstName);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(66, 168, 480, 195);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		scrollPane_2.setBorder(new LineBorder(new Color(244, 229, 192), 1));
		add(scrollPane_2);

		comparisonTable =  new ModifiedJTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name","Team","Similarity %"}));
		scrollPane_2.setViewportView(comparisonTable);
		//((ModifiedJTable) comparisonTable).updateRowHeights();
		
		btnFindBestComparison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btnFindBestComparison.setBounds(202, 375, 200, 28);
		add(btnFindBestComparison);
		btnFindBestComparison.setActionCommand("Find Best Comparison");

		
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		JLabel lblTop = new JLabel("Top 10 Table:");
		lblTop.setForeground(new Color(244, 229, 192));
		lblTop.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 24));
		lblTop.setBounds(43, 129, 152, 34);
		add(lblTop);
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(16, 16, 968, 483);
		add(lblBorderlayout);
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
	}
}