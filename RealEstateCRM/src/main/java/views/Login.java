package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.example.repository.ConnectPostgres;

public class Login {

	private JFrame frmLogin;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 431, 545);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Not a user yet? Sign up here!");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//click event, log in and end on home page
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textFieldUserName.getText();
				char[] password = passwordField.getPassword();
				String passwordString = new String(password); //convert char to string
				String query = "SELECT * FROM users WHERE username = ? AND password = ?";
				
				//TODO:: make sure users and password are the correct database names
				
				if (userName == null || userName.isEmpty() || userName.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,  "Please enter a username");
					textFieldUserName.requestFocus();
					return;
				}
				if (password == null || password.length < 1)
				{
					JOptionPane.showMessageDialog(null,  "Please enter your password");
					passwordField.requestFocus();
					return;
				}
				
				
				//
				//check user name/password vs database
				
				try (Connection conn = ConnectPostgres.getConnection();
						PreparedStatement stmt = conn.prepareStatement(query))
				{
					//set the username and password parameters in the query
					stmt.setString(1, userName);
					stmt.setString(2, passwordString);
					
					//execute the query
					try (ResultSet rs = stmt.executeQuery())
					{
						if (rs.next()) 
						{
							//login button works, and navigate to home page
							
							
								
							if (frmLogin != null)
							{
								//close login page
								frmLogin.dispose();
							}
							
							//new instance of register page
							HomeJ home = new HomeJ();
							//set register page visible
							home.setVisible(true);
							
						}
						else
						{
							System.out.println("Invalid username or password.");
						}
					}
					catch (SQLException e1)
					{
						e1.printStackTrace();
					}
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			
					
			
			}});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//click event, exit button (exit app)
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		
		
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Click event, go to registration page
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//close login page
				frmLogin.dispose();
				//new instance of register page
				RegisterJ register = new RegisterJ();
				//set register page visible
				register.setVisible(true);
				
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		
		JSeparator separator_1_1 = new JSeparator();
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textFieldUserName, Alignment.LEADING)
										.addComponent(passwordField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(154))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnRegister)
					.addGap(151))
		);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
}
