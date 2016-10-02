package info.introToJava.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockServerImpl extends UnicastRemoteObject implements StockServer {

    private String price;
    private ArrayList<String> nasdaqSymbols = new ArrayList<>();

    public StockServerImpl() throws RemoteException {
        super();

        LocateRegistry.createRegistry(3000);

        // Define same hard-coded NASDAQ symbols
        nasdaqSymbols.add("AAPL");
        nasdaqSymbols.add("MSFT");
        nasdaqSymbols.add("YHOO");
        nasdaqSymbols.add("AMZN");
        nasdaqSymbols.add("MOT");
    }

    @Override
    public String getQuote(String symbol) throws RemoteException {
        if (nasdaqSymbols.indexOf(symbol.toUpperCase()) != -1) {

            // Generate a random price for valid symbol
            price = (new Double(Math.random() * 100)).toString();
        }
        return price;
    }

    @Override
    public List<String> getNasdaqSymbol() throws RemoteException {
        return nasdaqSymbols;
    }
}