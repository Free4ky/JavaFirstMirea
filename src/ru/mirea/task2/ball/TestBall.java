package ru.mirea.task2.ball;

import java.util.Scanner;
public class TestBall {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Ball b1 = new Ball("Green",10.5f);
        Ball b2 = new Ball();
        Ball b3 = new Ball("Yellow",165.5f);
        float x = sc.nextFloat();
        System.out.println(b1.getRadious());
        b1.setRadious(x);
        System.out.println(b1.getRadious());
        System.out.println(b1.Volume());
        System.out.println(b2.Volume());
        System.out.println(b3.Volume());
        System.out.println();
    }
}