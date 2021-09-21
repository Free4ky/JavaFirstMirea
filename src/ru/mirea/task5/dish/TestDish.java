package ru.mirea.task5.dish;

public class TestDish {
    public static void main (String[] args){
        dish1 d1 = new dish1("White", 13.7f, 112.5f);
        d1.displayInfo();
        Dish d2 = new dish2("Black", 3.5f, 11.5f);
        d2.displayInfo();
    }
}
