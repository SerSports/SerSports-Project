package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
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
	//protected ImageIcon arrow = new ImageIcon(CreateAccount.class.getResource("/images/BackArrow.png"));
	//protected JButton backButton = new JButton(arrow);
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
		
		//Button with Image
		logo.setBounds(0, 0, 103, 58);
		this.add(logo);
		Image img = new ImageIcon(this.getClass().getResource("/images/BackArrow.png")).getImage();
		logo.setIcon(new ImageIcon(img));
		mouseactionlabel();
		
		/**
		 *  Back button displayed on the Create Account screen
		 *  that transitions back to the Login screen
		 */
		/*
		backButton.setBounds(20, 20, 103, 58);
		add(backButton);
		backButton.setActionCommand("backButton");*/
		
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
    				main.ShowMainGUI();
    				debug("new application window should pop up");
    				
    			} else {
    		        JOptionPane.showMessageDialog(null, "Unable to create user!", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
    			}
    		}
    	});
		

			
		/**
		 *  Listener used to transition back to the Login screen
		 */
		/*backButton.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent arg0){
    				main.ShowLoginGUI();
    		}
    	});*/
		
		
	}
	void mouseactionlabel(){
		logo.addMouseListener(new MouseListener()
		{
		public void mouseClicked(MouseEvent arg0) {
			main.ShowLoginGUI();
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseReleased(MouseEvent arg0) {
		}
		});
		}
}
