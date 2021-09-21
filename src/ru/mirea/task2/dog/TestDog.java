package ru.mirea.task2.dog;

import java.util.Scanner;

public class TestDog {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Dog b1 = new Dog("Name", 3);
        Dog b2 = new Dog();
        Dog b3 = new Dog("Name2", 5);
        System.out.println(b1.toPeopleAge());
        System.out.println(b2.toPeopleAge());
        System.out.println(b3.toPeopleAge());
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
    }
}
