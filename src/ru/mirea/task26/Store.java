package ru.mirea.task26;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Choose choose = new Choose();
        double price = 0;
        Product product;
        ArrayList<Product> goods = new ArrayList<Product>();
        String name = "";
        System.out.println("Input names of products you want to buy:\n");
        while (true) {
            name = sc.nextLine();
            if (name.equals(".")) {
                break;
            }
            product = new Product(name);
            price += product.getPrice();
            goods.add(product);
        }
        System.out.println("What payment method do you prefer? Credit card: 1, EWallet: 2");
        int payment_num = sc.nextInt();
        choose.setPaymentMethod(payment_num);
        choose.pay(price);
    }
}
