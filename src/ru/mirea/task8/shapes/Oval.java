package ru.mirea.task8.shapes;

public class Oval extends Shape{
    private int length;
    private int width;
    public Oval()
    {
        super();
        this.length = (int)(Math.random()*100);
        this.width = (int)(Math.random()*200);
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
