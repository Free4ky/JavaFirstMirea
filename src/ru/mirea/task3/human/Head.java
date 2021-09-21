package ru.mirea.task3.human;

import java.util.Scanner;

public class Head {
    private int quantity;
    private String hair_color;

    public Head()
    {
        Scanner sc = new Scanner(System.in);
        int quantity;
        String hair_colour;
        System.out.print("Input head quantity: ");
        quantity = sc.nextInt();
        System.out.print("Input hair colour: ");
        hair_color = sc.next();
        System.out.println();
        setHair_color(hair_color);
        setQuantity(quantity);
    }
    public void setHair_color(String hair_color)
    {
        this.hair_color = hair_color;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    @Override
    public String toString()
    {
        return "Head quantity: " + this.quantity +" "+ "Hair colour: " + this.hair_color;
    }
}
