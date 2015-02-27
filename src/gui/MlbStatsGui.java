
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class MlbStatsGui extends JPanel {
	private JTextField txtEnterNameteamPosition;
	private JTable table;
	private JTextField txtLastName;
	private JTextField txtTeam;


	/**
	 * Create the panel.
	 */
	public MlbStatsGui() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		getDBconnection();
		getResultsSet();
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
		JButton SubmitPlayerSearchButton = new JButton("Submit");
		SubmitPlayerSearchButton.setBounds(581, 234, 117, 29);
		add(SubmitPlayerSearchButton);
		SubmitPlayerSearchButton.setActionCommand("SubmitPlayerSearchButton");
		SubmitPlayerSearchButton.setBackground(new Color(255,237,203));
	    //getContentPane().add(SubmitPlayerSearchButton);
		
		txtEnterNameteamPosition = new JTextField();
		txtEnterNameteamPosition.setText("First Name");
		txtEnterNameteamPosition.setBounds(549, 118, 180, 29);
		add(txtEnterNameteamPosition);
		txtEnterNameteamPosition.setColumns(10);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 288, 478, 246);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team"/* "Position" */}));
		scrollPane.setViewportView(table);
		
		JButton btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(421, 594, 200, 50);
		add(btnSeePlayerStats);
		
		JButton btnComapreToPlayer = new JButton("Compare to Player");
		btnComapreToPlayer.setBounds(656, 594, 200, 50);
		add(btnComapreToPlayer);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last Name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(549, 153, 180, 28);
		add(txtLastName);
		
		txtTeam = new JTextField();
		txtTeam.setText("Team");
		txtTeam.setColumns(10);
		txtTeam.setBounds(549, 193, 180, 28);
		add(txtTeam);

	}


	private void getResultsSet() {
		// TODO Auto-generated method stub
		
	}


	private void getDBconnection() {
		// TODO Auto-generated method stub
		
	}
}
