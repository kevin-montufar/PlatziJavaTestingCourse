package co.com.devmont.javatestingcourse.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorSould {

    PriceCalculator priceCalculator;

    @Before
    public void before() {
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void returnZeroWhenThereArePrices() {
        assertThat(priceCalculator.getTotal(), is(0.0));
    }

    @Test
    public void returnTheSumOfPrices() {
        priceCalculator.addPrice(10.0);
        priceCalculator.addPrice(12.5);
        assertThat(priceCalculator.getTotal(), is(22.5));
    }

    @Test
    public void applyDiscountToPrices() {
        priceCalculator.addPrice(18.0);
        priceCalculator.addPrice(12.0);
        priceCalculator.applyDiscount(50);
        assertThat(priceCalculator.getTotal(), is(15.0));
    }
}