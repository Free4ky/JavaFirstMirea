package ru.mirea.task13.LinkedList;
import java.util.LinkedList;
public class LL {
    public static void main(String[] args) {
        LinkedList<String> cars = new LinkedList<String>();
        cars.add("Mazda");
        cars.add("Toyota");
        cars.addFirst("Lincoln");
        cars.addLast("BMW");
        System.out.print("Количесво элементов в списке cars: ");
        System.out.print(cars.size());
        System.out.println(cars.get(1));
        cars.set(1, "KIA");
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
        cars.remove("Mazda");
        cars.removeFirst();
        cars.removeLast();
        LinkedList<Person> people = new LinkedList<Person>();
        people.add(new Person("Mike"));
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));
        people.remove(1);
        for(Person p : people){
            System.out.println(p.getName());
        }
        Person first = people.getFirst();
        System.out.println(first.getName());
    }
}