package co.com.devmont.javatestingcourse.discounts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PriceCalculator {

    private List<Double> prices = new ArrayList<>();
    private double discount;

    public double getTotal() {
        //return prices.stream().collect(Collectors.summingDouble(Double::doubleValue));
        double sum = prices.stream().reduce(0.0, (a, b) -> a + b);
        return sum * ((100 - discount) / 100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void applyDiscount(double discount) {
        this.discount = discount;
    }
}
