import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    // Socket for a connection, buffer reader and writer for receiving and sending data
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Registry registry = new Registry();

    // Creating the client handler from the socket the server passes.
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
 
            // Add the new client handler to the array
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    //h methodos run trexei gia kathe client pou syndeetai, dexetai ola ta messages tou client kai kalei thn antistoixh methodo sto registry 
    @Override
    public void run() {
        String messageFromClient;
        String messageToClient;
        // Continue to listen for messages while a connection with the client is still established.
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine(); //read client's message
                //System.out.println(messageFromClient);
                if(messageFromClient.contains(", ")) {  //an einai se morfi (username, password) shmainei oti tha kanoume login 
                	if(!(registry.login(messageFromClient))) {
                		messageToClient = "user not found";
                		bufferedWriter.write(messageToClient);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                	}
                	else {
                		messageToClient = "user found";
                		bufferedWriter.write(messageToClient);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                	}
                	//System.out.println(messageToClient);
                }
                else { // alliws an o client de steilei string me sigkekrimeni morfi ton kanoume remove
                	removeClientHandler();
                	System.out.println("client removed " + socket);
                }
            } catch (IOException e) { // an yparxei sfalma opoudhpote parapanw tote kapoios client termatistike
                // Close everything gracefully.
            	System.out.println("A client QUIT " + socket);
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
    
    public void removeClientHandler() {
        clientHandlers.remove(this);
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
