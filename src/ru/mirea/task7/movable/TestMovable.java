package ru.mirea.task7.movable;

public class TestMovable {
    public static void main(String[]args) {
        Movable ob1 = new MovablePoint(10,10,100,100);
        Movable ob2 = new MovableCircle(10,10,15,15,100);
        System.out.println(ob1.toString());
        ob1.moveDown();
        ob1.moveLeft();
        System.out.println(ob1.toString());

        System.out.println(ob2.toString());
        ob2.moveUp();
        ob2.moveRight();
        System.out.println(ob2.toString());

        Movable ob3 = new MovableRectangle(10, 5, 12, 7, 10,12);
        System.out.println(ob3.toString());
        ob3.moveRight();
        ob3.moveRight();
        ob3.moveUp();
        System.out.println(ob3.toString());
    }
}
