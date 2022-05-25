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
    private static Registry registry = new Registry();
    private String userID; //!!!userID tha einai to email

    // Creating the client handler from the socket the server passes.
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.userID = bufferedReader.readLine(); // waits for the user's email. See User.connect method
            // Add the new client handler to the array
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    
    //h methodos run trexei gia kathe client pou syndeetai, dexetai ola ta messages tou client kai kalei thn antistoixh methodo sto registry 
    @Override
    public void run() {
        String[] messageFromClient;
                
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedReader.readLine().split(";"); //read client's message
                
                // to messageFromClient exei tin morfi "query;message"
                // me to split pernoume to query kai blepoume ti thelei na kanei o client
                //amesws meta to ":" einai to email (oxi panta omws) gia na kseroume poios zitise ti

                switch(messageFromClient[0]) {
                	case "login":  
                		if(!(registry.login(messageFromClient[1]))) {
                			sendMsg("user not found");
                			System.out.println( "attempted login failed. Removing client");
                			removeClientHandler();
                		}
                		else {
                			sendMsg("user found");
                		}
                		break;
                	case "register":
                		if(registry.register(messageFromClient[1])) {
                			sendMsg("successfully registered");
                		}
                		else {
                			sendMsg("user already exists");
                		}
                		break;
                	case "getfilePath": 
                		sendMsg(registry.getFilePath(messageFromClient[1]));
                		break;
                	case "setfilePath":
                		registry.setFilePath(messageFromClient[1]);
                		break;
                	case "seatLog":
                		registry.saveSeat(messageFromClient[1]);
                		break;
                	case "InfectionAlert":
                		registry.addInfection(messageFromClient[1]);
                		registry.saveInfection(messageFromClient[1]);
                		break;
                	default:
                		// alliws an o client de steilei string me sigkekrimeni morfi ton kanoume remove kai kleinoume ta streams tou
                		closeEverything(socket, bufferedReader, bufferedWriter);
                		System.out.println("client removed. Message unclear " + socket);	
                	}
               
            } catch (IOException e) { // an yparxei sfalma opoudhpote parapanw tote kapoios client termatistike
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
    public void sendMsg(String MsgToSend) {
		try {
			bufferedWriter.write(MsgToSend);
			bufferedWriter.newLine();
			bufferedWriter.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to send message to client");
			closeEverything(socket, bufferedReader, bufferedWriter);
			e.printStackTrace();
		} 
		
	}
}
