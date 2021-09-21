package ru.mirea.task5.dish;

public class dish2 extends Dish {
    private float radious;
    public dish2(String colour, float coast, float radious) {
        super(colour, coast);
        this.radious = radious;
    }
    public void displayInfo() {
        System.out.println("Цвет: " + super.getColour() + " Цена: " + super.getCoast() + " Радиус: " + this.radious);
    }
}
