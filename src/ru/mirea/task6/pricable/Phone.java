package ru.mirea.task6.pricable;
public class Phone implements Priceable {
    private int price;
    public String getPrice() {
        return "Phone price is: " + this.price + "$";
    }
    public Phone(int price) {this.price = price;}
}
