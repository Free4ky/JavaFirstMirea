package ru.mirea.task16.GAME;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

enum power_type{
    addExtraLife, addOnePower, addTwoPower, slowTime
}

//addExtraLife - +1 life
//addOnePower - +1 power
//addTwoPower - +2 power
//slowTme - slow down time
public class PowerUp {
    //FIELDS
    private double x;
    private double y;
    private int r;
    private power_type powerType;

    private BufferedImage powerUp_icon;


    //private BufferedImage powerUp2_icon;
    //private BufferedImage addExtraLife_icon;

    // нет полей dx,dy потому что будет двигаться просто вниз

    //CONSTRUCTOR
    public PowerUp(power_type powerType, double x, double y){
        this.x = x;
        this.y = y;
        this.powerType = powerType;

        BufferedImage buf;
        try{
            switch (powerType){
                case addExtraLife:
                    r = 15;
                    buf = ImageIO.read(new File("C:\\Users\\Den Ka\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\addHealthPowerUp.png"));
                    powerUp_icon = resize(buf,r,r);
                    break;
                case addOnePower:
                    r = 20;
                    buf = ImageIO.read(new File("C:\\Users\\Den Ka\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\powerUp_icon.png"));
                    powerUp_icon = resize(buf,r,r);
                    break;
                case addTwoPower:
                    r = 20;
                    buf = ImageIO.read(new File("C:\\Users\\Den Ka\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\powerUp_icon2_1.png"));
                    powerUp_icon = resize(buf,r,r);
                    break;
                case slowTime:
                    r = 20;
                    buf = ImageIO.read(new File("C:\\Users\\Den Ka\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task16\\GAME\\Sprites\\slowTime.png"));
                    powerUp_icon = resize(buf,r,r);
                    break;
            }
        }catch (Exception e){}
    }

    // FUNCTIONS
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getR() {
        return r;
    }
    public power_type getPowerType(){
        return this.powerType;
    }

    public boolean update(){
        y+=2; // приращение по y

        if (y > GamePanel.HEIGHT + r){ // если припас вышел за границы
            return true; // значит удаляем его
        }

        return false;
    }
    public void draw(Graphics2D g){
        g.drawImage(powerUp_icon,(int)(x - r/2),(int)(y-r/2),null);
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
