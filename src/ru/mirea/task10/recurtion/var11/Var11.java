package ru.mirea.task10.recurtion.var11;

import java.util.Scanner;

public class Var11 {
    public static void main(String[] args)
    {
        System.out.println(OneQuantity(0,0));
    }
    public static int OneQuantity(int start, int Oquantity) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int O_quantity = Oquantity;
        int counter = start;
        if (x == 1)
        {
            counter++;
        }
        if (x == 0)
        {
            O_quantity++;
        }
        if (x != 0)
        {
            O_quantity = 0;
        }
        if (O_quantity == 2){
            return counter;
        }
        return OneQuantity(counter,O_quantity);
    }

}

