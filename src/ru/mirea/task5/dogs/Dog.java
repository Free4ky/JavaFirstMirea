package ru.mirea.task5.dogs;

public abstract class Dog {
    private String breed;
    private float weight;
    public String getBreed(){return breed;}
    public float getWeight()  {return weight;}
    public Dog (String breed, float weight){
        this.breed = breed;
        this.weight = weight;
    }
    public abstract void displayInfo();
}
