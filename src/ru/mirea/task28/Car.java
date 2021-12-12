package ru.mirea.task28;

public class Car {
    Door door;
    Roof roof;
    Engine engine;

    public void open(){
        System.out.println("Car is unlocked by radio wave");
    }

    public class Door extends Car{
        public void open(){
            System.out.println("Door is opened");
        }
    }

    public class Roof extends Car{
        public void open(){
            System.out.println("Roof is opened");
        }
    }

    public class Engine extends Car{
        public void stop(){
            System.out.println("Engine is stopped");
        }
        public void start(){
            System.out.println("Engine is started");
        }
    }

    public static void main(String[] args){
        Car car1 = new Car();
        car1.open();

        Car car2 = new Car().new Door();
        car2.open();

        Car car3 = new Car().new Roof();
        car3.open();

        Car car4 = new Car(){
            @Override
            public void open(){
                System.out.println("Car is unlocked by key");
            }
        };
        car4.open();
    }
}
