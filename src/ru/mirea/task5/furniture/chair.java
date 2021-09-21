package ru.mirea.task5.furniture;

public class chair extends Furniture {
    private String back_existence;
    public chair(String size, float weight, String back_existence) {
        super(size, weight);
        this.back_existence = back_existence;
    }
    public void displayInfo() {
        System.out.println("Стул:\nГабаритный размер: " + super.getSize() + " Вес в кг: " + super.getWeight() + " Наличие спинки: " + this.back_existence);
    }
}
