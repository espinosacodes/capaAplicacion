import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = 
        InetAddress.getByName("localhost");
        
        for (int i = 0; i < 10; i++) { 
            
            byte[] sendData = "Hello, World!".getBytes();

            DatagramPacket sendPacket = 
            new DatagramPacket(
                sendData, 
                sendData.length, 
                IPAddress, 
                9876);

            clientSocket.send(sendPacket);
        }

        clientSocket.close();

    }
    
}
