/**
 * 
 */
/*package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        // Create the menu and menu items
        JMenu menu = new JMenu("RECRM");
        JMenuItem itemHome = new JMenuItem("Home");
        JMenuItem itemContacts = new JMenuItem("Contacts");
        JMenuItem itemMemos = new JMenuItem("Memos");
        JMenuItem itemLogOut = new JMenuItem("Log Out");

        // Add action listeners to menu items
        itemHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchFrame("Home");
            }
        });
        
        itemContacts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchFrame("Contacts");
            }
        });

        itemMemos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchFrame("Memos");
            }
        });

        itemLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchFrame("Log Out");
            }
        });

        // Add menu items to the menu
        menu.add(itemHome);
        menu.add(itemContacts);
        menu.add(itemMemos);
        menu.add(itemLogOut);

        // Add the menu to the menu bar
        this.add(menu);
    }

    private void switchFrame(String frameName) {
    	JFrame currentFrame = AppState.getCurrentFrame();
        
    	if (currentFrame != null)
    	{
    		currentFrame.dispose();
    	}
    		
        JFrame newFrame = null;
        
        //Get the new frame from AppState
        switch (frameName)
        {
        case "Home":
        	newFrame = AppState.HomeJ;
            break;
        case "Contacts":
            newFrame = AppState.ContactsJ;
            break;
        case "Memos":
            newFrame = AppState.MemosJ;
            break;
        case "Log Out":
            newFrame = AppState.Login;  // Switch back to Login
            break;
        default:
            break;
        }
       

    if (newFrame != null)
    {
    	AppState.setCurrentFrame(newFrame); // Update the current frame in AppState
    	newFrame.setVisible(true); //show the new frame    
    }
}
}*/