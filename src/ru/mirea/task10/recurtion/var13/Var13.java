package ru.mirea.task10.recurtion.var13;

import java.util.Scanner;

public class Var13 {
    public static void main(String[] args)
    {
        Idx();
    }
    public static void Idx()
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 0)
        {
            return;
        }
        System.out.println(x);
        Idx2();

    }
    public static void Idx2()
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 0)
        {
            return;
        }
        Idx();
    }
}
