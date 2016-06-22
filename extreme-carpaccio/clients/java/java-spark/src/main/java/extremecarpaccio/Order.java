/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package extremecarpaccio;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Order {

    public static class Total {

        private final double total;

        public Total(double total) {
            this.total = total;
        }

        public double getTotal() {
            return total;
        }
    }

    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

    private final double[] prices;
    private final int[] quantities;
    private final String country;
    private final String reduction;

    public Order(double[] prices, int[] quantities, String country, String reduction) {
        this.prices = prices;
        this.quantities = quantities;
        this.country = country;
        this.reduction = reduction;
    }

    private void checkIntegrity() {
        if (prices == null || quantities == null || country == null|| reduction == null //
                        || prices.length != quantities.length) {
            throw new IllegalStateException("Bad request !!!");
        }
    }

    public Total getTotal() {
        checkIntegrity();
        double sumWithoutTax = IntStream.range(0, prices.length) //
                        .mapToDouble(index -> prices[index] * quantities[index]) //
                        .sum();
        double sumWithTax = sumWithoutTax * ECountryTax.fromCountryCode(country).getTaxFactor();
        double total = sumWithTax * EReduction.fromName(reduction).getReductionFactor(sumWithTax);
        return new Total(Double.valueOf(DECIMAL_FORMAT.format(total)));
    }

    public double[] getPrices() {
        return prices;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public String getCountry() {
        return country;
    }

    public String getReduction() {
        return reduction;
    }

    @Override
    public String toString() {
        return "Order{" +
                        "prices=" + Arrays.toString(prices) +
                        ", quantities=" + Arrays.toString(quantities) +
                        ", country='" + country + '\'' +
                        ", reduction='" + reduction + '\'' +
                        '}';
    }
}
