package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import database.User;

public class CreateAccount extends JPanel {
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textFirstName;
	private JTextField textLastname;
	private JTextField textAge;
	protected JButton btnCreateNewAccount;
	private static final boolean debugOn = true;
	MainGUI main = null;

	/**
	 * Create the panel.
	 */
    
    private void debug(String message) {
        if (debugOn){
            System.out.println("debug: " + message);
        }
    }
	public CreateAccount(MainGUI mainGuiObj) {	
		setLayout(null);
		this.main = mainGuiObj;
		textUsername = new JTextField();
		textUsername.setBounds(135, 65, 134, 28);
		add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(39, 71, 75, 16);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(39, 121, 61, 16);
		add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(135, 115, 134, 28);
		add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(39, 178, 86, 16);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(39, 219, 86, 16);
		add(lblLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(39, 259, 61, 16);
		add(lblAge);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(135, 172, 134, 28);
		add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastname = new JTextField();
		textLastname.setBounds(135, 213, 134, 28);
		add(textLastname);
		textLastname.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(135, 253, 134, 28);
		add(textAge);
		textAge.setColumns(10);
		
		JButton btnCreateNewAccount = new JButton("Create Account");
		btnCreateNewAccount.setBounds(151, 327, 140, 28);
		add(btnCreateNewAccount);
		btnCreateNewAccount.setActionCommand("btnCreateNewAccount");
		
		btnCreateNewAccount.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    			debug("you clicked Create New Account");
    			// Authenticate User
    			User user = User.newUser(textUsername.getText(), textPassword.getText(), 
    									 textFirstName.getText(), textLastname.getText(), 
    									 Integer.valueOf(textAge.getText()));
    			if (user != null) {
    				debug("you're information is submitted");
    				main.loadUserInfoIntoControls();
    				main.ShowMainGUI();
    				debug("new application window should pop up");
    				
    			} else {
    		        JOptionPane.showMessageDialog(null, "Unable to create user!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
    			}
    		}
    	});
	}
}