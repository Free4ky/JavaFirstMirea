package ru.mirea.task22;

public class TestFactory {
    public static void main(String[] args){
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy enemy1 = enemyFactory.createEnemy(EnemyType.BOMB);
        Enemy enemy2 = enemyFactory.createEnemy(EnemyType.ROCKET);
        Enemy enemy3 = enemyFactory.createEnemy(EnemyType.ASTEROID);
        System.out.println(enemy1.toString());
        System.out.println(enemy2.toString());
        System.out.println(enemy3.toString());
    }
}
// В своем проекте я использовал перечисления для создания врагов разного типа и ранга наподобие фабрики. Реализация в моем проекте отличается,
// поэтому в данном таске выполняю так, как следовало бы сделать.