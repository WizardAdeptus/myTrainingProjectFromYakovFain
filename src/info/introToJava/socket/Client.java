package info.introToJava.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Need java Client Symbol");
            System.exit(-1);
        }

        Socket client = null;
        try {
            // Open a client socket connection
            client = new Socket("127.0.0.1", 3000);
            System.out.println("Client: " + client);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (client != null) {
            try (
                OutputStream outputStream = client.getOutputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()))
            ) {
                // Send stock symbol to the server
                outputStream.write((args[0] + "\n").getBytes());

                String quote;
                while (true) {
                    quote = reader.readLine();

                    if (quote.length() == 0) continue;
                    if ("End".equals(quote)) break;

                    System.out.println("Got the quote for " + args[0] + ":" + quote);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
