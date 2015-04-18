package gui;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.UserBattingStatsClient;
import client.UserFieldingStatsClient;
import client.UserPitchingStatsClient;
import java.awt.Font;

public class UserStatsContainer extends JLayeredPane {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 6868512083605771271L;
	CardLayout c1 = new CardLayout();
	JPanel panelBodyContainer = new JPanel();
	JPanel menuPanel = new JPanel();	
	private Image imgunderLine = new ImageIcon(this.getClass().getResource("/images/MenuLineIndicator.png")).getImage();
	protected JButton btnPitchingStats = new JButton("Pitching Stats");
	protected JButton btnFieldingStats = new JButton("Fielding Stats");
	protected JButton btnBattingStats = new JButton("Batting Stats");
	protected JLabel lineBatting = new JLabel("");
	protected JLabel linePitching = new JLabel("");
	protected JLabel lineFielding = new JLabel("");
	UserBattingStatsClient batting = new UserBattingStatsClient();
	UserFieldingStatsClient fielding = new UserFieldingStatsClient();
	UserPitchingStatsClient pitching = new UserPitchingStatsClient();	
	
	/**
	 * Create the panel.
	 */
	public UserStatsContainer() {
		setPreferredSize(new Dimension(1300, 650));
		setBounds(0, 114, 1300, 597);
		setLayout(null);
		
		menuPanel.setBackground(new Color(47, 52, 64));
		menuPanel.setBounds(0, 0, 200, 600);
		add(menuPanel);
		menuPanel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(6, 0, 152, 55);
		menuPanel.add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/LogoBottom.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		
		JLabel menu = new JLabel("");
		menu.setBounds(197, 45, 4, 420);
		menuPanel.add(menu);
		Image imgLineVerticle = new ImageIcon(this.getClass().getResource("/images/MenuLine.png")).getImage();
		menu.setIcon(new ImageIcon(imgLineVerticle));
		
		btnBattingStats.setBounds(26, 80, 164, 55);
		menuPanel.add(btnBattingStats);
		btnBattingStats.setBorder(BorderFactory.createEmptyBorder());
		btnBattingStats.setContentAreaFilled(false);	
		btnBattingStats.setForeground(new Color(244, 229, 192));
		btnBattingStats.setFont(new Font("Bangla MN", Font.PLAIN, 18));
		
		btnPitchingStats.setBounds(26, 215, 164, 55);
		menuPanel.add(btnPitchingStats);
		btnPitchingStats.setBorder(BorderFactory.createEmptyBorder());
		btnPitchingStats.setContentAreaFilled(false);
		btnPitchingStats.setForeground(new Color(244, 229, 192));
		btnPitchingStats.setFont(new Font("Bangla MN", Font.PLAIN, 18));
		
		btnFieldingStats.setBounds(26, 350, 164, 55);	
		menuPanel.add(btnFieldingStats);
		btnFieldingStats.setBorder(BorderFactory.createEmptyBorder());
		btnFieldingStats.setContentAreaFilled(false);
		btnFieldingStats.setForeground(new Color(244, 229, 192));
		btnFieldingStats.setFont(new Font("Bangla MN", Font.PLAIN, 18));
		Image imgBorder = new ImageIcon(this.getClass().getResource("/images/Border.png")).getImage();
		
		lineBatting.setBounds(37, 119, 164, 3);
		lineBatting.setIcon(new ImageIcon(imgunderLine));
		
		linePitching.setBounds(37, 254, 164, 3);
		linePitching.setIcon(new ImageIcon(imgunderLine));
		
		lineFielding.setBounds(37, 390, 164, 3);
		lineFielding.setIcon(new ImageIcon(imgunderLine));
		
		
		JLabel lblBorderlayout = new JLabel("");
		lblBorderlayout.setBounds(16,16, 968, 483);
		menuPanel.add(lblBorderlayout);
		lblBorderlayout.setIcon(new ImageIcon(imgBorder));
		
		panelBodyContainer.setBackground(Color.LIGHT_GRAY);
		panelBodyContainer.setBounds(200, 0, 1300, 600);
		add(panelBodyContainer);
		panelBodyContainer.setLayout(null);
		
		panelBodyContainer.setLayout(c1);
		panelBodyContainer.add(batting, "1");

		
		panelBodyContainer.add(fielding,"2");
		panelBodyContainer.add(pitching, "3");
    	c1.show(panelBodyContainer, "1");
    	menuPanel.add(lineBatting);


	
		btnBattingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "1");
				menuPanel.add(lineBatting);
				menuPanel.remove(linePitching);
				menuPanel.remove(lineFielding);
				menuPanel.repaint();
	
			}
		});
		
		btnFieldingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "2");
				menuPanel.remove(lineBatting);
				menuPanel.remove(linePitching);
				menuPanel.add(lineFielding);
				menuPanel.repaint();
	
			}
		});
		
		btnPitchingStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				c1.show(panelBodyContainer, "3");
				menuPanel.remove(lineBatting);
				menuPanel.add(linePitching);
				menuPanel.remove(lineFielding);
				menuPanel.repaint();
	
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
