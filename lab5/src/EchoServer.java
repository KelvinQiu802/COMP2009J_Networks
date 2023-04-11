import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket = null;
        byte[] buffer = new byte[256];

        try {
            serverSocket = new DatagramSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        System.out.println("Waiting for input.....");

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);

            InetAddress adder = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buffer, buffer.length, adder, port);
            String received = new String(packet.getData(), 0, packet.getLength());

            if (received.equals("bye")) {
                break;
            }
            serverSocket.send(packet);
        }
        serverSocket.close();
    }
} 