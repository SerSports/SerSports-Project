package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import sersports.mlb.MlbPlayerStatistics;
import sersports.mlb.SportsStatsApi;

public class MlbStatsGui extends JFrame {

	private JPanel contentPane;
	private JTable tblStats;
	
	private String[] pitchingColumns = {"ERA", "Pitch Count", "Innings Pitched", "Balls", "Strike Outs", "Runs Earned", "On Base HR"};
	private String[] battingColumns = {"At Bat", "AVG", "Slugging", "On Base Percentage", "ISO", "RBI", "AB/HR"};
	private String[] fieldingColumns = {"Home Runs", "Stolen Bases", "HBP", "Hits", "Base on Balls" , "Fielders Choice", "Total bases"};

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

    public static int randInt(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
	
	/**
	 * Create the frame.
	 */
	public MlbStatsGui() {
		
		List<MlbPlayerStatistics> players;
		
		try {
			players = SportsStatsApi.getListOfMlbPlayerStatisticsForYear(2013);
		
			final MlbPlayerStatistics player = players.get(randInt(0, players.size()));
			
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
			
			JButton btnBatting = new JButton("Pitching");
			btnBatting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[][] pitchingData = new Object[0][6];
					Float[] returnedData = player.returnData("PITCHING");
					for (int i = 0; i < 6; i++) {
						pitchingData[0][0] = returnedData[0];
					}
					tblStats.setModel(new DefaultTableModel(pitchingData, pitchingColumns));
				}
			});
			btnBatting.setBounds(335, 11, 89, 23);
			contentPane.add(btnBatting);
			
			tblStats = new JTable();
			tblStats.setBounds(10, 107, 414, 120);
			contentPane.add(tblStats);
			
			JLabel lblPlayerName = new JLabel(player.returnFullName());
			lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlayerName.setBounds(174, 72, 89, 23);
			contentPane.add(lblPlayerName);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
