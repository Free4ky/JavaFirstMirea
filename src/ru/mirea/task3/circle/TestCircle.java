package ru.mirea.task3.circle;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Circle c = new Circle(10.5f);
        System.out.print(c.P());
        System.out.println();
        System.out.print(c.S());
        System.out.println();
        float x = sc.nextFloat();
        c.setRadious(x);
        System.out.print(c.getRadious());
    }
}
