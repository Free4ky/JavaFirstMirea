package ru.mirea.task10.recurtion.var12;

import java.util.Scanner;

public class Var12 {
    public static void main(String[] args)
    {
        OddPrint();
    }
    public static void OddPrint()
    {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 0)
        {
            return;
        }
        if (x % 2 != 0)
        {
            System.out.println(x);
        }
        OddPrint();
    }
}
