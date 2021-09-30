package ru.mirea.task6.pricable;

public class TestInterface
{
    public static void main(String[]args)
    {
        Priceable ob1 = createNameable(1200000, true);
        Priceable ob2 = createNameable(17990, false);
        System.out.println(ob1.getPrice());
        System.out.println(ob2.getPrice());
    }
    public static Priceable createNameable(int price, boolean option)
    {
        if (option){
            return new Car(price);
        }
        else
        {
            return new Phone(price);
        }
    }
}