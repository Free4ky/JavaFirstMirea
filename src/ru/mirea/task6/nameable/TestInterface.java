package ru.mirea.task6.nameable;

public class TestInterface
{
    public static void main(String[]args)
    {
        Nameable ob1 = createNameable("Mazda", true);
        Nameable ob2 = createNameable("Earth", false);
        System.out.println(ob1.getName());
        System.out.println(ob2.getName());
    }
    public static Nameable createNameable(String name, boolean option)
    {
        if (option){
            return new Car(name);
        }
        else
        {
            return new Planet(name);
        }
    }
}
