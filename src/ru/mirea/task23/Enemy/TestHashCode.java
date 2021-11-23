package ru.mirea.task23.Enemy;

public class TestHashCode {
    public static void main(String[] args){

        Enemy enemy1 = new Enemy("Rocket",100,12);
        Enemy enemy2 = new Enemy("Rocket",100,12);
        Enemy enemy3 = new Enemy("Bomb",100,12);

        System.out.print("enemy1 hash code is: ");
        System.out.println(enemy1.hashCode());

        System.out.print("enemy2 hash code is: ");
        System.out.println(enemy2.hashCode());

        System.out.print("enemy3 hash code is: ");
        System.out.println(enemy3.hashCode());

        System.out.print("Is enemy1 equal to enemy2: ");
        System.out.println(enemy1.compare(enemy2));

        System.out.print("Is enemy1 equal to enemy3: ");
        System.out.println(enemy1.compare(enemy3));
    }
}
