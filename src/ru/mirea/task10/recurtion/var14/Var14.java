package ru.mirea.task10.recurtion.var14;

import java.util.Scanner;

public class Var14 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        IntPrint(sc.nextInt());
    }
    public static void IntPrint(int x)
    {
        if (x == 0)
        {
            return;
        }
        IntPrint(x/10);
        System.out.print(x%10);
        System.out.print(' ');
    }
}
