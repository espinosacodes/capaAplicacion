import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) {
        int PUERTO = 6789;
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("TCP Server is running...");
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client: " + message);
            out.writeUTF("Hello CLIENT, greeting from the SERVER");

            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}