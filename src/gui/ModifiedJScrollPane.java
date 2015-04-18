package gui;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class ModifiedJScrollPane extends JScrollPane {
	
public ModifiedJScrollPane(){
	setBounds(259, 187, 480, 190);
	setOpaque(false);
	getViewport().setOpaque(false);
	setBorder(new LineBorder(new Color(244, 229, 192), 1));

}
}
