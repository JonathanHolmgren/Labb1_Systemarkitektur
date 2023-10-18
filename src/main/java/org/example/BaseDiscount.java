package org.example;

public abstract class BaseDiscount implements Discount{

protected final Discount nextDiscount;


    protected abstract boolean isApplicable(Product product, OrderInformation orderInformation);
    protected abstract double calculateDiscount(Product product, OrderInformation orderInformation);

    protected BaseDiscount(Discount discount) {
        this.nextDiscount = discount;
    }

}
