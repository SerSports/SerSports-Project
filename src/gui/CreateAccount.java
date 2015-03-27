package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CreateAccount extends JPanel {
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textFirstName;
	private JTextField textLastname;
	private JTextField textAge;

	/**
	 * Create the panel.
	 */
	public CreateAccount() {
		setLayout(null);
		
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
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(151, 327, 140, 28);
		add(btnCreateAccount);

	}
}
