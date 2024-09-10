import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {
        String HOST = "localhost";
        int PUERTO = 9876;
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(HOST);
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            String message = "Hello SERVER, greeting from the CLIENT";
            sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PUERTO);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server: " + response);

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}