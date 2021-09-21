package ru.mirea.task5.furniture;


public class chest extends Furniture {
    private float volume;
    public chest(String size, float weight, float volume) {
        super(size, weight);
        this.volume = volume;
    }
    public void displayInfo() {
        System.out.println("Сундук:\nГабаритный размер: " + super.getSize() + " Вес в кг: " + super.getWeight() + " Объем: " + this.volume);
    }
}
