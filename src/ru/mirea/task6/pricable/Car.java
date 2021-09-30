package ru.mirea.task6.pricable;

public class Car implements Priceable {
    private int price;
    public String getPrice() {
        return "Car price is: " + this.price + "$";
    }
    public Car(int price) {this.price = price;}
}