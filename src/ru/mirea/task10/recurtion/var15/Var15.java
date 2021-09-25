package ru.mirea.task10.recurtion.var15;


import java.util.Scanner;

public class Var15 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        IntPrint(sc.nextInt());
    }
    public static void IntPrint(int x)
    {
        System.out.print(x%10);
        System.out.print(' ');
        x = x/10;
        if (x == 0)
        {
            return;
        }
        IntPrint(x);
    }
}

