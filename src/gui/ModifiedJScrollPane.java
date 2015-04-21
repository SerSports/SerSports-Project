package gui;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ModifiedJScrollPane extends JScrollPane {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -7661079313014633413L;

public ModifiedJScrollPane(){
	setOpaque(false);
	getViewport().setOpaque(false);
	setBorder(new LineBorder(new Color(244, 229, 192), 1));

}
}
