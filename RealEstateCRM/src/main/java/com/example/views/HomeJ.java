package com.example.views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.model.Contact;
import com.example.utils.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class HomeJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeJ frame = new HomeJ();
					Session.navigateTo(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeJ() {
		//System.out.println("Creating menu bar...");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 403);
		
		
		//navigation menu
		setJMenuBar(MenuNavigation.createMenuBar());
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JSeparator separator_1_1 = new JSeparator();
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
		List<Contact> contacts = new ArrayList<>();
		try {
			HttpURLConnection con = Session.createConnection("http://localhost:9015/contact/all/" + Session.getLoggedInUser(), "GET");
			//System.out.println("Connection received");
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
		
		List<Contact> upcomingBirthdays = getUpcomingBirthdays(contacts);

		int yPosition = 200;
		for (Contact contact : upcomingBirthdays) {
		    JLabel birthdayLabel = new JLabel(contact.getContactName() + " - Birthday: " + contact.getContactDOB());
		    birthdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		    birthdayLabel.setBounds(20, yPosition, 400, 30);
		    contentPane.add(birthdayLabel);
		    yPosition += 40;
		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(lblHome, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGap(18)
					.addComponent(lblHome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public List<Contact> getUpcomingBirthdays(List<Contact> allContacts) {
	    List<Contact> upcomingBirthdays = new ArrayList<>();
	    LocalDate now = LocalDate.now();

	    for (Contact contact : allContacts) {
	        if (contact.getContactDOB() != null) {
	            LocalDate birthdayThisYear = contact.getContactDOB().withYear(now.getYear());
	            long daysBetween = ChronoUnit.DAYS.between(now, birthdayThisYear);

	            if (daysBetween >= 0 && daysBetween <= 30) {
	                upcomingBirthdays.add(contact);
	            }
	        }
	    }
	    return upcomingBirthdays;
	}


}
