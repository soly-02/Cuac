import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	
	public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
	
	public void startServer() {
        try {
            
            while (!serverSocket.isClosed()) { // Listen for connections on port 5000. Main loop
                Socket socket = serverSocket.accept();  //blocking method. waits for a new client
                System.out.println("A new client has connected!" + socket);
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();  // ektelei thn run() sto ClientHandler
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }
	
	public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
//			^
//			|
//			|
//	methods and attributes go here
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(5000);
			Server server = new Server(serverSocket);
		    server.startServer();
		    System.out.println("Server is running");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot start server. QUITING");
			e.printStackTrace();
		}
       
	}

}
