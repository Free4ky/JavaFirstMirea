package ru.mirea.task4.author;

import java.util.Scanner;

public class TestAuthor {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        String name;
        String email;
        char gender;
        name = sc.nextLine();
        email = sc.nextLine();
        gender = sc.next().charAt(0);
        Author ob = new Author(name,email,gender);
        System.out.println(ob);
        ob.setEmail("example@mial.ru");
        System.out.println(ob.getEmail());
    }
}
