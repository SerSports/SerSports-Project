package gui;
import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


public class HomePageGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePageGUI() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);

		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(6, 6, 100, 100);
		add(logo);*/
		
		JLabel lblYouAre = new JLabel("You are");
		lblYouAre.setBounds(616, 189, 47, 16);
		add(lblYouAre);
		
		JLabel label = new JLabel("20");
		label.setBounds(675, 189, 16, 16);
		add(label);
		
		JLabel lblPercent = new JLabel("percent like");
		lblPercent.setBounds(588, 217, 74, 16);
		add(lblPercent);
		
		JLabel lblInsertPlayersName = new JLabel("Insert Players name");
		lblInsertPlayersName.setBounds(669, 217, 122, 16);
		add(lblInsertPlayersName);
		
	}
}
