package ru.mirea.task23.Enemy;

public class Enemy {

    private String name;
    private int damage;
    private int health;

    public Enemy(String name, int damage, int health)
    {
        this.name = name;
        this.damage = damage;
        this.health = health;
    }

    @Override
    public int hashCode(){

        int result = name == null ? 0 : name.hashCode();

        result = 31 * result + damage;
        result = 31* result + health;

        return result;
    }

    public boolean compare(Object o)
    {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {return false;}

        Enemy that = (Enemy) o;

        if (this.hashCode() == that.hashCode()) {return true;}

        return false;
    }
}
// В данном таске продемонстрирован пример сравнения объектов-врагов.