package gui;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

public class ModifiedFocusAdapter extends FocusAdapter {
	
		//Members
	    protected JTextField txtField = new JTextField();
	    protected String caption;
	    
	    //Constructor
	    public ModifiedFocusAdapter (JTextField txt, String caption) {
	    	this.txtField = txt;
	    	this.caption = caption;	    	
	    }

	    //Methods to Override text when focus is lost or gained
	    @Override
	    public void focusGained(FocusEvent e){
	        if (txtField.getText().equals(caption)){
	        txtField.setText(""); }
	    }
	    @Override
	    public void focusLost(FocusEvent e){
	        if (txtField.getText().equals("")){
	        	txtField.setText(caption);}
	    }
	}

