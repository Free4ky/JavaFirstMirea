package ru.mirea.task5.dish;

public class dish1 extends Dish {
    private float volume;
    public dish1(String colour, float coast, float volume) {
        super(colour, coast);
        this.volume = volume;
    }
    public void displayInfo() {
        System.out.println("Цвет: " + super.getColour() + " Цена: " + super.getCoast() + " Объем: " + this.volume);
    }
}
