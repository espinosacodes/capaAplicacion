
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = 
                new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = 
            new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String message = 
            new String(receivePacket.getData());
            System.out.println("RECEIVED: " + message);
        }
        
        //para mandar al cliente hacen falta conocer la dirección IP y el puerto del cliente
        
        InetAddress ClientIPAddress = 
                receivePacket.getAddress();

        int port = receivePacket.getPort(); 
        byte[] sendData = 
        "Hello, im answering from the server!".getBytes();

        // enviar respuesta al cliente

        DatagramPacket sendPacket = 
                new DatagramPacket(
                        sendData, 
                        sendData.length, 
                        ClientIPAddress, 
                        port);
        
        serverSocket.send(sendPacket);

        

    }


}
