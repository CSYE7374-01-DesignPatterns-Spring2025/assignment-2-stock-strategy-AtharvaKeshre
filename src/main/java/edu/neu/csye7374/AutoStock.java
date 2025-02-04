package edu.neu.csye7374;


class AutoStock extends Stock {
    public AutoStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    protected double calculateNewPrice(double bid) {
//        return price * 0.98 + bid * 0.02;
        return price * 0;
    }


    @Override
    public String getMetric() {
        return String.format("%.2f",price * Math.log(bids.size() + 1));
    }
}
