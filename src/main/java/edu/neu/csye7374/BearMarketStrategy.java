package edu.neu.csye7374;

public class BearMarketStrategy implements StockPriceStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid) {
        return currentPrice * 0.98 + bid * 0.02;
    }
}
