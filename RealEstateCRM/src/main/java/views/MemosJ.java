package views;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.example.model.Memo;
import com.example.model.MemoGroup;
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
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

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
	private JList<Object> listMemo;
	private List<Memo> memos = new ArrayList<>();

	private JButton btnAddGroup;

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
				
				MemoDetailsJ memodetailsJ = new MemoDetailsJ(null);
				Session.navigateTo(memodetailsJ);
				
			}
		});
		btnAddMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));		
		
		JSeparator separator_1_1 = new JSeparator();

		JLabel lblMemos = new JLabel("Memos");
		lblMemos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemos.setFont(new Font("Tahoma", Font.BOLD, 30));
		listMemo.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
		    JLabel label = new JLabel();

		    if (value instanceof MemoList) {
		        MemoList item = (MemoList) value;
		        if (item.isMemo()) {
		            label.setText(item.getMemo().getMemoTitle());
		        } else if (item.isGroup()) {
		            label.setText("[Group] " + item.getGroup().getGroupName());
		            label.setFont(label.getFont().deriveFont(Font.BOLD));
		        }
		    } else {
		        label.setText("Unknown item");
		    }

		    if (isSelected) {
		        label.setOpaque(true);
		        label.setBackground(list.getSelectionBackground());
		        label.setForeground(list.getSelectionForeground());
		    }

		    return label;
		});
		
		JScrollPane scrollPane = new JScrollPane(listMemo);
		
		btnAddGroup = new JButton("Add Group");
		btnAddGroup.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddGroup.addActionListener(e -> showAddGroupDialog());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, 20, 10));
		buttonPanel.add(btnAddGroup);
		buttonPanel.add(btnAddMemo);

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
			                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
			                .addGroup(gl_contentPane.createSequentialGroup()
			                    .addGap(100)
			                    .addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
			                    .addGap(40)
			                    .addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
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
			            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
			            .addGap(40)
			            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
			                .addComponent(btnAddMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
			                .addComponent(btnAddGroup, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
			            .addGap(80))
			);

		System.out.println(Session.getLoggedInUser());

		contentPane.setLayout(gl_contentPane);
		loadMemos(Session.getLoggedInUser());
		listMemo.addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        MemoList selectedItem = (MemoList) listMemo.getSelectedValue();
		        if (selectedItem != null) {
		            if (selectedItem.isMemo()) {
		                Session.navigateTo(new MemoDetailsJ(selectedItem.getMemo()));
		            } else if (selectedItem.isGroup()) {
		                // Optional: open group editor or detail screen
		                //System.out.println("Selected group: " + selectedItem.getGroup().getGroupName());
		            	Session.navigateTo(new MemoGroupJ(selectedItem.getGroup()));
		            }
		        }
		    }
		});	
	}
	
	@SuppressWarnings("unchecked")
	private void loadMemos(String username) {
	    try {
	        DefaultListModel<Object> model = new DefaultListModel<>();
	        

	        // Load MemoGroups
	        String groupEndpoint = "http://localhost:9015/memogroup/" + username;
	        HttpURLConnection groupCon = Session.createConnection(groupEndpoint, "GET");
	        System.out.println(groupCon.getResponseCode());

	        if (groupCon.getResponseCode() == 200) {
	            BufferedReader groupReader = new BufferedReader(new InputStreamReader(groupCon.getInputStream()));
	            StringBuilder groupResponse = new StringBuilder();
	            String line;
	            while ((line = groupReader.readLine()) != null) {
		            System.out.println("JSON being sent: " + line);
	            	groupResponse.append(line);
	            }
	            groupReader.close();

	            ObjectMapper mapper = new ObjectMapper();
	            MemoGroup[] groupArray = mapper.readValue(groupResponse.toString(), MemoGroup[].class);
	            //System.out.println("JSON being sent: " + groupResponse.toString());
	            for (MemoGroup group : groupArray) {
	                model.addElement(new MemoList(group));
	            }
	            System.out.println("Loaded memo groups: " + groupArray.length);
	        }

	        groupCon.disconnect();

	        // Load Memos with no group
	        String memoEndpoint = "http://localhost:9015/memo/nogroup/" + username;
	        HttpURLConnection memoCon = Session.createConnection(memoEndpoint, "GET");

	        if (memoCon.getResponseCode() == 201) {
	            BufferedReader memoReader = new BufferedReader(new InputStreamReader(memoCon.getInputStream()));
	            StringBuilder memoResponse = new StringBuilder();
	            String line;
	            while ((line = memoReader.readLine()) != null) memoResponse.append(line);
	            memoReader.close();

	            ObjectMapper mapper = new ObjectMapper();
	            Memo[] memoArray = mapper.readValue(memoResponse.toString(), Memo[].class);
	            //System.out.println("JSON being sent: " + memoResponse.toString());
	            for (Memo memo : memoArray) {
	                model.addElement(new MemoList(memo));
	            }
	            System.out.println("Loaded memos: " + memoArray.length);
	        }

	        memoCon.disconnect();

	        listMemo.setModel(model);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void showAddGroupDialog() {
		String groupName = JOptionPane.showInputDialog(this, "Enter new group name:", "Add Group", JOptionPane.PLAIN_MESSAGE);
	    if (groupName != null && !groupName.trim().isEmpty()) {
	        try {
	            HttpURLConnection con = Session.createConnection("http://localhost:9015/memogroup/blank/" + Session.getLoggedInUser(), "POST");
	            con.setDoOutput(true);
	            String json = "{\"groupName\": \"" + groupName + "\"}";
	            try (java.io.OutputStream os = con.getOutputStream()) {
	                byte[] input = json.getBytes("utf-8");
	                os.write(input, 0, input.length);
	            }

	            int responseCode = con.getResponseCode();
	            if (responseCode == 201) {
	                JOptionPane.showMessageDialog(this, "Group created successfully!");
	                // Reload groups
	                MemoGroup newGroup = new MemoGroup();
	                newGroup.setGroupName(groupName);
	                Session.navigateTo(new MemosJ());
	                //memoGroupComboBox.addItem(newGroup);
	                //memoGroupComboBox.setSelectedItem(newGroup);
	            } else {
	                JOptionPane.showMessageDialog(this, "Failed to create group.");
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error occurred while creating group.");
	        }
	    }
	}


}
