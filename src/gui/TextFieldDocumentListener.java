package gui;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldDocumentListener implements DocumentListener {
	private boolean isDirty = false;
	
	public TextFieldDocumentListener(){
		isDirty = false;
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		isDirty = true;
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		isDirty = true;
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		isDirty = true;
		
	}

	public static boolean isDirty() {
		return isDirty;
	}
	
	public static void setDirty(){
		isDirty = false;
	}
}
