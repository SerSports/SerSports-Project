
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


public class MLBPitchingStats extends JPanel {
	private JTextField txtGP;
	private JTextField txtW;
	private JTextField txtL;
	private JTextField txtERA;
	private JTextField txtSaves;
	private JTextField txtHits;
	private JTextField txtHolds;
	private JTextField txtRuns;
	private JTextField txtHBP;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MLBPitchingStats() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		/*JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);*/
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);
		

		table = new JTable(new DefaultTableModel(null, new Object[]{"GP", "W", "L","ERA","SAVES","HITS","HOLDS","RUNS","HBP"}));
		scrollPane.setViewportView(table);

		
		


	}
}

