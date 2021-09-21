package ru.mirea.task1;

import java.util.Scanner;

public class tsk1 {

    public static void main(String[]args){
        int sum = 0;
        int b[] = new int[5];
        Scanner sc = new Scanner(System.in);
        // задание 3
        System.out.println("Задание 3");
        System.out.print("Введите значения элементов массива: ");
        for (int i = 0; i < 5; i++)
        {
            b[i] = sc.nextInt();
            sum+=b[i];
        }
        System.out.println(sum);
        sum = 0;
        int k = 0;
        while (k < b.length)
        {
            sum += b[k];
            k++;
        }
        System.out.println(sum);
        sum = 0;
        k = 0;
        do{
            sum += b[k];
            k++;
        }while(k < b.length);
        System.out.println(sum);

        // задание 4
        System.out.println("Задание 4");
        System.out.print("Аргументы командной строки: ");
        for (int i = 0; i < args.length; i++)
        {
            System.out.print(String.format("Argument %d: %s", i, args[i]));
            System.out.print(' ');
        }
        System.out.println();
        // задание 5
        System.out.println("Задание 5");
        System.out.print("Первые 10 членов гармонического ряда: ");
        k = 1;
        float x;
        for (int i = 0; i < 10; i++)
        {
            x = 1f/k;
            System.out.print(x);
            System.out.print(' ');
            k++;
        }
        System.out.println();
        // задание 6
        System.out.println("Задание 6");
        for (int i = 0; i < 5; i++)
        {
            b[i] =(int)(Math.random()*100);
        }
        System.out.print("Массив случайных чисел: ");
        for (int i = 0; i < 5; i++)
        {
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();
        int a;
        System.out.println("Задание 7");
        a = sc.nextInt();
        System.out.print("Факториал числа: ");
        System.out.print(fac(a));
    }
    // задание 7
    public static int fac(int x)
    {
        int f=1;
        while (x != 0){
            f*= x;
            x--;
        }
        return f;
    }
}