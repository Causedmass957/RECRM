package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MemoDetails {

	private JFrame frmMemoDetails;
	private JTextField textFieldMemoTitle;
	private JTextField textFieldCreatedFor;
	private JTextField textFieldCreatedBy;
	private JTextField textFieldMemoID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoDetails window = new MemoDetails();
					window.frmMemoDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemoDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemoDetails = new JFrame();
		frmMemoDetails.setTitle("Memo Details");
		frmMemoDetails.setBounds(100, 100, 573, 749);
		frmMemoDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMemoDetails.setJMenuBar(menuBar);
		
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
		
		JLabel lblMemoDetails = new JLabel("Memo Details");
		lblMemoDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemoDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("Memo ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCreatedBy = new JLabel("Created By:");
		lblCreatedBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblCreatedFor = new JLabel("Created For:");
		lblCreatedFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblTitle = new JLabel("Memo Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMemoContent = new JLabel("Memo Content:");
		lblMemoContent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextPane textPaneMemoContent = new JTextPane();
		textPaneMemoContent.setEditable(false);
		
		textFieldMemoTitle = new JTextField();
		textFieldMemoTitle.setEnabled(false);
		textFieldMemoTitle.setEditable(false);
		textFieldMemoTitle.setColumns(10);
		
		textFieldCreatedFor = new JTextField();
		textFieldCreatedFor.setEnabled(false);
		textFieldCreatedFor.setEditable(false);
		textFieldCreatedFor.setColumns(10);
		
		textFieldCreatedBy = new JTextField();
		textFieldCreatedBy.setEnabled(false);
		textFieldCreatedBy.setEditable(false);
		textFieldCreatedBy.setColumns(10);
		
		textFieldMemoID = new JTextField();
		textFieldMemoID.setEnabled(false);
		textFieldMemoID.setEditable(false);
		textFieldMemoID.setColumns(10);
		
		JButton btnEditMemo = new JButton("Edit Memo");
		btnEditMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSaveMemo = new JButton("Save Memo");
		btnSaveMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frmMemoDetails.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(139)
							.addComponent(lblMemoDetails, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblCreatedBy, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCreatedFor, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMemoContent, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPaneMemoContent, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
								.addComponent(textFieldMemoTitle)
								.addComponent(textFieldCreatedFor, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCreatedBy, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldMemoID, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblMemoDetails, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textFieldMemoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCreatedBy, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCreatedBy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblCreatedFor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCreatedFor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldMemoTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblMemoContent, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textPaneMemoContent, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		frmMemoDetails.getContentPane().setLayout(groupLayout);
	}
}
