package ru.mirea.task16.GAME;

import java.awt.*;

public class Text {
    //FIELDS
    private double x;
    private double y;
    private long time;
    private long start;
    private String s;

    //CONSTRUCTOR
    public Text(double x, double y, long time,String s){
        this.x = x;
        this.y = y;
        this.time = time;
        this.s = s;
        start = System.nanoTime();
    }

    public boolean update(){
        long elapsed = (System.nanoTime() - start)/1000000;
        if (elapsed > time){
            return true;
        }
        return false;
    }
    public void draw(Graphics2D g){
        g.setFont(new Font("Century Gothic",Font.PLAIN,12));
        long elapsed = (System.nanoTime() - start)/1000000;
        int alpha = (int)(255*Math.sin(3.14 * elapsed/time)); // задает прозрачность
        if (alpha >= 250){
            alpha = 250;
        }
        else if (alpha < 0) {
            alpha = 0;
        }
        g.setColor(new Color(255,255,255,alpha));
        int length = (int) g.getFontMetrics().getStringBounds(s,g).getWidth(); // длина строки в пикселях
        g.drawString(s,(int)(x -length/2),(int)y);
    }
}
