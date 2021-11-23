package ru.mirea.task22;

enum EnemyType{
    BOMB,ASTEROID,ROCKET
}

public class EnemyFactory {
    public Enemy createEnemy(EnemyType type) {

        Enemy enemy = null;

        switch (type){
            case BOMB:
                enemy = new Bomb();
                break;
            case ROCKET:
                enemy = new Rocket();
                break;
            case ASTEROID:
                enemy = new Asteroid();
                break;
        }
        return enemy;
    }
}
