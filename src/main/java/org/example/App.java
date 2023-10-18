package org.example;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


        Product milk = Product.createProduct("milk", 1,1);
        Product bread = Product.createProduct("bread", 2,1);
        Product carrot = Product.createProduct("carrot", 0.5,2);
        Product orange = Product.createProduct("orange", 1.5,2);
        Product coffee = Product.createProduct("orange", 1.5,2);


        List<Product> orderLessThenFive = new ArrayList<>();;
        orderLessThenFive.add(milk);
        orderLessThenFive.add(bread);
        orderLessThenFive.add(carrot);

        List<Product> orderMoreThenFive = new ArrayList<>();
        orderMoreThenFive.add(milk);
        orderMoreThenFive.add(bread);
        orderMoreThenFive.add(carrot);
        orderMoreThenFive.add(orange);
        orderMoreThenFive.add(coffee);

        OrderInformation orderInformation = new OrderInformation("Kalle", orderLessThenFive,false);
        OrderInformation orderInformationFriday = new OrderInformation("Kalle", orderMoreThenFive,true);


        Discount milkDiscount = new MilkDiscount(new DefaultDiscount());
        Discount fridayDiscount = new FridayDiscount(new DefaultDiscount());
        Discount fridayDiscountMilk = new FridayDiscount(new MilkDiscount(new DefaultDiscount()));
        Discount fridayDiscountMilkAndFiveProducts = new QuantityDiscount(new FridayDiscount(new MilkDiscount(new DefaultDiscount())));


        System.out.println("Product name: " + milk.getName());
        System.out.println("Product Price: " + milk.getPrice() + "$");
        System.out.println("Product Quantity: " +milk.getQuantity());

        System.out.println("Discount: " + String.format("%.2f",milkDiscount.apply(milk,orderInformation) )+ "$");
        System.out.println(milkDiscount.getDescription(milk,orderInformation));
        System.out.println("-----------");

        System.out.println("Discount: " + String.format("%.2f",fridayDiscount.apply(milk,orderInformationFriday) )+ "$");
        System.out.println(fridayDiscount.getDescription(milk,orderInformationFriday));
        System.out.println("-----------");

        System.out.println("Discount: " + String.format("%.2f",fridayDiscountMilk.apply(milk,orderInformationFriday) )+ "$");
        System.out.println(fridayDiscountMilk.getDescription(milk,orderInformationFriday));
        System.out.println("-----------");

        System.out.println("Discount: " + String.format("%.2f",fridayDiscountMilkAndFiveProducts.apply(milk,orderInformationFriday) )+ "$");
        System.out.println(fridayDiscountMilkAndFiveProducts.getDescription(milk,orderInformationFriday));
        System.out.println("-----------");

    }
}
