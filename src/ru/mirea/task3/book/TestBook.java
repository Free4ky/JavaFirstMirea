package ru.mirea.task3.book;

import ru.mirea.task2.book.Book;

import java.util.Scanner;
public class TestBook {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        ru.mirea.task2.book.Book b1 = new ru.mirea.task2.book.Book("Name","Author", 1900);
        ru.mirea.task2.book.Book b2 = new ru.mirea.task2.book.Book();
        ru.mirea.task2.book.Book b3 = new Book("Name2","Author2", 1902);
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(b3.toString());
    }
}

