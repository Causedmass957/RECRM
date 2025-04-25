package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class Memos {

	private JFrame frmMemos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memos window = new Memos();
					window.frmMemos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Memos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemos = new JFrame();
		frmMemos.setTitle("Memos");
		frmMemos.setBounds(100, 100, 585, 766);
		frmMemos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblMemos = new JLabel("Memos");
		lblMemos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemos.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JList listMemo = new JList();
		listMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		listMemo.setVisibleRowCount(20);
		
		JButton btnAddMemo = new JButton("Add Memo");
		btnAddMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnDeleteMemo = new JButton("Delete Memo");
		btnDeleteMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnEditMemo = new JButton("Edit Memo");
		btnEditMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnViewMemo = new JButton("View Memo");
		btnViewMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frmMemos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(lblMemos, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(listMemo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(separator_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(61)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnViewMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
											.addComponent(btnDeleteMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblMemos)
					.addGap(32)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(listMemo, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnViewMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(81))
		);
		frmMemos.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 240, 240));
		frmMemos.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnMenu);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mnMenu.add(mntmHome);
		mntmHome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JMenuItem mntmContacts = new JMenuItem("Contacts");
		mnMenu.add(mntmContacts);
		mntmContacts.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JMenuItem mntmMemos = new JMenuItem("Memos");
		mnMenu.add(mntmMemos);
		mntmMemos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnMenu.add(mntmLogOut);
		mntmLogOut.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
