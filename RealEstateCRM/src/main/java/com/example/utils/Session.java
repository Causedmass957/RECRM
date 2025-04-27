package com.example.utils;

import java.util.Stack;

import javax.swing.JFrame;

public class Session {
	
	private static String loggedInUser;
	
	private static Stack<JFrame> backStack = new Stack<>();
    private static Stack<JFrame> forwardStack = new Stack<>();
	
	public static void setLoggedInUser(String username) {
        loggedInUser = username;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }
    
    // Navigation Methods
    public static void navigateTo(JFrame newFrame) {
        if (!backStack.isEmpty()) {
            JFrame current = backStack.peek();
            current.setVisible(false); // Hide current frame
        }
        backStack.push(newFrame);
        newFrame.setVisible(true);
    }

    public static void goBack() {
        if (backStack.size() > 1) {
            JFrame current = backStack.pop();
            forwardStack.push(current);
            current.setVisible(false);

            JFrame previous = backStack.peek();
            previous.setVisible(true);
        }
    }

    public static void goForward() {
        if (!forwardStack.isEmpty()) {
            JFrame next = forwardStack.pop();
            backStack.push(next);
            next.setVisible(true);
        }
    }

}
