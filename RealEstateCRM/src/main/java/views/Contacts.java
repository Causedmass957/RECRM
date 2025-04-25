package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Contacts {

	private JFrame frmContacts;
	private JTextField textFieldName;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contacts window = new Contacts();
					window.frmContacts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Contacts() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContacts = new JFrame();
		frmContacts.setTitle("Contacts");
		frmContacts.setBounds(100, 100, 582, 664);
		frmContacts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmContacts.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnMenu);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmHome);
		
		JMenuItem mntmContacts = new JMenuItem("Contacts");
		mntmContacts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmContacts);
		
		JMenuItem mntmMemos = new JMenuItem("Memos");
		mntmMemos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmMemos);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMenu.add(mntmLogOut);
		
		JList listMemo = new JList();
		listMemo.setVisibleRowCount(20);
		listMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhoneNumber.setEditable(false);
		textFieldPhoneNumber.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox comboBoxRole = new JComboBox();
		comboBoxRole.setModel(new DefaultComboBoxModel(new String[] {"", "Agent", "Broker", "Client"}));
		comboBoxRole.setToolTipText("");
		comboBoxRole.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnEditContact = new JButton("Edit Contact");
		btnEditContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frmContacts.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(163)
							.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAddContact, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnEditContact, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnDeleteContact, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(listMemo, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldEmail, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
											.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldPhoneNumber, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
											.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
											.addComponent(comboBoxRole, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblContacts, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(listMemo, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblPhoneNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblRole, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxRole, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddContact, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		frmContacts.getContentPane().setLayout(groupLayout);
	}

}
