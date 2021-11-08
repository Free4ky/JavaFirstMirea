package ru.mirea.task16.GAME;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

enum pictures{
    first_pic,second_pic,third_pic
}

public class Player {
    // ПОЛЯ
    private BufferedImage player_icon; // картинка игрока
    private BufferedImage player_icon2; // картинка игрока
    private BufferedImage hit_player_icon; // ударенная картинка игрока
    private int x;
    private int y;
    private int icon_width;
    private int icon_height;

    private int dx;
    private int dy;
    private int speed;

    private boolean left; // игрок двидется ввлево
    private boolean right;  // вправо и т.д
    private boolean up;
    private boolean down;

    private boolean firing;
    private long firingTimer;
    private long firingDelay;

    private int lives;

    private Color color1;
    private Color color2;

    private pictures pic;
    //КОНСТРУКТОР

    public Player(){
        x = GamePanel.WIDTH / 2;
        y = GamePanel.HEIGHT / 2;
        icon_width = 25;
        icon_height = 50;

        dx = 0;
        dy = 0;
        speed = 5;

        lives = 3;
        BufferedImage buf;
        try {
             buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_icon.png"));
             player_icon = resize(buf,icon_width,icon_height);

        }catch (IOException e){}

        color1 = Color.WHITE;
        color2 = Color.red;

        pic = pictures.first_pic;

        firing = false;// при появлении игрок не стреляет
        firingTimer = System.nanoTime(); // текущее время
        firingDelay = 200; // миллисекунд задержка выстрела
    }

    // ФУНКЦИИ
    public void setLeft(boolean left) {
        this.left = left;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setUP(boolean up) {
        this.up = up;
    }
    public void setDown(boolean down) {
        this.down = down;
    }

    public void setFiring(boolean b){
        this.firing = b;
    }

    public void update(){
        if (left){
            dx = -speed;
        }
        if (right){
            dx = speed;
        }
        if(up){
            dy = -speed;
        }
        if(down){
            dy = speed;
        }

        x += dx;
        y += dy;

        if (x < icon_width / 100) {
            x = icon_width / 100;
        }
        if (y < icon_height / 100){
            y = icon_height / 100;
        }
        if (x > GamePanel.WIDTH - icon_width) {
            x = GamePanel.WIDTH - icon_width;
        }
        if (y > GamePanel.HEIGHT - icon_height){
            y = GamePanel.HEIGHT - icon_height;
        }
        dx = 0;
        dy = 0;

        if (firing){ // если игрок стреляет
            long elapsed = (System.nanoTime() - firingTimer)/1000000; // сколько времени прощло с момента последнего выстрела
            if (elapsed > firingDelay){
                GamePanel.bullets.add(new Bullet(270,x+icon_width/2,y));
                firingTimer = System.nanoTime();
            }
        }
        // анимация ракеты
        BufferedImage buf;
        try{
            switch (pic){
                case first_pic:
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_icon2.png"));
                    player_icon = player_icon = resize(buf,icon_width,icon_height);
                    pic = pictures.second_pic;
                    break;
                case second_pic:
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_icon3.png"));
                    player_icon = player_icon = resize(buf,icon_width,icon_height);
                    pic = pictures.third_pic;
                    break;
                case third_pic:
                    buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\player_icon.png"));
                    player_icon = player_icon = resize(buf,icon_width,icon_height);
                    pic = pictures.first_pic;
                    break;
            }
        }catch (Exception e){}
    }

    public void draw(Graphics2D g){
        g.drawImage(player_icon,x, y, null);
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    public int getLives(){
        return this.lives;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getIcon_width(){
        return this.icon_width;
    }
    public int getIcon_height(){
        return this.icon_height;
    }
}
