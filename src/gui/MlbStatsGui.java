package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MlbStatsGui extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MlbStatsGui frame = new MlbStatsGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MlbStatsGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Batting");
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnFielding = new JButton("Fielding");
		btnFielding.setBounds(174, 11, 89, 23);
		contentPane.add(btnFielding);
		
		JButton btnBatting = new JButton("Fielding");
		btnBatting.setBounds(335, 11, 89, 23);
		contentPane.add(btnBatting);
		
		table = new JTable();
		table.setBounds(10, 107, 414, 120);
		contentPane.add(table);
		
		JLabel lblPlayerName = new JLabel("Player Name");
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setBounds(174, 72, 89, 23);
		contentPane.add(lblPlayerName);
	}
}
