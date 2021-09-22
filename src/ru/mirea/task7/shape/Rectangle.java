package ru.mirea.task7.shape;

public class Rectangle extends Shape{
    protected double width;
    protected double length;

    public Rectangle() {
        this.width = 1;
        this.length = 1;
        this.filled = false;
        this.colour = "red";
    }

    public Rectangle(double width, double length, String colour, boolean filled) {
        super(colour, filled);
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length) {
        super("green", false);
        this.width = width;
        this.length = length;
    }
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getPerimetr() {
        return (length + width) * 2;
    }
    @Override
    public double getArea()
    {
        return length * width;
    }
    @Override
    public String toString() {
        return "Shape: rectangle, width: "+this.width + ", length:" + this.length +", color: "+this.colour;
    }
}
