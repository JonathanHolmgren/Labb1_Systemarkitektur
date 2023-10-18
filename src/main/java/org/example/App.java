package org.example;

public class App {
    public static void main(String[] args) {

        Product milk = Product.createProduct("milk", 1,4);



        Discount milkDiscount = new MilkDiscount(new DefaultDiscount());
        OrderInformation orderInformation = new OrderInformation("Kalle", 3);

        System.out.println("Product name: " + milk.getName());
        System.out.println("Product Price: " + milk.getPrice() + "$");
        System.out.println("Product Quantity: " +milk.getQuantity());

        System.out.println("Discount: " + String.format("%.2f",milkDiscount.apply(milk,orderInformation) )+ "$");
        System.out.println(milkDiscount.getDescription(milk,orderInformation));
        System.out.println("-----------");



    }
}
