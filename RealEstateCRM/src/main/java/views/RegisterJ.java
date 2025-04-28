package views;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.User;
import com.example.utils.Session;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldUserID;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textFieldRole;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJ frame = new RegisterJ();
					Session.navigateTo(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterJ() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 964);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblRegistrationPage = new JLabel("Registration page");
		lblRegistrationPage.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		
		JLabel lblUserid = new JLabel("User Name");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//userId is really username. TODO
		textFieldUserID = new JTextField();
		textFieldUserID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldUserID.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JSeparator separator_1_1_1 = new JSeparator();
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		
		//click event - register button
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 // Validate form
		        //String firstName = textFieldFirstName.getText();
		        //String lastName = textFieldLastName.getText();
		        String email = textFieldEmail.getText();
		        String userName = textFieldUserID.getText();
		        String password = new String(passwordField.getPassword());
		        String confirmPassword = new String(passwordField_1.getPassword());
		        String role = textFieldRole.getText();
		        
		        if (!password.equals(confirmPassword)) {
		            JOptionPane.showMessageDialog(null, "Passwords do not match.");
		            return;
		        }
		        
		        User newUser = new User( userName, password, role, email);
		        
		        //TODO:: Put in code to save user information into Database
		        String url = "http://localhost:9015/user/";
				try {
					HttpURLConnection con = Session.createConnection(url,"POST");
					String jsonBody = "{"
					        + "\"userName\":\"" + userName + "\","
					        + "\"email\":\"" + email + "\","
					        + "\"password\":\"" + password + "\""
							+ "\"role\":\"" + role + "\","
					        + "}";
					
					try (java.io.OutputStream os = con.getOutputStream()) {
				        byte[] input = jsonBody.getBytes("utf-8");
				        os.write(input, 0, input.length);
				    }
					
					int code = con.getResponseCode();
				    if (code == HttpURLConnection.HTTP_OK && password.equals(confirmPassword)) {
				    	Session.setLoggedInUser(userName);
				        // Successful register
				        JOptionPane.showMessageDialog(null, "Register Successful!");
				        JFrame home = new HomeJ();
				        Session.navigateTo(home);
				    } else {
				        // Login failed
				        JOptionPane.showMessageDialog(null, "Registration Failed. Please check your username and password.Try using a different email, may already be registered.");
				    }
				    
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		
		
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//click event, go back button, go to login page
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterJ.this.setVisible(false);
				
				Login loginpage = new Login();  // New instance of the login page
				loginpage.setLocationRelativeTo(null); //Center the window
				loginpage.setVisible(true); //make login frame visible
				
				//RegisterJ.this.dispose();  // Close the current registration window
				//TODO:: Fix goback button so it works
				
			}
		        });
		        
		        
			
		
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldRole = new JTextField();
		textFieldRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRole.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldRole, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserid, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUserID, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblRegistrationPage, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(separator_1_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(107)
							.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
					.addGap(87))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(lblRegistrationPage, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblUserid, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldUserID, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldRole, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(separator_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(separator_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(416))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}

}
