package edu.neu.csye7374;

public class EnergyStockFactoryEagerSingleton implements StockFactory {
    private static final EnergyStockFactoryEagerSingleton instance = new EnergyStockFactoryEagerSingleton();

    private EnergyStockFactoryEagerSingleton() {}

    public static EnergyStockFactoryEagerSingleton getInstance() {
        return instance;
    }

    @Override
    public Stock createStock(String name, double price, String description) {
        return new EnergyStock(name, price, description);
    }
}
