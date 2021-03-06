package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Displays a panel on the FAQ page containing the answer to the question
 * "Is there an age requirement to sign up?"
 * 
 * @author SerSports
 */
public class AgeRequirementQ extends JPanel
{
	private static final long serialVersionUID = 3282099479400601681L;
	
	/**
	 * Creates the panel containing the answer to the question
	 */
	public AgeRequirementQ()
	{
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(345, 424));
		setToolTipText("");
		setLayout(null);
		
		JLabel AgeRequirementA = new JLabel(
				"<html>The age requirement for creating an account is 13 years of age or older. A parent or guardian's approval is required for children who do not meet the age requirement.</html>");
		AgeRequirementA.setPreferredSize(new Dimension(345, 424));
		AgeRequirementA.setBounds(97, 116, 151, 192);
		AgeRequirementA.setFont(new Font("Myanmar Sangam MN", Font.PLAIN, 14));
		AgeRequirementA.setForeground(new Color(244, 229, 192));
		add(AgeRequirementA);
		
	}
}
