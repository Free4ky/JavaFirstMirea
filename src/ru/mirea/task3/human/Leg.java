package ru.mirea.task3.human;
import java.util.Scanner;

public class Leg {
    private int quantity;
    private int length;
    public Leg()
    {
        Scanner sc = new Scanner(System.in);
        int quantity, length;
        System.out.print("Input leg quantity: ");
        quantity = sc.nextInt();
        System.out.print("Input leg length: ");
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
        return "Leg quantity: " + this.quantity + " " + "Leg length: " + this.length;
    }
}
