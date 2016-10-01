package info.introToJava.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StockQuoteServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket client;

        BufferedReader reader = null;
        OutputStream outputStream = null;

        try {
            // Create a server socket
            serverSocket = new ServerSocket(3000);

            System.out.println("Waiting for a quote requests...");
            while (true) {
                // Wait for a request
                client = serverSocket.accept();

                // Get the streams
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outputStream = client.getOutputStream();

                String symbol = reader.readLine();

                // Generate a random stock price
                String price = (new Double(Math.random() * 100)).toString();

                outputStream.write(("\n The price of " + symbol + " is " +
                    price + "\n").getBytes());

                System.out.println("Request for " + symbol + " has been processed - the price of " +
                    symbol + " is " + price + "\n");

                outputStream.write("End\n".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("StockQuoteServer: can't close streams" + e.getMessage());
            }
        }
    }
}
