package ru.mirea.task2.shape;

import java.util.Scanner;
public class TestShape {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Shape b1 = new Shape("blue","rectangle");
        Shape b2 = new Shape();
        Shape b3 = new Shape("green","hexagon");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
    }
}
