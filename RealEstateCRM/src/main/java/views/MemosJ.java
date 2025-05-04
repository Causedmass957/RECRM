package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.Memo;
import com.example.utils.Session;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemosJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JList<String> listMemo;
	private List<Memo> memos = new ArrayList<>();

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MemosJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 758);
		
		
		//navigation menu
		setJMenuBar(MenuNavigation.createMenuBar());
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		listMemo = new JList<>();

		listMemo.setVisibleRowCount(20);
		listMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//click event - Add Memo
		JButton btnAddMemo = new JButton("Add Memo");
		btnAddMemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemoDetailsJ memodetailsJ = new MemoDetailsJ();
				Session.navigateTo(memodetailsJ);
				
			}
		});
		btnAddMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		
		JSeparator separator_1_1 = new JSeparator();

		JLabel lblMemos = new JLabel("Memos");
		lblMemos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemos.setFont(new Font("Tahoma", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(gl_contentPane.createSequentialGroup()
		            .addGap(57)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(129)
		                    .addComponent(lblMemos, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
		                .addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
		                .addComponent(listMemo, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(189)
		                    .addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
		            .addContainerGap(57, Short.MAX_VALUE))
		);

		gl_contentPane.setVerticalGroup(
		    gl_contentPane.createParallelGroup(Alignment.LEADING)
		        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
		            .addContainerGap(93, Short.MAX_VALUE)
		            .addComponent(lblMemos, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
		            .addGap(32)
		            .addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		            .addGap(18)
		            .addComponent(listMemo, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
		            .addGap(40)
		            .addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
		            .addGap(110))
		);
		System.out.println(Session.getLoggedInUser());

		contentPane.setLayout(gl_contentPane);
		loadMemos(Session.getLoggedInUser());
	}
	
	private void loadMemos(String username) {
	    try {
	        String endpoint = "http://localhost:9015/memo/all/" + username;
	        HttpURLConnection con = Session.createConnection(endpoint, "GET");

	        int responseCode = con.getResponseCode();
	        if (responseCode == 201) {
	            BufferedReader reader = new BufferedReader(
	                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8)
	            );
	            StringBuilder response = new StringBuilder();
	            String line;

	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	            reader.close();

	            ObjectMapper mapper = new ObjectMapper();
	            Memo[] memoArray = mapper.readValue(response.toString(), Memo[].class);
	            memos = Arrays.asList(memoArray);

	            DefaultListModel<String> model = new DefaultListModel<>();
	            for (Memo memo : memos) {
	                model.addElement(memo.getMemoTitle());
	            }

	            listMemo.setModel(model);

	        } else {
	            System.out.println("Failed to fetch memos: " + responseCode);
	        }

	        con.disconnect();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
