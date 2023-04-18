import java.io.IOException;
import java.net.DatagramSocket;
import java.util.Scanner;

public class PortSniffer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        int PORT = getPort();

        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("Connect OK");
        } catch (IOException e) {
            System.err.printf("%d is busy.", PORT);
            System.exit(1);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static int getPort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Port: ");
        int PORT = scanner.nextInt();
        scanner.close();
        return PORT;
    }
}
