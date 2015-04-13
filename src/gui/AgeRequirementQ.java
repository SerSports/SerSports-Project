package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;

public class AgeRequirementQ extends JPanel
{
	
	/**
	 * Create the panel.
	 */
	public AgeRequirementQ()
	{
		setPreferredSize(new Dimension(345, 424));
		setToolTipText("");
		setLayout(null);
		
		JLabel AgeRequirementA = new JLabel("<html>The age requirement for creating an account is 13 years of age or older. A parent or guardian's approval is required for children who do not meet the age requirement.</html>");
		AgeRequirementA.setPreferredSize(new Dimension(345, 424));
		AgeRequirementA.setBounds(97, 116, 151, 192);
		add(AgeRequirementA);
		
	}
}
