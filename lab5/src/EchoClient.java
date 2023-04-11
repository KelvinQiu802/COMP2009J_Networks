import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        String serverHostname = "127.0.0.1";
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress adder = InetAddress.getByName(serverHostname);
        byte[] buffer;

        if (args.length > 0)
            serverHostname = args[0];
        System.out.println("Attemping to connect to host " +
                serverHostname + " on port 10007.");

        while (true) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String msg = reader.readLine();

            if (msg.equals("bye")) {
                break;
            }

            buffer = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adder, 10007);
            clientSocket.send(packet);
            packet = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println(received);
        }

        clientSocket.close();
    }
}
