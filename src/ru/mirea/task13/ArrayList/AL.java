package ru.mirea.task13.ArrayList;

import java.util.ArrayList;

public class AL {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Mazda");
        cars.add("Toyota");
        cars.add("BMW");
        cars.add("Lincoln");
        cars.add(1,"Honda");
        System.out.println(cars.get(1));
        cars.set(3,"Zil");
        System.out.print("Количесво элементов в списке cars: ");
        System.out.print(cars.size());
        for (String car : cars)
        {
            System.out.println(car);
        }
        if (cars.contains("Mazda")){
            System.out.println("В списке содержится машина марки Mazda");
        }
        else{
            System.out.println("В списке не содержится машина марки Mazda");
        }
        cars.remove("Zil");
        cars.remove(0);
        Object[] automobiles = cars.toArray();
        for (Object automobile : automobiles){
            System.out.println(automobile);
        }
    }
}
