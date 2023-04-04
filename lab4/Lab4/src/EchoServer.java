import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10007);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10007.");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection.....");

        try {
            while (true) {
                clientSocket = serverSocket.accept();
                Thread serverThread = new Thread(new ServerThread(serverSocket, clientSocket));
                serverThread.start();
            }
//            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

    }
} 