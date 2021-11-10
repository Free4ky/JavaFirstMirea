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

    private boolean recovering; // игрок восстанавливается от удара
    private long recoveryTimer;
    private long recoveryDelay = 2000;

    private int score; // счет игрока

    private int powerLevel; // уровень игрока
    private int power; // отвечает за количество собранных припасов
    private int maxPowerLevel = 14;
    private int[] requiredPower = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}; // массив уровней игрока

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
        try {
            buf = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\hit_player_icon.png"));
            hit_player_icon = resize(buf,icon_width,icon_height);

        }catch (IOException e){}

        color1 = Color.WHITE;
        color2 = Color.red;

        pic = pictures.first_pic;

        firing = false;// при появлении игрок не стреляет
        firingTimer = System.nanoTime(); // текущее время
        firingDelay = 200; // миллисекунд задержка выстрела

        recovering = false;
        recoveryTimer = 0;

        score = 0;

        power = 0;
        powerLevel = 0;
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

    public boolean isDead(){
        return lives <=0;
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

        if (x < icon_width/2) {
            x = icon_width/2;
        }
        if (y < icon_height/100){
            y = icon_height/100;
        }
        if (x > GamePanel.WIDTH - icon_width/2) {
            x = GamePanel.WIDTH - icon_width/2;
        }
        if (y > GamePanel.HEIGHT - icon_height){
            y = GamePanel.HEIGHT - icon_height;
        }
        dx = 0;
        dy = 0;

        // если игрок стреляет
        if (firing){
            long elapsed = (System.nanoTime() - firingTimer)/1000000; // сколько времени прощло с момента последнего выстрела
            if (elapsed > firingDelay){
                if (powerLevel < 2){
                    GamePanel.bullets.add(new Bullet(270,x,y));
                }
                else if (powerLevel < 4){
                    GamePanel.bullets.add(new Bullet(270,x + 5,y));
                    GamePanel.bullets.add(new Bullet(270,x - 5,y));
                }
                else if (powerLevel < 6){
                    GamePanel.bullets.add(new Bullet(270,x,y));
                    GamePanel.bullets.add(new Bullet(275,x + 5,y));
                    GamePanel.bullets.add(new Bullet(265,x - 5,y));
                }
                else if (powerLevel < 8){
                    GamePanel.bullets.add(new Bullet(270,x + 5,y));
                    GamePanel.bullets.add(new Bullet(270,x - 5,y));
                    GamePanel.bullets.add(new Bullet(275,x + 10,y));
                    GamePanel.bullets.add(new Bullet(265,x - 10,y));
                }
                else if (powerLevel < 10){
                    GamePanel.bullets.add(new Bullet(270,x + 5,y));
                    GamePanel.bullets.add(new Bullet(270,x - 5,y));
                    GamePanel.bullets.add(new Bullet(275,x + 10,y));
                    GamePanel.bullets.add(new Bullet(265,x - 10,y));
                    for (int i = 0; i < GamePanel.bullets.size(); i++){
                        Bullet b = GamePanel.bullets.get(i);
                        b.setR((int)(3*1.2));
                    }
                }
                else{
                    GamePanel.bullets.add(new Bullet(270,x + 5,y));
                    GamePanel.bullets.add(new Bullet(270,x - 5,y));
                    GamePanel.bullets.add(new Bullet(275,x + 10,y));
                    GamePanel.bullets.add(new Bullet(265,x - 10,y));
                    for (int i = 0; i < GamePanel.bullets.size(); i++){
                        Bullet b = GamePanel.bullets.get(i);
                        b.setR((int)(b.getR()*1.5));
                    }
                }
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

        // логика таймера восстановления
        if (recovering){
            long past = (System.nanoTime() - recoveryTimer) / 1000000;
            if (past > recoveryDelay){ // после удара 2 секунды неуязвимости
                recovering = false;
                recoveryTimer = 0;
            }
        }
    }

    public void draw(Graphics2D g){
        if (recovering){
            g.drawImage(hit_player_icon,x-icon_width/2,y,null);
        }
        else{
            g.drawImage(player_icon,x-icon_width/2, y, null);
        }
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
    public boolean isRecovering(){return this.recovering;}

    public int getMaxPowerLevel(){return this.maxPowerLevel;}

    //если игрок столкнулся со врагом
    public void loseLife(){
        lives--;
        recovering = true; // после получения удара начинает восстанавливаться
        recoveryTimer = System.nanoTime(); // начинается отсчет времени восстановления
    }

    public void gainLife(){
        this.lives++;
    }

    public void increasePower(int i){
        power += i;
        if (power >= requiredPower[powerLevel]){
            power-=requiredPower[powerLevel];
            if (powerLevel < maxPowerLevel){
                powerLevel++;
            }
        }
    }
    public int getPowerLevel(){return powerLevel;}
    public int getPower(){return power;}
    public int getRequiredPower(){return requiredPower[powerLevel];}
    public int getScore() {
        return score;
    }
    public void addScore(int i){
        score += i;
    }
}
