package ru.mirea.task8.shapes;

public class Circle extends Shape{
    private int radius;
    public Circle()
    {
        super();
        this.radius = (int)(Math.random()*150);
    }

    public int getRadius() {
        return radius;
    }
}
