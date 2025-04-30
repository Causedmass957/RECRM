package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.example.model.Contact;
import com.example.utils.ButtonEditor;
import com.example.utils.Session;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.example.utils.Session;

public class AllContacts extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session.navigateTo(new AllContacts());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public AllContacts() {
		setTitle("All Contacts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        setJMenuBar(MenuNavigation.createMenuBar());

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("All Contacts");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

        JTable contactsTable = new JTable(); // You can set the model dynamically
        System.out.println("in contacts view");
        
        
        List<Contact> contacts = new ArrayList();
        try {
        	HttpURLConnection con = Session.createConnection("http://localhost:9015/contact/all/" + Session.getLoggedInUser(), "GET");
        	
        	if (con.getResponseCode() != 201) {
	            throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
	        }

	        BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
	        StringBuilder jsonOutput = new StringBuilder();
	        String output;
	        while ((output = br.readLine()) != null) {
	            jsonOutput.append(output);
	        }
	        
	        //System.out.println(jsonOutput);
	        
	        ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			
			contacts = mapper.readValue(jsonOutput.toString(), new TypeReference<List<Contact>>() {});
			
			con.disconnect();	
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        
        System.out.println(contacts.toString());
        
        String[] columnNames = {"Name", "Email", "Phone", "DOB", "View", "Delete"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        Object[][] data = new Object[contacts.size()][columnNames.length];

        for (int i = 0; i < contacts.size(); i++) {
            Contact c = contacts.get(i);
            data[i][0] = c.getContactName();
            data[i][1] = c.getContactEmail();
            data[i][2] = c.getContactPhone();
            data[i][3] = c.getDob();
        }

        contactsTable.setModel(new javax.swing.table.DefaultTableModel(
            data,
            columnNames
        ));
        
        for (Contact c : contacts) {
            JButton viewButton = new JButton("View");
            JButton deleteButton = new JButton("Delete");

            // Add your event handlers here
            viewButton.addActionListener(e -> {
            	Session.setActiveContactId(c.getContactId());
                //new ContactJ(c).setVisible(true); // Assuming ContactJ takes a Contact
            });

            deleteButton.addActionListener(e -> {
                // Delete logic
            });

            model.addRow(new Object[]{
                c.getContactName(),
                c.getContactEmail(),
                c.getDob(),
                c.getContactPhone(),
                viewButton,
                deleteButton
            });
        }
        
        System.out.println("table should be visible");
        
        contactsTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(contactsTable);
        
        contactsTable.getColumn("View").setCellEditor(new ButtonEditor());
        contactsTable.getColumn("Delete").setCellEditor(new ButtonEditor());
        add(scrollPane, BorderLayout.CENTER);


        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitle)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20)
                    .addComponent(lblTitle)
                    .addGap(20)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE))
        );

        contentPane.setLayout(layout);
	}

	private JButton createEventButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
