
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BrowseLocalPlayers extends JPanel {
	private JTextField txtEnterNameteamPosition;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public BrowseLocalPlayers() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(528, 6, 100, 100);
		add(logo);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(519, 181, 117, 29);
		add(btnNewButton);
		
		txtEnterNameteamPosition = new JTextField();
		txtEnterNameteamPosition.setText("Enter name,team or position");
		txtEnterNameteamPosition.setBounds(418, 118, 320, 28);
		add(txtEnterNameteamPosition);
		txtEnterNameteamPosition.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(343, 222, 480, 181);
		add(scrollPane);
		
		table = new JTable(new DefaultTableModel(null, new Object[]{"First Name", "Last Name", "Team", "Position" }));
		scrollPane.setViewportView(table);
		
		

	}
}
