import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import misc.MLBFieldingStats;


public class MLBPlayerProfile extends JFrame {
    
    public MLBPlayerProfile() {
        setTitle("MLB Player Profile");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp,BorderLayout.CENTER);
        

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MLBBattingStats batting = new MLBBattingStats();
        //MLBFieldingStats fielding = new MLBFieldingStats();
        MLBPitchingStats pitching = new MLBPitchingStats();
      
        jtp.addTab("Batting", batting);
        //jtp.addTab("Fielding", fielding);
        jtp.addTab("Pitching", pitching);

        
    }
    public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MLBPlayerProfile frame = new MLBPlayerProfile();
					frame.setVisible(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}