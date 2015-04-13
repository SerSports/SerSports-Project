package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

public class StatisticViewQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public StatisticViewQ()
	{
		setPreferredSize(new Dimension(345, 424));
		setLayout(null);
		
		JLabel StatisticViewA = new JLabel("<html>Once you submit your statistics on the website, they will be available to view by other users on the “Browse Local Players” page. If you would like to avoid this situation, simply delete your statistics.</html>");
		StatisticViewA.setPreferredSize(new Dimension(345, 424));
		StatisticViewA.setBounds(97, 116, 151, 192);
		add(StatisticViewA);
		
	}
	
}
