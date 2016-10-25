package info.introToJava.rest;

import java.util.HashMap;
import java.util.Map;

public class StockService {

    private static Map<String, Stock> stocks = new HashMap<>();

    public static void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public static void removeStock(String symbol) {
        stocks.remove(symbol);
    }

    public static Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    static {
        generateStocks();
    }

    private static void generateStocks() {
        addStock(new Stock("IBM", 43.12, "USD", "US"));
        addStock(new Stock("APPL", 320.00, "USD", "US"));
    }
}
