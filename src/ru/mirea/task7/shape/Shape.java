package ru.mirea.task7.shape;

public abstract class Shape {
    protected  String colour;
    protected boolean filled;
    public Shape(){
        this.colour = "RED";
        this.filled = false;
    }
    public Shape (String colour, boolean filled){
        this.filled = filled;
        this.colour = colour;
    }
    String getColour(){
        return this.colour;
    }
    boolean isFilled(){
        return filled;
    }
    void setFilled(boolean filled){
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimetr();
    @Override
    public  String toString()
    {
        return this.colour + " " + this.filled;
    }

}

