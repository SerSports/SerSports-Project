import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


public class MainGUI extends JFrame {
    
    public MainGUI() {
        
        setTitle("SERSports");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
        HomePageGUI jp1 = new HomePageGUI();
        UserGUIStats jp2 = new UserGUIStats();
        BrowseLocalPlayers jp3 = new BrowseLocalPlayers();
        MlbStatsGui jp4 = new MlbStatsGui();
        Help jp5 = new Help();
        JPanel jp6 = new JPanel();
        JLabel label2 = new JLabel();
        label2.setText("You are in area of Tab2");
        jp2.add(label2);
        jtp.addTab("Home", jp1);
        jtp.addTab("User Stats", jp2);
        jtp.addTab("Browse Local Players", jp3);
        jtp.addTab("Choose MLB Players", jp4);
        jtp.addTab("Help", jp5);
        jtp.addTab("Contact Us", jp6);
        
    }
    public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}