package ru.mirea.task2.ball;

public class Ball {
    private String colour;
    private float radious;
    public Ball(String n, float r){
        colour = n;
        radious = r;
    }
    public Ball(){
        colour = "RED";
        radious = 67.5f;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setRadious(float radious){
        this.radious = radious;
    }
    public String getColour(){
        return colour;
    }
    public float getRadious(){
        return radious;
    }
    public String toString(){
        return this.colour+", colour"+this.colour;
    }
    public float Volume(){
        return 4f/3*3.14f*radious*radious*radious;
    }
}
