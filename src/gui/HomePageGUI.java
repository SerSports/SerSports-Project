import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomePageGUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePageGUI() {
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(175, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("You are");
		lblYouAre.setBounds(201, 118, 47, 16);
		add(lblYouAre);
		
		JLabel label = new JLabel("20");
		label.setBounds(177, 146, 16, 16);
		add(label);
		
		JLabel lblPercent = new JLabel("percent like");
		lblPercent.setBounds(203, 146, 74, 16);
		add(lblPercent);
		
		JLabel lblInsertPlayersName = new JLabel("Insert Players name");
		lblInsertPlayersName.setBounds(164, 176, 122, 16);
		add(lblInsertPlayersName);
		
	}

}
