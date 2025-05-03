package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.Contact;
import com.example.utils.Session;
import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ContactsJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldName;
	private JDateChooser dateChooser;
	
	private boolean isEditMode = false;


	
	/**
	 * Create the frame.
	 */
	public ContactsJ(Contact contact) {
	    setTitle("Contacts");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Important so main app stays open
	    setBounds(100, 100, 600, 641);
	    setJMenuBar(MenuNavigation.createMenuBar());
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//click event - delete contact
		JButton btnDeleteContact = new JButton("All Contacts");
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session.navigateTo(new AllContacts());
			}
		});
		btnDeleteContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//click event - add contact
		//JButton btnAddContact = new JButton("Add Contact");
		//btnAddContact.addActionListener(new ActionListener() {
		//	public void actionPerformed(ActionEvent e) {
		//	}
		//});
		//btnAddContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
						
		JLabel lblContacts = new JLabel("Contact");
		lblContacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		//JList listContacts = new JList();
		//listContacts.setVisibleRowCount(20);
		//listContacts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//JLabel lblRole = new JLabel("Role");
		//lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setEnabled(false);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumber.setEnabled(false);
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldName.setEnabled(false);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblDob = new JLabel("Dat of birth");
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setEnabled(false);
		
		setContactMode(contact);//click event - edit contact

		JButton btnEditContact = new JButton();
		if(contact != null) {
			isEditMode = false;
			btnEditContact.setText("Edit Contact");
		} else {
			btnEditContact.setText("Save Contact");
		}
				
		btnEditContact.addActionListener(e -> {
		    if (!isEditMode) {
		    	enableEditFields(); // enable fields for editing
		        btnEditContact.setText("Confirm Contact");
		        isEditMode = true;
		    } else {
		        try {
		        	String jsonBody = new String();
		            HttpURLConnection con;
		            if (contact == null) {
		                con = Session.createConnection("http://localhost:9015/contact/" + Session.getLoggedInUser(), "POST");
			            jsonBody = setContactJson( textFieldName.getText(), textFieldPhoneNumber.getText(), dateChooser.getDate(), textFieldEmail.getText());
		            } else {
		                con = Session.createConnection("http://localhost:9015/contact/edit/contact/"+ Session.getLoggedInUser() + "/" + contact.getContactId(), "PUT"); con.setDoOutput(true);
			            jsonBody = setContactJsonEdit(contact.getContactId(), textFieldName.getText(), textFieldPhoneNumber.getText(), dateChooser.getDate(), textFieldEmail.getText());
		            }		           

		            try (java.io.OutputStream os = con.getOutputStream()) {
		                byte[] input = jsonBody.getBytes("utf-8");
		                os.write(input, 0, input.length);
		            }

		            int code = con.getResponseCode();
		            if (code == 201 || code == 202) {
		                JOptionPane.showMessageDialog(null, "Contact saved");
		                Session.navigateTo(new AllContacts());
		            } else {
		                JOptionPane.showMessageDialog(null, "Contact not saved");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        isEditMode = false;
		        btnEditContact.setText("Edit Contact");
		    }
		});
		      
		btnEditContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//JComboBox comboBoxRole = new JComboBox();
		//comboBoxRole.setToolTipText("");
		//comboBoxRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(135)
							.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							//.addComponent(listContacts, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								//.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								//.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							//.addComponent(btnAddContact, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnEditContact, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDeleteContact, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		)));
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						//.addComponent(listContacts, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(textFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						//.addComponent(btnAddContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void enableEditFields() {
		textFieldName.setEnabled(true);
	    textFieldEmail.setEnabled(true);
	    textFieldPhoneNumber.setEnabled(true);
	    dateChooser.setEnabled(true);		
	}

	public void setContactMode(Contact contact) {
		if(contact == null) {
			textFieldName.setEnabled(true);
	        textFieldEmail.setEnabled(true);
	        textFieldPhoneNumber.setEnabled(true);
	        dateChooser.setEnabled(true);
		} else if (contact != null) { //view
	        textFieldName.setText(contact.getContactName());
	        textFieldEmail.setText(contact.getContactEmail());
	        textFieldPhoneNumber.setText(contact.getContactPhone());
	        dateChooser.setDate(Date.from(contact.getDob().atStartOfDay(ZoneId.systemDefault()).toInstant()));
	        Session.setActiveContactId(contact.getContactId());
		}
	}
	
	public String setContactJson(String contactName, String phone, Date dob, String email) {
		String jsonObject = "{"
                + "\"contactName\": \"" + contactName + "\","
                + "\"dob\": \"" + dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() + "\"," //backend only supports localdate objects
                + "\"contactPhone\": \"" + phone + "\","
                + "\"contactEmail\": \"" + email + "\""
                + "}";;
		
		return jsonObject;
	}
	
	public String setContactJsonEdit(int id,String contactName, String phone, Date dob, String email) {
		String jsonObject = "{"
                + "\"contactId\": \"" + id + "\","
                + "\"contactName\": \"" + contactName + "\","
                + "\"dob\": \"" + dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() + "\"," //backend only supports localdate objects
                + "\"contactPhone\": \"" + phone + "\","
                + "\"contactEmail\": \"" + email + "\""
                + "}";;
		
		return jsonObject;
	}

}
