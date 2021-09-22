package ru.mirea.task7.shape;

public class Square extends Rectangle{
    public Square() {
        this.colour = "black";
        this.filled = false;
        this.length = 1;
        this.width = this.length;
    }

    public Square(double side, String colour, boolean filled) {
        super(side, side, colour, filled);
    }
    public Square(double side) {
        this.colour = "black";
        this.filled = false;
        this.length = side;
        this.width = this.length;
    }
    public void setSide(double side)
    {
        this.length = side;
        this.width = this.length;
    }
    public double getSide()
    {
        return this.length;
    }
    @Override
    public void setWidth(double side) {
        this.width = side;
    }
    @Override
    public void setLength(double side) {
        this.length = side;
    }
    @Override
    public String toString() {
        return "Shape: square, side: "+this.getSide() + ", color: "+this.colour;
    }
}
