package views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.Memo;
import com.example.model.MemoGroup;
import com.example.utils.Session;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemoDetailsJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMemoTitle;
	private JTextPane textPaneMemoContent;
	private JComboBox<MemoGroup> memoGroupComboBox;
	
	private boolean isEditMode = true;

	

	/**
	 * Create the frame.
	 * @param lblMemoGroup 
	 */
	public MemoDetailsJ(Memo memo) {
		setTitle("Memo Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 693);
		
		//navigation menu
		setJMenuBar(MenuNavigation.createMenuBar());
		
		textPaneMemoContent = new JTextPane();
		textPaneMemoContent.setEditable(false);

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//click event: save memo
		JButton btnSaveMemo = new JButton();		
		if(memo != null) {
			isEditMode = false;
			btnSaveMemo.setText("Edit");
		} else {
			btnSaveMemo.setText("Save");
		}
		memoGroupComboBox = new JComboBox<>();

		// "None" option to remove the group
		//memoGroupComboBox.addItem(null);
		


		// Load available groups (replace with your actual list)
		//java.util.List<MemoGroup> groupList = Session.getMemoGroups(); // Or however you load them
		try {
		    HttpURLConnection con = Session.createConnection("http://localhost:9015/memogroup/" + Session.getLoggedInUser(), "GET");

		    BufferedReader groupReader = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		    StringBuilder responseBuilder = new StringBuilder();
		    String line;
		    while ((line = groupReader.readLine()) != null) {
		        responseBuilder.append(line);
		    }
		    groupReader.close();

		    // Parse JSON array to list of MemoGroup
		    ObjectMapper mapper = new ObjectMapper();
		    List<MemoGroup> groupList = Arrays.asList(mapper.readValue(responseBuilder.toString(), MemoGroup[].class));

		    // Add to combo box
		    memoGroupComboBox.addItem(null); // for "None"
		    for (MemoGroup group : groupList) {
		        memoGroupComboBox.addItem(group);
		    }

		} catch (Exception ex) {
		    ex.printStackTrace(); // or show a dialog
		}
		// Set selected value if editing
		if (memo != null && memo.getMemoGroup() != null) {
		    memoGroupComboBox.setSelectedItem(memo.getMemoGroup());
		}

		memoGroupComboBox.setEnabled(isEditMode); // Initially not editable

		
		btnSaveMemo.setVisible(true);
		btnSaveMemo.addActionListener(e -> {
		    if (!isEditMode) {
		    	enableEditFields(); // enable fields for editing
		    	btnSaveMemo.setText("Confirm");
		        isEditMode = true;
		    } else {
		        try {
		        	String jsonBody = new String();
		            HttpURLConnection con;
		            if (memo == null) {
		                con = Session.createConnection("http://localhost:9015/memo/" + Session.getLoggedInUser(), "POST");
			            jsonBody = setMemoJson( textFieldMemoTitle.getText(), textPaneMemoContent.getText());
		            } else {
		                con = Session.createConnection("http://localhost:9015/memo/edit/memo/"+ Session.getLoggedInUser() + "/" + memo.getMemoId(), "PUT"); con.setDoOutput(true);
			            jsonBody = setMemoJsonEdit(memo.getMemoId(), textFieldMemoTitle.getText(), textPaneMemoContent.getText());
		            }		           

		            try (java.io.OutputStream os = con.getOutputStream()) {
		                byte[] input = jsonBody.getBytes("utf-8");
		                os.write(input, 0, input.length);
		            }

		            int code = con.getResponseCode();
		            if (code == 201 || code == 202) {
		                JOptionPane.showMessageDialog(null, "Memo saved");
		                Session.navigateTo(new MemosJ());
		            } else {
		            	System.out.println(jsonBody);
		                JOptionPane.showMessageDialog(null, "Memo not saved");
		            }
		            
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        isEditMode = false;
		        btnSaveMemo.setText("Edit");
		    }
		});
		
		
		      
		btnSaveMemo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMemoDetails = new JLabel("Memo Details");
		lblMemoDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemoDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblCreatedBy = new JLabel("Created By:");
		lblCreatedBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
		
		JLabel lblTitle = new JLabel("Memo Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMemoContent = new JLabel("Memo Content:");
		lblMemoContent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblMemoGroup = new JLabel("Memo Group:");
		lblMemoGroup.setFont(new Font("Tahoma", Font.PLAIN, 16));

						
		textFieldMemoTitle = memo != null ?  new JTextField(memo.getMemoTitle()) : new JTextField();
		if(memo != null) {
			textFieldMemoTitle.setEditable(false);
			textPaneMemoContent.setText(memo.getMemoContent());
			textPaneMemoContent.setEditable(false);
		}
		else {
			textFieldMemoTitle.setEditable(true); 
			textPaneMemoContent.setEditable(true);
		}
		textFieldMemoTitle.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setVisible(memo != null); // only show if memo exists

		btnDelete.addActionListener(e -> {
		    int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this memo?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
		    if (confirm == JOptionPane.YES_OPTION) {
		        try {
		            HttpURLConnection con = Session.createConnection("http://localhost:9015/memo/" + memo.getMemoId(), "DELETE");
		            int code = con.getResponseCode();
		            if (code == 200 || code == 201) {
		                JOptionPane.showMessageDialog(null, "Memo deleted");
		                Session.navigateTo(new MemosJ());
		            } else {		            	
		                JOptionPane.showMessageDialog(null, "Failed to delete memo");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error occurred while deleting memo");
		        }
		    }
		});

				
		
		//click event: Exit button
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code goes here
				MemosJ memosj = new MemosJ();
				Session.navigateTo(memosj);
				
			}
		});
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
		                    .addComponent(lblMemoGroup, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(70)
		                    .addComponent(memoGroupComboBox, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
		                .addGroup(gl_contentPane.createSequentialGroup()
		                    .addGap(70)
		                    .addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
		                    .addGap(6)
		                    .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
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
		            .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
		            .addGap(6)
		            .addComponent(textFieldMemoTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addGap(11)
		            .addComponent(lblMemoContent, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
		            .addGap(11)
		            .addComponent(textPaneMemoContent, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
		            .addGap(11)
		            .addComponent(lblMemoGroup, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
		            .addGap(6)
		            .addComponent(memoGroupComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		            .addGap(34)
		            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                .addComponent(btnSaveMemo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
		                .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
		                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
		            .addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}
	
	private String setMemoJsonEdit(int memoId, String memoTitle, String memoContent) {
	    MemoGroup selectedGroup = (MemoGroup) memoGroupComboBox.getSelectedItem();
	    String groupPart = selectedGroup != null ? 
	        "\"memoGroup\": { \"id\": " + selectedGroup.getId() + " }" : 
	        	"\"memoGroup\": { \"id\": 0 }";

	    String jsonObject = "{"
	        + "\"memoId\": \"" + memoId + "\","
	        + "\"memoTitle\": \"" + memoTitle + "\","
	        + "\"memoContent\": \"" + memoContent + "\","
	        + groupPart
	        + "}";

	    return jsonObject;
	}

	private String setMemoJson(String memoTitle, String memoContent) {
		MemoGroup selectedGroup = (MemoGroup) memoGroupComboBox.getSelectedItem();
	    String groupPart = selectedGroup != null ? 
	        "\"memoGroup\": { \"id\": " + selectedGroup.getId() + " }" : 
	        	"\"memoGroup\": { \"id\": 0 }";
	    
		String jsonObject = "{"
		        + "\"memoTitle\": \"" + memoTitle + "\","
		        + "\"memoContent\": \"" + memoContent + "\","
		        + groupPart
		        + "}";
		
		return jsonObject;
	}

	private void enableEditFields() {
		textFieldMemoTitle.setEnabled(true);
		textFieldMemoTitle.setEditable(true);
	    textPaneMemoContent.setEditable(true);	
	    memoGroupComboBox.setEnabled(true);
	}

}
