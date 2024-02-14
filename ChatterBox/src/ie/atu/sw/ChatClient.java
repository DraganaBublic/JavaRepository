package ie.atu.sw;

import java.net.*;
import java.io.*;

/**
 * The `ChatClient` class represents a client that connects to a chat server and allows the user to send and receive messages.
 */
public class ChatClient {
    private String hostname;
    private int port;
    private String userName;

    /**
     * Constructs a `ChatClient` object with the specified hostname and port.
     *
     * @param hostname The hostname of the chat server.
     * @param port The port number of the chat server.
     */
    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Connects to the chat server and starts the read and write threads.
     */
    public void execute() {
        try {
            Socket socket = new Socket(hostname, port);

            System.out.println("Connected to the chat server");

            // Start the read thread to receive messages from the server.
            new ReadThread(socket, this).start();

            // Start the write thread to send messages to the server.
            new WriteThread(socket, this).start();

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    /**
     * Sets the username of the client.
     *
     * @param userName The username to set.
     */
    void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the username of the client.
     *
     * @return The username of the client.
     */
    String getUserName() {
        return this.userName;
    }

    /**
     * The main method that creates a `ChatClient` object and executes it.
     *
     * @param args The command line arguments. The first argument should be the hostname and the second argument should be the port number.
     */
    public static void main(String[] args) {
        if (args.length < 2)
            return;

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        ChatClient client = new ChatClient(hostname, port);
        client.execute();
    }
}