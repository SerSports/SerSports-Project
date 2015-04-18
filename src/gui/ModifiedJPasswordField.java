package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ModifiedJPasswordField extends JPasswordField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 454885666915507107L;

	public ModifiedJPasswordField(){
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		setForeground(Color.GRAY);
		setBackground(new Color(244, 229, 192));
		setBorder(new LineBorder(Color.GRAY, 1));
		
		//new Color(244, 229, 192)
	}

}
