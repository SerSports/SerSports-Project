import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Help extends JPanel {
	private JTextField txtTypeQuestion;

	/**
	 * Create the panel.
	 */
	public Help() {
		setLayout(null);
		
		JLabel logo = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		logo.setBounds(175, 6, 100, 100);
		add(logo);
		
		JLabel lblYouAre = new JLabel("FAQ & Help");
		lblYouAre.setBounds(201, 118, 80, 16);
		add(lblYouAre);
		
		txtTypeQuestion = new JTextField();
		txtTypeQuestion.setText("Enter Search here..");
		txtTypeQuestion.setBounds(166, 136, 134, 28);
		add(txtTypeQuestion);
		txtTypeQuestion.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(307, 137, 117, 29);
		add(btnNewButton);
		
	}
}
