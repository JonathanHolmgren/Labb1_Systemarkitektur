package org.example;

public interface Discount {

    double apply(Product product, OrderInformation orderInformation);

    String getDescription(Product product, OrderInformation orderInformation);
}
