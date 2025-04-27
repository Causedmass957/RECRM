package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RegisterJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldUserID;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textFieldPhoneNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterJ frame = new RegisterJ();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 964);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblRegistrationPage = new JLabel("Registration page");
		lblRegistrationPage.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLastName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
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
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox comboBoxRole = new JComboBox();
		comboBoxRole.setToolTipText("");
		comboBoxRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JSeparator separator_1_1_1 = new JSeparator();
		
		JSeparator separator_1_1_1_1 = new JSeparator();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator_1_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(107)
							.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblRegistrationPage, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserid, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUserID, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE))
					.addGap(87))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(lblRegistrationPage, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblLastName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
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
					.addGap(11)
					.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
		
		btnRegister.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 // Validate form
                String firstName = textFieldFirstName.getText();
                String lastName = textFieldLastName.getText();
                String email = textFieldEmail.getText();
                String userID = textFieldUserID.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(passwordField_1.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    return;
                }
                
                User newUser = new User(firstName + " " + lastName, email, password, confirmPassword);

                //TODO:: Put in code to save user information into Database

            }
        });
		
	}

}
