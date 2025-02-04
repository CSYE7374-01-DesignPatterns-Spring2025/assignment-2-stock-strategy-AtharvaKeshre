package edu.neu.csye7374;

public class BullMarketStrategy implements StockPriceStrategy {
    @Override
    public double calculateNewPrice(double currentPrice, double bid) {
        return currentPrice * 1.02 + bid * 0.05;
    }
}
