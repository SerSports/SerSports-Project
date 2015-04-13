package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

public class DeletedStatisticsQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public DeletedStatisticsQ()
	{
		setPreferredSize(new Dimension(345, 424));
		setLayout(null);
		
		JLabel DeletedStatisticsA = new JLabel("<html>Once a selected statistic is deleted it can no longer be retrieved <br/> and must be re-entered if the user wishes to display it again.</html>");
		DeletedStatisticsA.setPreferredSize(new Dimension(345, 424));
		DeletedStatisticsA.setBounds(97, 116, 151, 192);
		add(DeletedStatisticsA);
		
	}
	
}
