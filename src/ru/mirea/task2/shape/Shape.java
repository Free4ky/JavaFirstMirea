package ru.mirea.task2.shape;

public class Shape {
    private String colour;
    private String shape;
    public Shape(String n, String r){
        colour = n;
        shape = r;
    }
    public Shape(){
        colour = "RED";
        shape = "Circle";
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setShape(String shape){
        this.shape = shape;
    }
    public String getColour(){
        return colour;
    }
    public String getShape(){
        return shape;
    }
    @Override
    public String toString(){
        return this.shape+" "+this.colour;
    }
}

