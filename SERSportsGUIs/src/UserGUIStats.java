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

public class UserGUIStats extends JFrame {
	private JTextField txtUsername;
	private JTextField txtAverage;
	private JTextField txtAb;
	private JTextField txtb;
	private JTextField txtb_1;
	private JTextField txtb_2;
	private JTextField txtRuns;
	private JTextField txtSo;
	private JTextField txtSos;
	private JTextField txtBb;
	private JTextField txtNeedToAdd;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUIStats frame = new UserGUIStats();
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
	public UserGUIStats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 517);
		getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Date");
		txtUsername.setBounds(120, 128, 52, 20);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
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
		
		JLabel lblUserStats = new JLabel("User Stats");
		lblUserStats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 24));
		lblUserStats.setBounds(318, 45, 112, 20);
		getContentPane().add(lblUserStats);
		
		JLabel lblEnterDateStats = new JLabel("Enter Date Stats:");
		lblEnterDateStats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblEnterDateStats.setBounds(10, 130, 98, 17);
		getContentPane().add(lblEnterDateStats);
		
		txtAverage = new JTextField();
		txtAverage.setText("Average");
		txtAverage.setColumns(10);
		txtAverage.setBounds(184, 128, 64, 20);
		getContentPane().add(txtAverage);
		
		txtAb = new JTextField();
		txtAb.setText("AB");
		txtAb.setColumns(10);
		txtAb.setBounds(260, 128, 31, 20);
		getContentPane().add(txtAb);
		
		txtb = new JTextField();
		txtb.setText("1B");
		txtb.setColumns(10);
		txtb.setBounds(303, 128, 31, 20);
		getContentPane().add(txtb);
		
		txtb_1 = new JTextField();
		txtb_1.setText("2B");
		txtb_1.setColumns(10);
		txtb_1.setBounds(346, 128, 31, 20);
		getContentPane().add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setText("3B");
		txtb_2.setColumns(10);
		txtb_2.setBounds(389, 128, 31, 20);
		getContentPane().add(txtb_2);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(432, 128, 52, 20);
		getContentPane().add(txtRuns);
		
		txtSo = new JTextField();
		txtSo.setText("SO");
		txtSo.setColumns(10);
		txtSo.setBounds(493, 128, 31, 20);
		getContentPane().add(txtSo);
		
		txtSos = new JTextField();
		txtSos.setText("SOS");
		txtSos.setColumns(10);
		txtSos.setBounds(536, 128, 31, 20);
		getContentPane().add(txtSos);
		
		txtBb = new JTextField();
		txtBb.setText("BB");
		txtBb.setColumns(10);
		txtBb.setBounds(579, 126, 31, 23);
		getContentPane().add(txtBb);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(622, 128, 89, 23);
		getContentPane().add(btnSubmit);
		
		txtNeedToAdd = new JTextField();
		txtNeedToAdd.setText("Need to add SQL TABLE");
		txtNeedToAdd.setColumns(10);
		txtNeedToAdd.setBounds(316, 295, 125, 20);
		getContentPane().add(txtNeedToAdd);
		
		//http://www.tutorialspoint.com/javaexamples/jdbc_resultset.htm
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(648, 449, 89, 23);
		getContentPane().add(btnDone);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 18, 100, 100);
		getContentPane().add(label);
	}
}
