package ru.mirea.task5.dogs;

public class dog1 extends Dog {
    private String fate;
    public dog1(String breed, float weight, String fate) {
        super(breed, weight);
        this.fate = fate;
    }
    public void displayInfo() {
        System.out.println("Порода: " + super.getBreed() + " Вес в кг: " + super.getWeight() + " Предназанчение: " + this.fate);
    }
}
