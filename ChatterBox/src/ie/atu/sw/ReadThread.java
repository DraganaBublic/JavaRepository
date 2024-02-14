package ie.atu.sw;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The `ReadThread` class is responsible for reading messages from the server and displaying them to the client.
 * It runs as a separate thread to allow for concurrent reading and writing in the chat application.
 */
public class ReadThread extends Thread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    /**
     * Constructor for the `ReadThread` class.
     *
     * @param socket The socket connection to the server.
     * @param client The chat client instance.
     */
    public ReadThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try {
            // Get the input stream from the socket and create a BufferedReader to read messages from it.
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException ex) {
            System.out.println("Error getting input stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The run method of the `ReadThread` class.
     * It continuously reads messages from the server and displays them to the client.
     */
    public void run() {
        while (true) {
            try {
                // Read a line from the server
                String response = reader.readLine();

                // Check if the received message is about a new user connection
                if (response.startsWith("[New user connected]")) {
                    // Extract the username from the message
                    String[] parts = response.split(": ");
                    String newUserName = parts[1].trim();

                    // Display the new user connection message without duplicating the username
                    System.out.println("\n" + getTimestamp() + " [Server]: New user connected: " + newUserName);
                } else {
                    // Display regular messages
                    if (client.getUserName() != null) {
                        // If the client has a username, display the message with the username
                        System.out.println(getTimestamp() + " [" + client.getUserName() + "]: " + response);
                    } else {
                        // If the client does not have a username, display the message as is
                        System.out.println("\n" + response);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
                break;
            }
        }
    }

    /**
     * Returns the current timestamp in the format [HH:mm].
     *
     * @return The current timestamp.
     */
    private String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return "[" + sdf.format(new Date()) + "]";
    }
}