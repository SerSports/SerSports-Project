
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;


public class BrowseLocalPlayers extends JPanel {
	private JTextField txtDisplaySqlTable;
	private JTextField txtEnterNameteamPosition;

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
		
		txtDisplaySqlTable = new JTextField();
		txtDisplaySqlTable.setText("Display SQL Table");
		txtDisplaySqlTable.setColumns(10);
		txtDisplaySqlTable.setBounds(433, 286, 289, 59);
		add(txtDisplaySqlTable);
		
		txtEnterNameteamPosition = new JTextField();
		txtEnterNameteamPosition.setText("Enter name,team, position, city,state, etc.");
		txtEnterNameteamPosition.setBounds(418, 118, 320, 28);
		add(txtEnterNameteamPosition);
		txtEnterNameteamPosition.setColumns(10);
		


	}
}
