package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 * Defines the style of all buttons used in the application
 * 
 * @author SerSports
 */
public class ModifiedJButtonStyle1 extends JButton
{
	
	private static final long serialVersionUID = 1027849412868720945L;
	
	public ModifiedJButtonStyle1(String text)
	{
		super(text);
		setBorder(new LineBorder(new Color(244, 229, 192), 1));
		setContentAreaFilled(false);
		setForeground(new Color(244, 229, 192));
		setFont(new Font("Helvetica", Font.PLAIN, 14));
	}
	
}
