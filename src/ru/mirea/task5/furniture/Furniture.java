package ru.mirea.task5.furniture;

public abstract class Furniture {
    private String size;
    private float weight;
    public String getSize(){return size;}
    public float getWeight()  {return weight;}
    public Furniture (String size, float weight){
        this.size = size;
        this.weight = weight;
    }
    public abstract void displayInfo();
}
