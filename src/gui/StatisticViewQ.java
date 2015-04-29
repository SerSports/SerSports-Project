package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Displays a panel on the FAQ page containing the answer to the question
 * "Will other people be able to view my statistics?"
 * 
 * @author SerSports
 */
public class StatisticViewQ extends JPanel
{
	
	/**
	 * Creates the panel containing the answer to the question
	 */
	public StatisticViewQ()
	{
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		setLayout(null);
		
		JLabel StatisticViewA = new JLabel(
				"<html>Once you submit your statistics on the website, they will be available to view by other users on the “Browse Local Players” page. If you would like to avoid this situation, simply delete your statistics.</html>");
		StatisticViewA.setPreferredSize(new Dimension(345, 424));
		StatisticViewA.setBounds(97, 116, 151, 192);
		StatisticViewA.setForeground(new Color(244, 229, 192));
		StatisticViewA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		add(StatisticViewA);
		
	}
	
}
