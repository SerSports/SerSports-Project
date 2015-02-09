import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.TextField;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HomePageGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePageGUI frame = new HomePageGUI();
					frame.setVisible(true);
					//frame.setExtendedState(frame.MAXIMIZED_BOTH);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 517);
		getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 738, 20);
		getContentPane().add(menuBar);
		
		JMenu mnContactUs = new JMenu("Home");
		menuBar.add(mnContactUs);
		
		JMenuItem mntmContactUs = new JMenuItem("Home");
		mnContactUs.add(mntmContactUs);
		
		JMenu mnUserStats = new JMenu("User Stats");
		menuBar.add(mnUserStats);
		
		JMenuItem mntmUserStats = new JMenuItem("User Stats");
		mnUserStats.add(mntmUserStats);
		
		JMenu mnBrowseLocalStats = new JMenu("Browse Local Players");
		menuBar.add(mnBrowseLocalStats);
		
		JMenuItem mntmBrowseLocalPlayers = new JMenuItem("Browse Local Players");
		mnBrowseLocalStats.add(mntmBrowseLocalPlayers);
		
		JMenu mnChooseMlbPlayers = new JMenu("Choose MLB Players");
		menuBar.add(mnChooseMlbPlayers);
		
		JMenuItem mntmChooseMlbPlayers = new JMenuItem("Choose MLB Players");
		mnChooseMlbPlayers.add(mntmChooseMlbPlayers);
		
		JMenu menu = new JMenu("Contact Us");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Contact Us");
		menu.add(menuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JMenu mnSingOut = new JMenu("Logout");
		menuBar.add(mnSingOut);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnSingOut.add(mntmLogout);
		
		JLabel lblUserStats = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		lblUserStats.setIcon(new ImageIcon(img));
		lblUserStats.setBounds(0, 19, 100, 100);
		getContentPane().add(lblUserStats);
		
		JButton btnSubmit = new JButton("Submit New Stats");
		btnSubmit.setBounds(286, 198, 179, 23);
		getContentPane().add(btnSubmit);
		
		JLabel lblInsertAthletesName = new JLabel("Insert Athletes Name");
		lblInsertAthletesName.setBounds(308, 124, 138, 23);
		getContentPane().add(lblInsertAthletesName);
		
		JLabel lblBy = new JLabel("By");
		lblBy.setBounds(328, 164, 19, 22);
		getContentPane().add(lblBy);
		
		JLabel labelforPercent = new JLabel("20");
		labelforPercent.setBounds(349, 164, 19, 22);
		getContentPane().add(labelforPercent);
		
		JLabel lblPercent = new JLabel("Percent");
		lblPercent.setBounds(369, 166, 52, 19);
		getContentPane().add(lblPercent);
		
		JLabel lblYouAreMost = new JLabel("You are most like:");
		lblYouAreMost.setBounds(317, 81, 120, 20);
		getContentPane().add(lblYouAreMost);
	}
}

