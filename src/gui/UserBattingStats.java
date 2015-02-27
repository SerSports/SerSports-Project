package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UserBattingStats extends JPanel {
	private JTextField txtGP;
	private JTextField txtAB;
	private JTextField txtH;
	private JTextField txtRBI;
	private JTextField txtb_1;
	private JTextField txtb_2;
	private JTextField txtb_3;
	private JTextField txtRuns;
	private JTextField txtSB;
	private JTextField txtHR;
	private JTextField txtSO;
	private JTable table;
	private JTextField textDate;

	/**
	 * Create the panel.
	 */
	public UserBattingStats() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(21, 124, 119, 16);
		add(lblYouAre);
		
		txtGP = new JTextField();
		txtGP.setText("Games Played");
		txtGP.setBounds(245, 121, 111, 22);
		add(txtGP);
		txtGP.setColumns(10);
		
		txtAB = new JTextField();
		txtAB.setText("AB");
		txtAB.setColumns(10);
		txtAB.setBounds(368, 118, 77, 28);
		add(txtAB);
		
		txtH = new JTextField();
		txtH.setText("H");
		txtH.setColumns(10);
		txtH.setBounds(456, 118, 77, 28);
		add(txtH);
		
		txtRBI = new JTextField();
		txtRBI.setText("RBI");
		txtRBI.setColumns(10);
		txtRBI.setBounds(545, 118, 77, 28);
		add(txtRBI);
		
		txtb_1 = new JTextField();
		txtb_1.setText("1B");
		txtb_1.setColumns(10);
		txtb_1.setBounds(640, 118, 77, 28);
		add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setText("2B");
		txtb_2.setColumns(10);
		txtb_2.setBounds(740, 118, 77, 28);
		add(txtb_2);
		
		txtb_3 = new JTextField();
		txtb_3.setText("3B");
		txtb_3.setColumns(10);
		txtb_3.setBounds(829, 118, 77, 28);
		add(txtb_3);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(918, 118, 77, 28);
		add(txtRuns);
		
		txtSB = new JTextField();
		txtSB.setText("SB");
		txtSB.setColumns(10);
		txtSB.setBounds(1010, 118, 51, 28);
		add(txtSB);
		
		txtHR = new JTextField();
		txtHR.setText("HR");
		txtHR.setColumns(10);
		txtHR.setBounds(1073, 118, 51, 28);
		add(txtHR);
		
		txtSO = new JTextField();
		txtSO.setText("SO");
		txtSO.setColumns(10);
		txtSO.setBounds(1147, 118, 51, 28);
		add(txtSO);
		
		JButton SubmitBattingStats = new JButton("Submit");
		SubmitBattingStats.setBounds(580, 181, 117, 29);
		add(SubmitBattingStats);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);
		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date","GP","AB","H","RBI","1B","2B","3B","Runs","SB","HR","SO"}));
		scrollPane.setViewportView(table);
		
		textDate = new JTextField();
		textDate.setText("Date");
		textDate.setColumns(10);
		textDate.setBounds(140, 118, 92, 28);
		add(textDate);
		
		


	}
}

