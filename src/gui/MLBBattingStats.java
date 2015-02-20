
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


public class MLBBattingStats extends JPanel {
	private JTextField txtDate;
	private JTextField txtAverage;
	private JTextField txtAb;
	private JTextField txtb;
	private JTextField txtb_1;
	private JTextField txtb_2;
	private JTextField txtRuns;
	private JTextField txtSo;
	private JTextField txtSos;
	private JTextField txtBb;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MLBBattingStats() {
		setBackground(new Color(107, 185, 240));
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(589, 6, 100, 100);
		add(logo);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 235, 691, 235);
		add(scrollPane);
		

		table = new JTable(new DefaultTableModel(null, new Object[]{"Date", "Average", "AB","1B","2B","3B","Runs","SO","SOS","BB"}));
		scrollPane.setViewportView(table);

		
		


	}
}

