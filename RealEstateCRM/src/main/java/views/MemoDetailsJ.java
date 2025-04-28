package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MemoDetailsJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					MemoDetailsJ frame = new MemoDetailsJ();
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
	public MemoDetailsJ() {
		setTitle("Memo Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 693);
		
		//navigation menu
		setJMenuBar(MenuNavigation.createMenuBar());
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnSaveMemo = new JButton("Save Memo");
		btnSaveMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMemoDetails = new JLabel("Memo Details");
		lblMemoDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemoDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblCreatedBy = new JLabel("Created By:");
		lblCreatedBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Memo ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(129)
							.addComponent(lblMemoDetails, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(textFieldMemoID, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblCreatedBy, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(textFieldCreatedBy, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblCreatedFor, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(textFieldCreatedFor, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(textFieldMemoTitle, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblMemoContent, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(textPaneMemoContent, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(lblMemoDetails, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textFieldMemoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblCreatedBy, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldCreatedBy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(lblCreatedFor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldCreatedFor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textFieldMemoTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblMemoContent, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(textPaneMemoContent, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
