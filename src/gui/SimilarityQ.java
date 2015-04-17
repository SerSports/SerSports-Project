package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SimilarityQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public SimilarityQ()
	{
		setLayout(null);
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		JLabel SimilarityA = new JLabel("<html>All statistics <br/>that are entered by the user are taken in to account when determining the similarity between said user and an MLB player. The closer the entered statistics are to an MLB player, the higher their similarity percentage is.</html>");
		SimilarityA.setHorizontalAlignment(SwingConstants.CENTER);
		SimilarityA.setBounds(97, 98, 151, 228);
		SimilarityA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		SimilarityA.setForeground(new Color(244, 229, 192));
		add(SimilarityA);
		
	}
	
}
