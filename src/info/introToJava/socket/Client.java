package info.introToJava.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Need java Client Symbol");
            System.exit(-1);
        }

        Socket client;
        try {
            // Open a client socket connection
            client = new Socket("127.0.0.1", 3000);
            System.out.println("Client: " + client);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
