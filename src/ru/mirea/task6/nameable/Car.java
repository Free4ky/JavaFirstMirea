package ru.mirea.task6.nameable;

public class Car implements Nameable {
    private String name;
    public String getName() {
        return name;
    }
    public Car(String name) {
        this.name = name;
    }
}
