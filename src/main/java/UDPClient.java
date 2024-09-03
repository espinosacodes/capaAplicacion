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
                IPAddress, //la dirección IP del servidor
                9876); //el puerto del servidor

            clientSocket.send(sendPacket);

            //preparar recepcion de respuesta
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            //recibir respuesta del servidor
            clientSocket.receive(receivePacket);
            String answerString = new String(receivePacket.getData());
            System.out.println("FROM SERVER: " + answerString);


        }


        

        clientSocket.close();

    }

    
    
}
