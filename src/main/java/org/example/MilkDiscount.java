package org.example;

public class MilkDiscount extends BaseDiscount {


    protected MilkDiscount(Discount discount) {
        super(discount);
    }

    @Override
    protected boolean isApplicable(Product product, OrderInformation orderInformation) {
        return product.getName().equalsIgnoreCase("milk");
    }

    @Override
    protected double calculateDiscount(Product product, OrderInformation orderInformation) {
        if (isApplicable(product, orderInformation)){
            return 0.05 * product.getPrice();
        }
        return 0;
    }

    @Override
    public double apply(Product product, OrderInformation orderInformation) {

        return nextDiscount.apply(product, orderInformation) + calculateDiscount(product,orderInformation);
    }

    @Override
    public String getDescription(Product product,OrderInformation orderInformation) {
        if(isApplicable(product,orderInformation))
        {
            return "The " + product.getName() + " has a 5% discount.";
        }
        return null;
    }
}
