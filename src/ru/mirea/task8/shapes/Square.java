package ru.mirea.task8.shapes;

public class Square extends Shape{
    private int side;
    public Square()
    {
        super();
        this.side =(int)(Math.random()*100);
    }

    public int getSide() {
        return side;
    }
}
