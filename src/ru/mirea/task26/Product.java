package ru.mirea.task26;

public class Product {
    private String name;
    private double price;

    public Product(String name) {
        this.name = name;
        this.price = Math.random()*5000;
    }

    public double getPrice() {
        return price;
    }
}
