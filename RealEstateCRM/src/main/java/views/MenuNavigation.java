package views;

import javax.swing.*;
import com.example.utils.Session;
import java.awt.event.ActionEvent;
import com.example.utils.Session;

public class MenuNavigation {
    public static JMenuBar createMenuBar() {
    	System.out.println("Creating menu bar here, works");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("RECRM");

        //home
        JMenuItem home = new JMenuItem("Home");
        home.addActionListener(e -> Session.navigateTo(new HomeJ()));

        //contacts
        JMenuItem contacts = new JMenuItem("Contacts");
        contacts.addActionListener(e -> Session.navigateTo(new AllContacts()));

        //memos
        JMenuItem memos = new JMenuItem("Memos");
        memos.addActionListener(e -> Session.navigateTo(new MemosJ()));

        //logout, lead back to login page
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(e -> {
            Session.logout();
            Session.navigateTo(new Login());
        });

        //back
        //JMenuItem back = new JMenuItem("Back");
        //back.addActionListener(e -> Session.goBack());

        //forward
        //JMenuItem forward = new JMenuItem("Forward");
        //forward.addActionListener(e -> Session.goForward());

        //add items to menu
        menu.add(home);
        menu.add(contacts);
        menu.add(memos);
        menu.addSeparator();
        //menu.add(back);
        //menu.add(forward);
        //menu.addSeparator();
        menu.add(logout);

        menuBar.add(menu);
        
        menuBar.setVisible(true);
        menu.setVisible(true);
        return menuBar;
    }
}