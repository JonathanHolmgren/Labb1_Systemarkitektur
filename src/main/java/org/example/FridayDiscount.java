package org.example;

public class FridayDiscount extends BaseDiscount{


    protected FridayDiscount(Discount discount) {
        super(discount);
    }

    @Override
    protected boolean isApplicable(Product product, OrderInformation orderInformation) {
        return orderInformation.isFriday();
    }

    @Override
    protected double calculateDiscount(Product product, OrderInformation orderInformation) {
        if (isApplicable(product, orderInformation)){
            return 0.10 * product.getPrice();
        }
        return 0;
    }

    @Override
    public double apply(Product product, OrderInformation orderInformation) {
        return nextDiscount.apply(product, orderInformation) + calculateDiscount(product,orderInformation);
    }

    @Override
    public String getDescription(Product product, OrderInformation orderInformation) {
        if(isApplicable(product,orderInformation))
        {
            return "It's Friday with 10% discount! \n" + nextDiscount.getDescription(product, orderInformation);
        }
        return null;
    }
}
