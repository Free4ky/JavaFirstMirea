package ru.mirea.task5.furniture;
import java.util.Scanner;
public class FurnitureShop {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my Furniture Shop!\nI have such products:");
        chest d1 = new chest("10x10x10", 13.7f, 121.6f);
        d1.displayInfo();
        Furniture d2 = new chair("12x15x11", 3.5f, "NO");
        d2.displayInfo();
    }
}
