import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        String HOST = "localhost";
        int PUERTO = 6789;
        try {
            Socket socket = new Socket(HOST, PUERTO);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Hello SERVER, greeting from the CLIENT");
            String message = in.readUTF();
            System.out.println("Server: " + message);

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}