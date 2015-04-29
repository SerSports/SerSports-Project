package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 * Handles all user entry fields by creating the actual text field where they enter
 * information and displaying a caption that tells the user what information goes in the
 * box. Reverts back to the default caption if the box is clicked away from or manipulated
 * 
 * @author SerSports
 */
public class ModifiedFocusAdapter extends FocusAdapter
{
	
	protected JTextField txtField = new JTextField();
	protected String caption;
	
	/**
	 * Sets the text field and caption
	 * 
	 * @param txt
	 *            Text field where the user enters whatever is required
	 * @param caption
	 *            Caption letting the user know what to enter
	 */
	public ModifiedFocusAdapter(JTextField txt, String caption)
	{
		this.txtField = txt;
		this.caption = caption;
	}
	
	@Override
	public void focusGained(FocusEvent e)
	{
		if (txtField.getText().equals(caption))
		{
			txtField.setText("");
		}
	}
	
	@Override
	public void focusLost(FocusEvent e)
	{
		if (txtField.getText().equals(""))
		{
			txtField.setText(caption);
		}
	}
}
