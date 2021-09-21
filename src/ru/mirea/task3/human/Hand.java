package ru.mirea.task3.human;

import java.util.Scanner;

public class Hand {
    private int quantity;
    private int length;

    public Hand()
    {
        Scanner sc = new Scanner(System.in);
        int quantity, length;
        System.out.print("Input hand quantity: ");
        quantity = sc.nextInt();
        System.out.print("Input hand length: ");
        length = sc.nextInt();
        System.out.println();
        setLength(length);
        setQuantity(quantity);
    }
    public void setLength(int length)
    {
        this.length = length;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    @Override
    public String toString()
    {
        return "Hand quantity: " + this.quantity +" "+ "Hand length: " + this.length;
    }
}

