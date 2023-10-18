package org.example;

public class QuantityDiscount extends BaseDiscount{


    @Override
    protected boolean isApplicable(Product product, OrderInformation orderInformation) {
        return false;
    }

    @Override
    protected double calculateDiscount(Product product, OrderInformation orderInformation) {
        return 0;
    }

    protected QuantityDiscount(Discount discount) {
        super(discount);
    }

    @Override
    public double apply(Product product, OrderInformation orderInformation) {
        return 0;
    }

    @Override
    public String getDescription(Product product, OrderInformation orderInformation) {
        return null;
    }
}
