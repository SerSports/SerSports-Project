import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.*;


public class Background extends JPanel {
	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public Background() {
		contentPane = new JPanel();
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 229, 192));
		panel.setBounds(0, 0, 1300, 118);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 52, 64));
		panel_1.setBounds(0, 114, 1300, 597);
		contentPane.add(panel_1);
		panel.setLayout(null);
		panel_1.setLayout(null);
	}

}
