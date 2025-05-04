package com.example.utils;

import java.awt.Window;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

import javax.swing.JFrame;

public class Session {
	
	private static String loggedInUser;
	private static Stack<JFrame> backStack = new Stack<>();
    private static Stack<JFrame> forwardStack = new Stack<>();
	private static JFrame currentFrame;
	private static int activeContactId; 
	private static int activeMemo;
	
	public static int getActiveMemo() {
		return activeMemo;
	}

	public static void setActiveMemo(int activeMemo) {
		Session.activeMemo = activeMemo;
	}

	public static void setLoggedInUser(String username) {
        loggedInUser = username;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
    
	public static void setActiveContactId(int contactId) {
		activeContactId = contactId;
    }
	
    public static int getActiveContactId() {
        return activeContactId;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }
    
    // Navigation Methods
    public static void navigateTo(JFrame frame) {
        if (currentFrame != null) {
            currentFrame.dispose(); // Close the current frame
        }
        currentFrame = frame;
        currentFrame.setVisible(true);
    }

 // Method to go back to the previous frame
    public static void goBack() {
        if (!backStack.isEmpty()) {
            // Push the current frame to the forward stack
            forwardStack.push(currentFrame);

            // Pop the last frame from the back stack and navigate to it
            JFrame previousFrame = backStack.pop();
            currentFrame.dispose();
            currentFrame = previousFrame;
            currentFrame.setVisible(true);
        } else {

        }
    }

    public static void goForward() {
        if (!forwardStack.isEmpty()) {
            // Push the current frame to the back stack
            backStack.push(currentFrame);

            // Pop the last frame from the forward stack and navigate to it
            JFrame nextFrame = forwardStack.pop();
            currentFrame.dispose();
            currentFrame = nextFrame;
            currentFrame.setVisible(true);
        } else {
            System.out.println("No forward frame to go to.");
        }
    }
    
    public static HttpURLConnection createConnection(String endpointUrl, String httpMethod) throws Exception {
        URL url = new URL(endpointUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestMethod(httpMethod.toUpperCase());
        con.setRequestProperty("Accept", "application/json");

        if (httpMethod.equalsIgnoreCase("POST") || httpMethod.equalsIgnoreCase("PUT")) {
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true); // Only POST and PUT send a body
        }
        
        return con;
    }

}
