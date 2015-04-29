package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Displays a panel on the FAQ page containing the answer to the question
 * "Can I retrieve deleted statistics?"
 * 
 * @author SerSports
 */
public class DeletedStatisticsQ extends JPanel
{
	private static final long serialVersionUID = -1187250374218972156L;
	
	/**
	 * Creates the panel containing the answer to the question
	 */
	public DeletedStatisticsQ()
	{
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		setLayout(null);
		
		JLabel DeletedStatisticsA = new JLabel(
				"<html>Once a selected statistic is deleted it can no longer be retrieved <br/> and must be re-entered if the user wishes to display it again.</html>");
		DeletedStatisticsA.setPreferredSize(new Dimension(345, 424));
		DeletedStatisticsA.setBounds(97, 116, 151, 192);
		DeletedStatisticsA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		DeletedStatisticsA.setForeground(new Color(244, 229, 192));
		add(DeletedStatisticsA);
		
	}
	
}
