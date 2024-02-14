package ie.atu.sw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * The `ChatServer` class represents a server that allows multiple clients to connect and chat with each other.
 * It listens for incoming connections on a specified port and creates a new `UserThread` for each connected user.
 */
public class ChatServer {
    private int port;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    /**
     * Constructs a new `ChatServer` object with the specified port.
     *
     * @param port The port number on which the server listens for incoming connections.
     */
    public ChatServer(int port) {
        this.port = port;
    }

    /**
     * Starts the execution of the chat server.
     * It creates a new `ServerSocket` and listens for incoming connections.
     * For each new connection, it creates a new `UserThread` and starts it.
     */
    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server is ready to accept connections on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected.");

                // UserThread constructor now requires the username to be passed
                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * Returns the set of usernames of all connected users.
     *
     * @return The set of usernames of all connected users.
     */
    Set<String> getUserNames() {
        return this.userNames;
    }

    /**
     * Broadcasts a message to all connected users, except for the user specified in the `excludeUser` parameter.
     *
     * @param message     The message to be broadcasted.
     * @param excludeUser The user to exclude from the broadcast.
     */
    public void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    /**
     * Removes a user from the chat.
     *
     * @param userName The username of the user to be removed.
     * @param aUser    The `UserThread` representing the user to be removed.
     */
    public void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    /**
     * Checks if there are any users connected to the chat.
     *
     * @return `true` if there are users connected, `false` otherwise.
     */
    public boolean hasUsers() {
        return !userNames.isEmpty();
    }

    /**
     * Adds a username to the set of connected usernames.
     *
     * @param userName The username to be added.
     */
    void addUserName(String userName) {
        userNames.add(userName);
    }

    /**
     * The entry point of the chat server application.
     * It reads the port number from the command line arguments and starts the chat server.
     *
     * @param args The command line arguments. The first argument should be the port number.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter <port-number>");
            System.exit(0);
        }

        int port = Integer.parseInt(args[0]);

        ChatServer server = new ChatServer(port);
        server.execute();
    }
}