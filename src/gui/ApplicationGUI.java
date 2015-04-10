package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

//import client.MlbStatsGuiClient;
import client.*;
import database.*;

import javax.swing.border.LineBorder;


public class ApplicationGUI extends JLayeredPane{
	JPanel panelBodyContainer = new JPanel();
	JPanel menuPanel = new JPanel();
	CardLayout c1 = new CardLayout();
	HomePageGUIClient home = new HomePageGUIClient();
	userStatsContainer enterStats = new userStatsContainer();
	MlbStatsGui browseMLB = new MlbStatsGui();
	BrowseLocalPlayers browseLocal = new BrowseLocalPlayers();
	ContactUs contactUs = new ContactUs();
	Help help = new Help();

	
	public ApplicationGUI() {
		setLayout(null);
		setBounds(0,0,1300,597);

		
		//Menu		
		menuPanel.setBounds(0, 0, 1300, 118);
		menuPanel.setBackground(new Color(244, 229, 192));
		menuPanel.setLayout(null);
		add(menuPanel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setBounds(159, 58, 117, 29);
		menuPanel.add(btnHome);
		
		JButton btnEnterNewStats = new JButton("Enter New Stats");
		btnEnterNewStats.setBounds(323, 58, 163, 29);
		menuPanel.add(btnEnterNewStats);
		
		JButton btnBrowseLocal = new JButton("Browse Local");
		btnBrowseLocal.setBounds(511, 58, 163, 29);
		menuPanel.add(btnBrowseLocal);
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		
		JButton btnBrowseMLB = new JButton("Browse MLB");
		btnBrowseMLB.setBounds(705, 58, 163, 29);
		menuPanel.add(btnBrowseMLB);
		
		JLabel logo = new JLabel("");
		logo.setBounds(0, 0, 141, 149);
		menuPanel.add(logo);
		logo.setIcon(new ImageIcon(img));
		
		//Body Container
		panelBodyContainer.setBounds(0, 114, 1300, 597);
		add(panelBodyContainer);	
		panelBodyContainer.setLayout(c1);
		panelBodyContainer.add(home, "1");
		panelBodyContainer.add(enterStats,"2");
		panelBodyContainer.add(browseLocal, "3");
		panelBodyContainer.add(browseMLB, "4");
		panelBodyContainer.add(contactUs, "5");
		panelBodyContainer.add(help, "6");
    	c1.show(panelBodyContainer, "1");
    			
    	btnHome.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "1");
 
    		}
    	});
    	
    	btnEnterNewStats.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "2");
 
    		}
    	});
    	
    	btnBrowseLocal.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "3");
 
    		}
    	});
    	
    	btnBrowseMLB.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			c1.show(panelBodyContainer, "4");
 
    		}
    	});
	    


	}

    public void showHome(){
    	c1.show(panelBodyContainer, "1");
    } 
    
    public void showEnterStats(){
    	c1.show(panelBodyContainer, "2");
    }
    
    public void showBrowseLocal(){
    	c1.show(panelBodyContainer, "3");
    } 
    
    public void showBrowseMLB(){
    	c1.show(panelBodyContainer, "4");
    }
    
    public void showContactUS(){
    	c1.show(panelBodyContainer, "5");
    }
    
    public void showFAQs(){
    	c1.show(panelBodyContainer, "6");
    }
    
protected JLabel getLabel(String title, String icon) {
	        JLabel label = new JLabel(title);
	        try {
	            label.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(icon))));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return label;
	    }


	public void loadUserInfoIntoControls() {
		home.loadUserInfoIntoControls();
		enterStats.loadUserInfoIntoControls();
	}
}
