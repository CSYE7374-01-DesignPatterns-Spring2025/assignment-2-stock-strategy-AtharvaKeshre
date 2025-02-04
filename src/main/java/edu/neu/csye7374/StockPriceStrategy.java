package edu.neu.csye7374;

public interface StockPriceStrategy {
    double calculateNewPrice(double currentPrice, double bid);
}
