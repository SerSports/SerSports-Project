/*
File: 
Author:	
Date:	

Description: 

*/
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;


/**
Class:

Description:
*/
public class LocalPlayerProfile extends JFrame {
    
	/**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
    public LocalPlayerProfile() {
        setTitle("Local Player Profile");
        JTabbedPane jtp = new JTabbedPane();
        getContentPane().add(jtp,BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LocalBattingStats batting = new LocalBattingStats();
        //LocalFieldingStats fielding = new LocalFieldingStats();
        LocalPitchingStats pitching = new LocalPitchingStats();
      
        jtp.addTab("Batting", batting);
        //jtp.addTab("Fielding", fielding);
        jtp.addTab("Pitching", pitching);    
    }
    
    /**
	  Method: 
	  Inputs: 
	  Returns:

	  Description:
	*/
    public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalPlayerProfile frame = new LocalPlayerProfile();
					frame.setVisible(true);
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});    
    }
}