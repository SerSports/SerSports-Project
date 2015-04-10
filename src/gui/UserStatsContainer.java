package gui;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.UserBattingStatsClient;
import client.UserFieldingStatsClient;
import client.UserPitchingStatsClient;

public class UserStatsContainer extends JLayeredPane {
	CardLayout c1 = new CardLayout();
	JPanel panelBodyContainer = new JPanel();
	JPanel menuPanel = new JPanel();	
	protected JButton btnPitchingStats = new JButton("Pitching Stats");
	protected JButton btnFieldingStats = new JButton("Fielding Stats");
	protected JButton btnBattingStats = new JButton("Batting Stats");
	UserBattingStatsClient batting = new UserBattingStatsClient();
	UserFieldingStatsClient fielding = new UserFieldingStatsClient();
	UserPitchingStatsClient pitching = new UserPitchingStatsClient();
	
	
	/**
	 * Create the panel.
	 */
	public UserStatsContainer() {

		setBounds(0, 114, 1300, 597);
		//setPreferredSize(new Dimension(1000, 650));
		setLayout(null);
		menuPanel.setBackground(new Color(47, 52, 64));
		menuPanel.setBounds(0, 0, 160, 600);
		add(menuPanel);
		menuPanel.setLayout(null);
		

		btnBattingStats.setBounds(20, 171, 117, 29);
		menuPanel.add(btnBattingStats );
		
		btnPitchingStats.setBounds(20, 315, 117, 29);
		menuPanel.add(btnPitchingStats);
		
		btnFieldingStats.setBounds(20, 480, 117, 29);	
		menuPanel.add(btnFieldingStats);
		
		panelBodyContainer.setBackground(Color.LIGHT_GRAY);
		panelBodyContainer.setBounds(160, 0, 1300, 600);
		add(panelBodyContainer);
		panelBodyContainer.setLayout(null);
		
		panelBodyContainer.setLayout(c1);
		panelBodyContainer.add(batting, "1");
		panelBodyContainer.add(fielding,"2");
		panelBodyContainer.add(pitching, "3");
    	c1.show(panelBodyContainer, "1");


	
		btnBattingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "1");
	
			}
		});
		
		btnFieldingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "2");
	
			}
		});
		
		btnPitchingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "3");
	
			}
		});
	
	
	}
	
	public void loadUserInfoIntoControls(){
		// Reload the Local Players Batting Statistics Table
		batting.loadUserInfoIntoControls();
		fielding.loadUserInfoIntoControls();
		pitching.loadUserInfoIntoControls();
	}
	
}
