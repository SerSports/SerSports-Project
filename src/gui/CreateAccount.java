package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import database.User;


/**
used http://best-programming-tricks.blogspot.com/2011/07/how-to-add-action-mouse-listener-in.html for mouse listener
*/

public class CreateAccount extends JPanel {
	private ModifiedJTextField textUsername = new ModifiedJTextField();
	private ModifiedJTextField textPassword = new ModifiedJTextField();
	private ModifiedJTextField textFirstName = new ModifiedJTextField();
	private ModifiedJTextField textLastname = new ModifiedJTextField();
	private ModifiedJTextField textAge = new ModifiedJTextField();
	protected ModifiedJButtonStyle1 btnCreateNewAccount = new ModifiedJButtonStyle1("Create Account");
	protected JButton backButton = new JButton();
	protected Image backButtonImage = new ImageIcon(this.getClass().getResource("/images/Arrow.png")).getImage();
	private static final boolean debugOn = true;
	MainGUI main = null;
	protected JLabel logo = new JLabel("");
	

	/**
	 * Create the panel.
	 */
    
    private void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
	public CreateAccount(MainGUI mainGuiObj) {	
		setBackground(new Color(47, 52, 64));
		setPreferredSize(new Dimension(1000, 650));
		setLayout(null);
		this.main = mainGuiObj;
		Image backButtonImage = new ImageIcon(this.getClass().getResource("/images/Arrow.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBounds(340, 165, 320, 320);
		add(panel);
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(47, 52, 64));
		textUsername.setBounds(114, 33, 200, 28);
		panel.add(textUsername);
		textUsername.setText("User Name");
		textUsername.setColumns(10);
		textPassword.setBounds(114, 73, 200, 28);
		panel.add(textPassword);
		
		textPassword.setText("Password");
		textPassword.setColumns(10);
		textFirstName.setBounds(114, 113, 200, 28);
		panel.add(textFirstName);
		
		textFirstName.setText("First Name");
		textFirstName.setColumns(10);
		textLastname.setBounds(114, 153, 200, 28);
		panel.add(textLastname);
		
		textLastname.setText("Last Name");
		textLastname.setColumns(10);
		textAge.setBounds(114, 193, 200, 28);
		panel.add(textAge);
		
		textAge.setText("Age");
		textAge.setColumns(10);
		btnCreateNewAccount.setBounds(148, 237, 140, 28);
		panel.add(btnCreateNewAccount);
		btnCreateNewAccount.setActionCommand("btnCreateNewAccount");
		backButton.setBounds(6, 96, 87, 87);
		panel.add(backButton);
		backButton.setIcon(new ImageIcon(backButtonImage));
		backButton.setActionCommand("backButton");
		backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setContentAreaFilled(false);	
		
			backButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
						main.showLoginGUI();
				}
			});

		btnCreateNewAccount.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			debug("you clicked Create New Account");
    			// Authenticate User
    			User user = User.newUser(textUsername.getText(), textPassword.getText(), 
    									 textFirstName.getText(), textLastname.getText(), 
    									 Integer.valueOf(textAge.getText()));
    			if (user != null) {
    				debug("your information is submitted");
    				main.loadUserInfoIntoControls();
    				main.showApplicationGUI();
    				debug("new application window should pop up");
    				
    			} else {
    		        JOptionPane.showMessageDialog(null, "Unable to create user!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
    			}
    		}
    	});
		
		
		/**
		 *  Listener used to transition back to the Login screen
		 */		
	
	}
	}