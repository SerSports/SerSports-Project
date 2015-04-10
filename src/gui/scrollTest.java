package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class scrollTest extends JPanel {

	/**
	 * Create the panel.
	 */
	public scrollTest() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1300, 600);
		add(scrollPane);

	}

}
