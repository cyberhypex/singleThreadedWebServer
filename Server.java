import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.Socket;
public class Server {
    public static void run() {
        int port = 8010; //defining a port number
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
        } catch (Exception e) {
            System.err.println("Failed to start port:"+port);
            System.err.println("Reason:"+e.getMessage());
            e.printStackTrace();
        }
        try {
            socket.setSoTimeout(10000);
        } catch (SocketException e) {
            System.err.println("Connection establishment took longer than expected");
            System.err.println("Reason:"+e.getCause());
            System.out.println("Here failed");
            e.printStackTrace();
        }
        while (true) {
            try {
                System.out.println("Server is listening on port" + port);
                Socket acceptedConnection = socket.accept();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed");
            }
        }

    }
    public static void main(String[] args) {
        run();
    }
}
