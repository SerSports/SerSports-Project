package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import database.Database;
import database.User;


/**
used http://best-programming-tricks.blogspot.com/2011/07/how-to-add-action-mouse-listener-in.html for mouse listener
*/

public class CreateAccount extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8434810151786640652L;
	private ModifiedJTextField textUsername = new ModifiedJTextField();
	private ModifiedJTextField textPassword = new ModifiedJTextField();
	private ModifiedJTextField textFirstName = new ModifiedJTextField();
	private ModifiedJTextField textLastname = new ModifiedJTextField();
	private ModifiedJTextField textAge = new ModifiedJTextField();
	private ModifiedJTextField mdfdjtxtfldTeam = new ModifiedJTextField();
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
		
		textUsername.setBounds(60, 33, 200, 28);
		panel.add(textUsername);
		textUsername.setText("User Name");
		textUsername.addFocusListener(new ModifiedFocusAdapter(textUsername, "User Name"));
		textUsername.setColumns(10);
		
		
		textPassword.setBounds(60, 73, 200, 28);		
		textPassword.setText("Password");
		textPassword.setColumns(10);
		textPassword.addFocusListener(new ModifiedFocusAdapter(textPassword, "Password"));
		panel.add(textPassword);
		
		textFirstName.setText("First Name");
		textFirstName.setBounds(60, 113, 200, 28);
		textFirstName.setColumns(10);
		textFirstName.addFocusListener(new ModifiedFocusAdapter(textFirstName, "First Name"));
		panel.add(textFirstName);
		
		textLastname.setText("Last Name");
		textLastname.setColumns(10);
		textLastname.setBounds(60, 153, 200, 28);
		textLastname.addFocusListener(new ModifiedFocusAdapter(textLastname, "Last Name"));
		panel.add(textLastname);
		
		textAge.setBounds(60, 193, 200, 28);
		textAge.addFocusListener(new ModifiedFocusAdapter(textAge, "Age"));
		panel.add(textAge);
		textAge.setText("Age");
		textAge.setColumns(10);
		
		mdfdjtxtfldTeam.setText("Local Team");
		mdfdjtxtfldTeam.setColumns(10);
		mdfdjtxtfldTeam.setBounds(60, 233, 200, 28);
		mdfdjtxtfldTeam.addFocusListener(new ModifiedFocusAdapter(mdfdjtxtfldTeam, "Local Team"));
		panel.add(mdfdjtxtfldTeam);
		
		btnCreateNewAccount.setActionCommand("btnCreateNewAccount");
		btnCreateNewAccount.setBounds(89, 269, 140, 28);
		panel.add(btnCreateNewAccount);
		
				JLabel lblEnter = new JLabel("Create Account:");
				lblEnter.setBounds(91, 6, 138, 27);
				panel.add(lblEnter);
				lblEnter.setFont(new Font("Malayalam Sangam MN", Font.PLAIN, 20));
				lblEnter.setForeground(new Color(244, 229, 192));
				
				
		backButton.setBounds(6, 6, 87, 87);
		add(backButton);
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
    			//debug("you clicked Create New Account");
    			// get user's input
    			User user = isUniqueUser();
    			
				if (user != null) {
					main.loadUserInfoIntoControls();
					main.showApplicationGUI();
				} 
    			else {
					JOptionPane.showMessageDialog(null, "User is already being used. Please try a new username.", "InfoBox: SER SPORTS", JOptionPane.INFORMATION_MESSAGE);
				}
    		}
    	});
		
		
		/**
		 *  Listener used to transition back to the Login screen
		 */		
	
	}
	
	public User isUniqueUser(){
		//Make sure username is unique
		String sql = "SELECT COUNT(*) AS rowcount FROM " + User.getTableName() + 
				    " WHERE " + User.getFieldUserName() + " = " + "\"" + textUsername.getText() + "\"";
		ResultSet rs = Database.getResultSetFromSQL(sql);
		
		try {
			rs.next();
			int count = rs.getInt("rowcount");
			
			if(count < 1){
				User user = User.newUser(textUsername.getText(), textPassword.getText(), 
						 textFirstName.getText(), textLastname.getText(), 
						 Integer.valueOf(textAge.getText()), mdfdjtxtfldTeam.getText());
				return user;
			}
			else{
				return null;
			}
			
		} catch (SQLException e) {
			System.out.println("Issue in CreateAccount, isUniqueUser");
		}
		return null;
	}
}