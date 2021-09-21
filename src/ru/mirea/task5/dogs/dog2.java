package ru.mirea.task5.dogs;

public class dog2 extends Dog {
    private String agression_degree;
    public dog2(String breed, float weight, String agression_degree) {
        super(breed, weight);
        this.agression_degree = agression_degree;
    }
    public void displayInfo() {
        System.out.println("Порода: " + super.getBreed() + " Вес в кг: " + super.getWeight() + " Уровень агрессии: " + this.agression_degree);
    }
}
