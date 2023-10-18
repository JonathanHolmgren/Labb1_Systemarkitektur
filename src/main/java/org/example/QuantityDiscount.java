package org.example;

public class QuantityDiscount extends BaseDiscount{

    protected QuantityDiscount(Discount discount) {
        super(discount);
    }

private int getNumberOfProducts(OrderInformation orderInformation){
    int quantity = 0;

    for (Product p: orderInformation.products()) {
        quantity = quantity + p.getQuantity();
    }
    return quantity;
};

    @Override
    protected boolean isApplicable(Product product, OrderInformation orderInformation) {
        return getNumberOfProducts(orderInformation) >= 5;

    }

    @Override
    protected double calculateDiscount(Product product, OrderInformation orderInformation) {
        if (isApplicable(product, orderInformation)){
            return 0.10 * orderInformation.products().size();
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
            return "You have at least 5 products, and therefore receive $0.10 per product. \n" + nextDiscount.getDescription(product, orderInformation);
        }
        return String.valueOf(orderInformation.products().size());
    }
}
