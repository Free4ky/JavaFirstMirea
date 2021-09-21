package ru.mirea.task2.book;

import java.util.Scanner;
public class TestBook {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book("Name","Author", 1900);
        Book b2 = new Book();
        Book b3 = new Book("Name2","Author2", 1902);
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
    }
}
