import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ContactUs extends JPanel {
	private JTextField txtTypeQuestion;

	/**
	 * Create the panel.
	 */
	public ContactUs() {
		setLayout(null);
		setBackground(new Color(107, 185, 240));

		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(590, 6, 100, 100);
		add(logo);
		
		
		
	}
}
