package ie.atu.sw;

import java.io.*;
import java.net.*;

/**
 * The `UserThread` class represents a thread that handles communication with a single client in the chat server.
 * Each connected client is assigned a separate `UserThread` instance.
 */
public class UserThread extends Thread {
    private Socket socket;
    private ChatServer server;
    private PrintWriter writer;
    /**
     * Constructs a new `UserThread` object.
     *
     * @param socket The client socket for communication.
     * @param server The chat server instance.
     */
    public UserThread(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;

        try {
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The `run` method is the entry point for the `UserThread` thread.
     * It handles the communication between the client and the server.
     */
    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

            // Print the list of connected users to the new client.
            printUsers();

            // Get the username from the client.
            String userName = reader.readLine();
            server.addUserName(userName);

            // Broadcast a message to all clients that a new user has connected.
            String serverMessage = "New user connected: " + userName;
            server.broadcast(serverMessage, this);

            String clientMessage;

            // Read messages from the client and broadcast them to all other clients.
            do {
                clientMessage = reader.readLine();
                serverMessage = "[" + userName + "]: " + clientMessage;
                server.broadcast(serverMessage, this);

            } while (!clientMessage.equals("q"));

            // Remove the user from the server and close the socket.
            server.removeUser(userName, this);
            socket.close();

            // Broadcast a message to all clients that the user has quit.
            serverMessage = userName + " has quitted.";
            server.broadcast(serverMessage, this);

        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Prints the list of connected users to the client.
     */
    void printUsers() {
        if (server.hasUsers()) {
            writer.println("Connected users: " + server.getUserNames());
        } else {
            writer.println("No other users connected");
        }
    }

    /**
     * Sends a message to the client.
     *
     * @param message The message to be sent.
     */
    void sendMessage(String message) {
        writer.println(message);
    }

}