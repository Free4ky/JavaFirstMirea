package ru.mirea.task16.GAME;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

enum pic{
    first_pic, second_pic, third_pic, fourth_pic
}
enum type{
    type_first, type_second
}
enum rank{
    rank_first, rank_second
}
public class Enemy {
    //FIELDS
    private double x; // координаты врага
    private double y;
    private int r; // размер врага
    private int r2;

    private double dx;
    private double dy;
    private double rad;
    private double speed;

    private int health;
    private type tp;
    private rank rk;

    private pic picture; // изображение игрока
    private Color color1;

    private BufferedImage enemy_icon;

    private boolean ready; // показывает находится ли враг на экране
    private boolean dead; // мертв ли враг

    //CONSTRUCTOR
    public Enemy(type type, rank rank){
        this.tp = type;
        this.rk = rank;

        BufferedImage buf;
        if (tp == type.type_first){

            if (rk == rank.rank_first){

                speed = 2;
                r = 10;
                r2 = (int)(r*3);
                health = 1;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy1.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
            else if (rk == rank.rank_second){
                speed = 2;
                r = 20;
                r2 = (int)(r*3);
                health = 3;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy1.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
        }
        else if (tp == type.type_second){
            if (rk == rank.rank_first){
                speed = 6;
                r = 13;
                r2 = (int)(r*3);
                health = 3;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\Enemy_Type22.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
            else if (rk == rank.rank_second){
                speed = 9;
                r = 10;
                r2 = (int)(r*3);
                health = 1;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\Enemy_Type2.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
        }
        x = Math.random()*GamePanel.WIDTH/2 + GamePanel.HEIGHT/4; // начальное положение спавна врага по x
        y = -r; // начальное положение спавна врага по y

        double angle = Math.random()*140+20; // начальное значение угла от 20 до 160 градусов
        rad = Math.toRadians(angle);
        dx = Math.cos(rad)*speed;
        dy = Math.sin(rad)*speed;

        ready = false;
        dead = false;

        picture = pic.second_pic;

    }

    //FUNCTIONS

    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public double getR(){return this.r;}

    public type getType(){
        return this.tp;
    }
    public rank getRank(){
        return this.rk;
    }
    public void hit(){
        health--;
        if (health <=0){
            dead = true;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void update(){
        x += dx;
        y += dy;

        if (!ready){
            if (x > r && x < GamePanel.WIDTH - r &&
            y > r && y < GamePanel.HEIGHT - r){
                ready = true; // если враг в области экрана - то он становится готов
            }
        }

        if (x < r && dx < 0){ // реализация отскока от левого края
            dx = -dx;
        }
        if (y < r && dy < 0){ // реализация отскока от пола
            dy = -dy;
        }
        if (x > GamePanel.WIDTH - r && dx > 0) { // отскок от правого края
            dx = -dx;
        }
        if (y > GamePanel.HEIGHT - r && dy > 0){ // отскок от потолка
            dy = -dy;
        }

        BufferedImage buf;
        if (tp == type.type_first){
            try{
                switch (picture){
                    case first_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy1.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.second_pic;
                        break;
                    case second_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy2.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.third_pic;
                        break;
                    case third_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy3.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.fourth_pic;
                        break;
                    case fourth_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy4.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.first_pic;
                        break;
                }
            }catch (Exception e){}
        }
    }
    public void draw(Graphics2D g){
        g.drawImage(enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
