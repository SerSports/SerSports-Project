import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


public class GUIHomePageTest extends JFrame {

	protected Background background = new Background();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIHomePageTest frame = new GUIHomePageTest();
					frame.setVisible(true);
			    	frame.pack();
			    	frame.setSize(1024, 768);
			    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			    	frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIHomePageTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,780);
		setContentPane(background);

		JLabel logo = new JLabel("");
		logo.setBounds(6, 6, 141, 149);
		Image img = new ImageIcon(this.getClass().getResource("/images/Logo1.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		background.add(logo);
	}
}
