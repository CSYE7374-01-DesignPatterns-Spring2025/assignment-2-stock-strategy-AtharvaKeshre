package edu.neu.csye7374;

public class AutoStockFactoryLazySingleton implements StockFactory {
    private static AutoStockFactoryLazySingleton instance;

    private AutoStockFactoryLazySingleton() {}

    public static AutoStockFactoryLazySingleton getInstance() {
        if (instance == null) {
            synchronized (AutoStockFactoryLazySingleton.class) {
                if (instance == null) {
                    instance = new AutoStockFactoryLazySingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public Stock createStock(String name, double price, String description) {
        return new AutoStock(name, price, description);
    }
}
