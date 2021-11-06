package ru.mirea.task19.healthException;

public class HealthExceptionExample {
    private int health;
    public void setHealth(int health)
    {
        this.health = health;
    }
    public void reduceHealth() throws Exception
    {
        if (this.health < 0){
            throw new Exception("Health can't be less than 0!");
        }
        else
        {
            health--;
        }
    }
    public static void main(String[] args) {
        HealthExceptionExample example = new HealthExceptionExample();
        example.setHealth(1);
        while (true)
        {
            try {
                example.reduceHealth();
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Exception was processed. Program is stopped");
                break;
            }
        }
    }
}
