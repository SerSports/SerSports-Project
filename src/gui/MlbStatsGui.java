
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


	/**
	 * Create the panel.
	 */
	public MlbStatsGui() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		getDBconnection();
		getResultsSet();
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(581, 159, 117, 29);
		add(btnNewButton);
		
		txtEnterNameteamPosition = new JTextField();
		txtEnterNameteamPosition.setText("Enter name,team, position ");
		txtEnterNameteamPosition.setBounds(479, 118, 320, 28);
		add(txtEnterNameteamPosition);
		txtEnterNameteamPosition.setColumns(10);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 259, 478, 246);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
		
		JButton btnSeePlayerStats = new JButton("See Player Stats");
		btnSeePlayerStats.setBounds(422, 517, 200, 50);
		add(btnSeePlayerStats);
		
		JButton btnComapreToPlayer = new JButton("Compare to Player");
		btnComapreToPlayer.setBounds(653, 517, 200, 50);
		add(btnComapreToPlayer);

		


	}


	private void getResultsSet() {
		// TODO Auto-generated method stub
		
	}


	private void getDBconnection() {
		// TODO Auto-generated method stub
		
	}
}
