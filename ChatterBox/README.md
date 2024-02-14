
ChatterBox - Chat Application
ChatterBox is a simple chat application that allows users to connect to a central server and exchange messages in real-time. The application consists of a server and a client component, allowing multiple users to participate in a chat session.

Features
User Connection: Users can connect to the central server by providing the server's hostname and port number.

User Registration: When a new user connects to the server, their username is requested. The server checks for uniqueness and registers the user.

Real-time Messaging: Users can exchange messages in real-time with other connected users.

User Disconnection: Users can gracefully disconnect from the chat by entering the command 'q'.

Display of Connected Users: The server keeps track of connected users and broadcasts the list to all users whenever a new user connects or an existing user disconnects.

Timestamps: Messages are accompanied by timestamps indicating when they were sent.

How to Use
Server
Compile the server application: javac ie/atu/sw/ChatServer.java
Run the server: java ie.atu.sw.ChatServer <port-number>
Client
Compile the client application: javac ie/atu/sw/ChatClient.java
Run the client: java ie.atu.sw.ChatClient <hostname> <port-number>
Enter your desired username when prompted.
Start chatting!
Commands
To send a message: Simply type your message and press Enter.
To quit the chat: Type 'q' and press Enter.
Important Notes
Each user is identified by a unique username.
Messages are broadcasted to all connected users.
The server maintains a list of connected users, and updates are broadcasted whenever a new user connects or an existing user disconnects.
Authors
[Your Name]
[Your Email]
License
This project is licensed under the MIT License. Feel free to modify and distribute it as per the license terms. If you have any suggestions or improvements, please feel free to contribute!
