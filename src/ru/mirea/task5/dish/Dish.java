package ru.mirea.task5.dish;

public abstract class Dish {
    private String colour;
    private float coast;
    public String getColour(){return colour;}
    public float getCoast()  {return coast;}
    public Dish (String colour, float coast){
        this.colour = colour;
        this.coast = coast;
    }
    public abstract void displayInfo();
}
