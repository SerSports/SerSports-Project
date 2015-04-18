package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ModifiedJTextField extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 454885666915507107L;

	public ModifiedJTextField(){
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		setForeground(Color.GRAY);
		setBackground(Color.white);
		setBorder(new LineBorder(Color.GRAY, 1));
		
		//new Color(244, 229, 192)
	}

}
