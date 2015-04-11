package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textFirstName;
	private JTextField textLastname;
	private JTextField textAge;
	protected JButton btnCreateNewAccount;
	protected JButton backButton = new JButton();
	protected Image backButtonImage = new ImageIcon(this.getClass().getResource("/images/BackArrow.png")).getImage();
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
		textUsername.setBounds(294, 94, 134, 28);
		add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		lblUsername.setForeground(new Color(244, 229, 192));
		lblUsername.setBounds(198, 96, 84, 28);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		lblPassword.setForeground(new Color(244, 229, 192));
		lblPassword.setBounds(204, 136, 78, 26);
		add(lblPassword);
		
		textPassword = new JTextField();
		textPassword.setBounds(294, 134, 134, 28);
		add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		lblFirstName.setForeground(new Color(244, 229, 192));
		lblFirstName.setBounds(195, 176, 87, 28);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		lblLastName.setForeground(new Color(244, 229, 192));
		lblLastName.setBounds(196, 217, 86, 24);
		add(lblLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 18));
		lblAge.setForeground(new Color(244, 229, 192));
		lblAge.setBounds(248, 253, 34, 24);
		add(lblAge);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(294, 172, 134, 28);
		add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastname = new JTextField();
		textLastname.setBounds(294, 212, 134, 28);
		add(textLastname);
		textLastname.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(294, 249, 134, 28);
		add(textAge);
		textAge.setColumns(10);
		
		JButton btnCreateNewAccount = new JButton("Create Account");
		btnCreateNewAccount.setBounds(294, 289, 140, 28);
		add(btnCreateNewAccount);
		btnCreateNewAccount.setActionCommand("btnCreateNewAccount");
		
		
		/**
		 *  Back button displayed on the Create Account screen
		 *  that transitions back to the Login screen
		 */	
		backButton.setBounds(40, 40, 103, 58);
		add(backButton);
		Image backButtonImage = new ImageIcon(this.getClass().getResource("/images/BackArrow.png")).getImage();
		backButton.setIcon(new ImageIcon(backButtonImage));
		backButton.setActionCommand("backButton");
		backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setContentAreaFilled(false);	

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

	backButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
				main.showLoginGUI();
		}
	});
	
	}
			


	}
