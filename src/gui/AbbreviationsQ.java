package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

public class AbbreviationsQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public AbbreviationsQ()
	{
		setPreferredSize(new Dimension(345, 424));
		setToolTipText("");
		setLayout(null);
		
		JLabel AbbreviationsA = new JLabel(
				"<html>H: Hits<br />1B: Single<br />2B: Double<br />3B: Triple<br />HR: Home Run<br />SO: Strike Out<br />AB: At-bat<br />SB: Stolen Base<br />W: Win<br />L: Loss<br />RBI: Runs Batted In<br />R: Runs<br />IP: Innings Pitched<br />S: Saves<br />HBP: Hit by Pitch<br />A: Assists<br />FPCT: Fielding Percentage<br />PO: Putouts<br />E: Error<br />GP: Games Played<br /></html>");
		AbbreviationsA.setPreferredSize(new Dimension(345, 424));
		AbbreviationsA.setBounds(54, 52, 236, 319);
		add(AbbreviationsA);
		
	}
	
}
