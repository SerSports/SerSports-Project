package gui;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldDoumentListener implements DocumentListener {
	private boolean isDirty = false;
	private ModifiedJTextField textField;
	
	public TextFieldDoumentListener(ModifiedJTextField txt){
		this.textField = txt;
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		setDirty(true);
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		setDirty(true);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		setDirty(false);
		
	}

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
}
