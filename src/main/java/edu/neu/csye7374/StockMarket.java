package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;

class StockMarket {
    private static StockMarket instance;
    private final Map<String, Stock> stocks;

    private StockMarket() {
        stocks = new HashMap<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.name, stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void tradeStock(String name, String bid) {
        Stock stock = stocks.get(name);
        if (stock != null) {
            stock.setBid(bid);
        } else {
            System.out.println("Stock not found: " + name);
        }
    }

    public void showAllStocks() {
        stocks.values().forEach(System.out::println);

    }

    public static void demo(){
        StockMarket market = StockMarket.getInstance();


        StockFactory autoFactory = AutoStockFactoryLazySingleton.getInstance();
        StockFactory energyFactory = EnergyStockFactoryEagerSingleton.getInstance();


        Stock autoStock = autoFactory.createStock("Tesla", 720.50, "Tesla Auto Stock");
        Stock energyStock = energyFactory.createStock("NationalGrid", 290.50, "NationalGrid Energy Stock");

        autoStock.setStrategy(new BullMarketStrategy());
        energyStock.setStrategy(new BearMarketStrategy());

        market.addStock(autoStock);
        market.addStock(energyStock);

        String[] bids = {"10", "20", "30", "40", "50", "60"};

        for (String bid : bids) {
            System.out.println("Bid: " + bid);
            market.tradeStock("Tesla", bid);
            market.tradeStock("NationalGrid", bid);
            market.showAllStocks();
            System.out.println();
        }
        market.removeStock("Tesla");
        System.out.println("After removing the stocks we are left with - ");
        market.showAllStocks();
    }
}
