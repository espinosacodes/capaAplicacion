import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) {
        int PUERTO = 9876;
        try {
            DatagramSocket socket = new DatagramSocket(PUERTO);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("UDP Server is running...");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client: " + message);

            String response = "Hello CLIENT, greeting from the SERVER";
            sendData = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}