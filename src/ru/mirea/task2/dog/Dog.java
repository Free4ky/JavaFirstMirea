package ru.mirea.task2.dog;

public class Dog {
    private int year;
    private String name;
    public Dog(String name,int year){
        this.name = name;
        this.year = year;
    }
    public Dog(){
        name = "Dog";
        year = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getName(){
        return name;
    }
    public int getYear() {
        return year;
    }
    public int toPeopleAge()
    {
        return this.year * 7;
    }
    @Override
    public String toString(){
        return this.name + " " + " " + this.year;
    }
}

