package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class DeletedStatisticsQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public DeletedStatisticsQ()
	{
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		setLayout(null);
		
		JLabel DeletedStatisticsA = new JLabel("<html>Once a selected statistic is deleted it can no longer be retrieved <br/> and must be re-entered if the user wishes to display it again.</html>");
		DeletedStatisticsA.setPreferredSize(new Dimension(345, 424));
		DeletedStatisticsA.setBounds(97, 116, 151, 192);
		DeletedStatisticsA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		DeletedStatisticsA.setForeground(new Color(244, 229, 192));
		add(DeletedStatisticsA);
		
	}
	
}
