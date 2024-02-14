package ie.atu.sw;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The `WriteThread` class represents a thread that handles writing messages to the server in a chat application.
 * It extends the `Thread` class to run in a separate thread.
 */
public class WriteThread extends Thread {
    private PrintWriter writer;
    private ChatClient client; 
    private Socket socket; 
    /**
     * Constructor to initialize the WriteThread object.
     *
     * @param socket The socket connection to the server.
     * @param client The ChatClient object.
     */
    public WriteThread(Socket socket, ChatClient client) {
        try {
            // Get the output stream of the socket and create a PrintWriter object to write messages to the server
            OutputStream output = socket.getOutputStream();
            this.writer = new PrintWriter(output, true);

            this.client = client; // Set the ChatClient object
            this.socket = socket; // Set the socket connection

            new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException ex) {
            System.out.println("Error getting output stream: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The run() method is called when the thread is started.
     * It prompts the user to enter their name, sends it to the server, and then continuously reads user input from the console and sends it to the server.
     * The loop continues until the user enters "q" to quit.
     */
    public void run() {
        Console console = System.console();

        // Prompt the user to enter their name and set it in the ChatClient object
        String userName = console.readLine("\nEnter your name: ");
        client.setUserName(userName);
        writer.println(userName);

        String text;

        // Continuously read user input from the console and send it to the server
        do {
            text = console.readLine("[" + userName + "]: ");
            writer.println(text);

        } while (!text.equals("q"));

        try {
            socket.close(); // Close the socket connection
        } catch (IOException ex) {
            System.out.println("Error writing to server: " + ex.getMessage());
        }
    }
}