package org.example;

public class DefaultDiscount implements Discount{

    @Override
    public double apply(Product product, OrderInformation orderInformation) {
        return 0;
    }

    @Override
    public String getDescription(Product product, OrderInformation orderInformation) {
        return null;
    }
}
