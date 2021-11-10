package ru.mirea.task16.GAME;

import java.awt.*;

public class Bullet {
    //FIELDS
    private double x;
    private double y;
    private int r;

    private double dx;
    private double dy;
    private double rad;
    private double speed;

    private Color bullet_color;

    //CONSTRUCTOR
    public Bullet(double angle, int x, int y){
        this.x = x;
        this.y = y;
        r = 2;

        rad = Math.toRadians(angle);

        speed = 15;
        dx = Math.cos(rad) * speed; // приращение по x
        dy = Math.sin(rad) * speed; // приращение по y

        bullet_color = Color.YELLOW;
    }
    //FUNCTIONS

    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public double getR(){return this.r;}

    public void setR(int r){
        this.r = r;
    }
    public boolean update(){
        x+=dx;
        y+=dy;

        if (x < -r || x > GamePanel.WIDTH + r || // снаряд вышел за границы экрана => он пропадает
        y < -r || y > GamePanel.HEIGHT + r){
            return true;
        }
        return false;
    }
    public void draw(Graphics2D g){ // метод отрисовки пули
        g.setColor(bullet_color);
        g.fillOval((int)(x-r), (int)(y - r), 2*r, 2*r);
    }
}
