package info.introToJava.rest;

import javax.xml.bind.annotation.XmlRootElement;

// DTO
// @XmlRootElement - этот класс можно представлять в виде xml или JSON
@XmlRootElement
public class Stock {
    private String symbol;
    private Double price;
    private String currency;
    private String country;

    public Stock() {
    }

    public Stock(String symbol, Double price, String currency, String country) {
        this.symbol = symbol;
        this.price = price;
        this.currency = currency;
        this.country = country;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }
}
