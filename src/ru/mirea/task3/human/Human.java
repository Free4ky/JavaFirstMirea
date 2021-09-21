package ru.mirea.task3.human;
import ru.mirea.task2.ball.Ball;

import java.util.Scanner;

public class Human {
    public Human() {
        Hand hand = new Hand();
        Leg leg = new Leg();
        Head head = new Head();
        System.out.print("Information about a human: "+"\n"+head.toString()+ "\n" + leg.toString() + "\n" + hand.toString());
    }
}
