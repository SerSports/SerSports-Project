import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;


public class UserGUIStats extends JPanel {
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
	private JTextField txtDisplaySqlTable;

	/**
	 * Create the panel.
	 */
	public UserGUIStats() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(465, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("Enter a new game:");
		lblYouAre.setForeground(Color.BLACK);
		lblYouAre.setBounds(6, 124, 119, 16);
		add(lblYouAre);
		
		txtDate = new JTextField();
		txtDate.setText("01/20/1992");
		txtDate.setBounds(126, 118, 92, 28);
		add(txtDate);
		txtDate.setColumns(10);
		
		txtAverage = new JTextField();
		txtAverage.setText("Average");
		txtAverage.setColumns(10);
		txtAverage.setBounds(230, 118, 77, 28);
		add(txtAverage);
		
		txtAb = new JTextField();
		txtAb.setText("AB");
		txtAb.setColumns(10);
		txtAb.setBounds(319, 118, 77, 28);
		add(txtAb);
		
		txtb = new JTextField();
		txtb.setText("1B");
		txtb.setColumns(10);
		txtb.setBounds(408, 118, 77, 28);
		add(txtb);
		
		txtb_1 = new JTextField();
		txtb_1.setText("2B");
		txtb_1.setColumns(10);
		txtb_1.setBounds(497, 118, 77, 28);
		add(txtb_1);
		
		txtb_2 = new JTextField();
		txtb_2.setText("3B");
		txtb_2.setColumns(10);
		txtb_2.setBounds(586, 118, 77, 28);
		add(txtb_2);
		
		txtRuns = new JTextField();
		txtRuns.setText("Runs");
		txtRuns.setColumns(10);
		txtRuns.setBounds(675, 118, 77, 28);
		add(txtRuns);
		
		txtSo = new JTextField();
		txtSo.setText("SO");
		txtSo.setColumns(10);
		txtSo.setBounds(764, 118, 77, 28);
		add(txtSo);
		
		txtSos = new JTextField();
		txtSos.setText("SOS");
		txtSos.setColumns(10);
		txtSos.setBounds(853, 118, 77, 28);
		add(txtSos);
		
		txtBb = new JTextField();
		txtBb.setText("BB");
		txtBb.setColumns(10);
		txtBb.setBounds(942, 118, 77, 28);
		add(txtBb);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(457, 181, 117, 29);
		add(btnNewButton);
		
		txtDisplaySqlTable = new JTextField();
		txtDisplaySqlTable.setText("Display SQL Table");
		txtDisplaySqlTable.setColumns(10);
		txtDisplaySqlTable.setBounds(372, 286, 289, 59);
		add(txtDisplaySqlTable);
		


	}
}
