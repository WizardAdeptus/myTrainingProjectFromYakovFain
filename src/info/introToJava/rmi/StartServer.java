package info.introToJava.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class StartServer {
    public static void main(String[] args) {

        try {
            StockServerImpl ssi = new StockServerImpl();
            Naming.rebind("rmi://localhost:3000/QuoteService", ssi);

            System.out.println("<QuoteService> server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
