package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Displays a panel on the FAQ page containing all abbreviations and their given
 * definitions
 * 
 * @author SerSports
 */
public class AbbreviationsQ extends JPanel
{
	private static final long serialVersionUID = -6529128873635518316L;

	/**
	* Creates the panel containing all of the abbreviations used throughout the program
	* as well as their definitions
	*/
	public AbbreviationsQ()
	{
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		setToolTipText("");
		setLayout(null);
		
		JLabel AbbreviationsA = new JLabel(
				"<html>H: Hits<br />1B: Single<br />2B: Double<br />3B: Triple<br />HR: Home Run<br />SO: Strike Out<br />AB: At-bat<br />SB: Stolen Base<br />W: Win<br />L: Loss<br />RBI: Runs Batted In<br />R: Runs<br />IP: Innings Pitched<br />S: Saves<br />HBP: Hit by Pitch<br />A: Assists<br />FPCT: Fielding Percentage<br />PO: Putouts<br />E: Error<br />GP: Games Played<br /></html>");
		AbbreviationsA.setPreferredSize(new Dimension(345, 424));
		AbbreviationsA.setBounds(54, 20, 236, 384);
		AbbreviationsA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		AbbreviationsA.setForeground(new Color(244, 229, 192));
		add(AbbreviationsA);
	}
}
