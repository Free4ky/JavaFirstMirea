package ru.mirea.task16.GAME;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

enum pic{
    first_pic, second_pic, third_pic, fourth_pic, fifth_pic
}
enum type{
    type_first, type_second, type_third, type_fourth
}
enum rank{
    rank_first, rank_second, rank_third, rank_fourth;
    private static rank[] vals = values();
    public rank previous(){
        return vals[(this.ordinal() - 1) % vals.length];
    }
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
    private BufferedImage hit_enemy_icon;

    private boolean ready; // показывает находится ли враг на экране
    private boolean dead; // мертв ли враг

    private boolean hit;
    private long hitTimer;
    private int hitDelay = 70;

    private boolean slow;


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
            else if (rk == rank.rank_third){
                speed = 2;
                r = 30;
                r2 = (int)(r*3);
                health = 5;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy1.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
            else if (rk == rank.rank_fourth){
                speed = 1;
                r = 40;
                r2 = (int)(r*3);
                health = 10;
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
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hit_Enemy_Type2.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
        }
        else if (tp == type.type_third){
            if (rk == rank.rank_first){
                speed = 4;
                r = 10;
                r2 = (int)(r*3);
                health = 6;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\small_tp3.png"));
                    enemy_icon = resize(buf,r2,r2);
                }catch (Exception e){}
            }
        }
        else if (tp == type.type_fourth){
            if (rk == rank.rank_first){
                speed = 1;
                r = 40;
                r2 = (int)(r*2.5);
                health = 10;
                try {
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\planet_enemy.png"));
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

        hit = false;
        hitTimer = 0;

    }

    //FUNCTIONS

    public double getX(){return this.x;}
    public double getY(){return this.y;}
    public int getR(){return this.r;}

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
        hit = true;
        hitTimer = System.nanoTime();
    }

    public boolean isDead() {
        return dead;
    }

    public void explode(){

        if (rk == rank.rank_second || rk == rank.rank_third || rk == rank.rank_fourth){
            for (int i = 0; i < 3; i++){
                Enemy e = new Enemy(getType(), getRank().previous());
                e.x = this.x; // враги появляются на месте взрыва предыдущего
                e.y = this.y;
                double angle = 0;
                if (!ready) {
                    angle = Math.random() * 140 + 20;
                }
                else{
                    angle = Math.random() * 360;
                }
                e.rad = Math.toRadians(angle);
                GamePanel.enemies.add(e);
            }
        }

    }
    public void update(){

        if (slow){ // если время замедлено, то враги движутся медленнее
            x += 0.3*dx;
            y += 0.3*dy;
        }
        else{
            x += dx;
            y += dy;
        }

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
        else if (tp == type.type_third){
            try{
                switch (picture){
                    case first_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\enemy_t3.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.second_pic;
                        break;
                    case second_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\small_tp31.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.third_pic;
                        break;
                    case third_pic:
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\small_tp32.png"));
                        enemy_icon = resize(buf,r2,r2);
                        picture = pic.first_pic;
                        break;
                }
            }catch (Exception e){}
        }
        if (hit){
            long past = (System.nanoTime() - hitTimer)/1000000;
            if (past > hitDelay){
                hit = false;
                hitTimer = 0;
            }
        }
    }
    public void draw(Graphics2D g){
        if(hit){
            try{
                BufferedImage buf;
                if (tp == type.type_first){
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hit_enemy11.png"));
                    hit_enemy_icon = resize(buf,(int)(r2*1.3), (int)(r2*1.3));
                    g.drawImage(hit_enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
                }
                else if (tp == type.type_second){
                    if (rk == rank.rank_first){

                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hit_Enemy_Type21.png"));
                        hit_enemy_icon = resize(buf,(int)(r2*1.3), (int)(r2*1.3));
                        g.drawImage(hit_enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
                    }
                    else if (rk == rank.rank_second){
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\Enemy_Type2.png"));
                        hit_enemy_icon = resize(buf,(int)(r2*1.3), (int)(r2*1.3));
                        g.drawImage(hit_enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
                    }
                }
                else if (tp == type.type_third){
                    if (rk == rank.rank_first){
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hitt_tp3.png"));
                        hit_enemy_icon = resize(buf,(int)(r2*1.3), (int)(r2*1.3));
                        g.drawImage(hit_enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
                    }
                }
                else if (tp == type.type_fourth){

                    if (rk == rank.rank_first){
                        buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hit_planet.png"));
                        hit_enemy_icon = resize(buf,(int)(r2*1.3), (int)(r2*1.3));
                        g.drawImage(hit_enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
                    }
                }
            }catch(Exception e){}
        }
        else{
            g.drawImage(enemy_icon,(int)(x-r2/2),(int)(y-r2/2),null);
        }
    }

    public void setSlow(boolean b){
        this.slow = b;
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
