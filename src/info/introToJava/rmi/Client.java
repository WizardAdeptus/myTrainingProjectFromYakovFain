package info.introToJava.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("\nUsage: java -Djava.security.policy=security.policy Client AAPL");
            System.exit(0);
        }

        try {
            StockServer myServer = (StockServer)
                    Naming.lookup("rmi://localhost:3000/QuoteService");

            String price = myServer.getQuote(args[0]);
            if (price != null) {
                System.out.println("The price of " + args[0] + " is: $" + price);
            } else {
                System.out.println("Invalid Nasdaq symbol. Please use one of these:" +
                myServer.getNasdaqSymbol().toString());
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
