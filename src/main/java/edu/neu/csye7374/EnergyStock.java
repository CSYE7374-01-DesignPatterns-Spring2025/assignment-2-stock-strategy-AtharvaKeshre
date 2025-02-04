package edu.neu.csye7374;


class EnergyStock extends Stock {
    public EnergyStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    protected double calculateNewPrice(double bid) {
//        return price * 0.84 + bid * 0.03;
        return price * 0;
    }



    @Override
    public String getMetric() {
        return String.format("%.2f",price * Math.log(bids.size() + 1));
    }
}
