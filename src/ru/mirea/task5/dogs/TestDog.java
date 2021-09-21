package ru.mirea.task5.dogs;

public class TestDog {
    public static void main (String[] args){
        dog1 d1 = new dog1("Ovcharka", 13.7f, "Работа в полиции");
        d1.displayInfo();
        Dog d2 = new dog2("Korgy", 3.5f, "Низкий");
        d2.displayInfo();
    }
}
