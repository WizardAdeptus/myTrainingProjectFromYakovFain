package info.introToJava.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StockServer extends Remote {

    String getQuote(String symbol) throws RemoteException;

    List<String> getNasdaqSymbol() throws RemoteException;
}
