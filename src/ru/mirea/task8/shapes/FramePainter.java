package ru.mirea.task8.shapes;

import java.awt.*;
import javax.swing.*;

public class FramePainter extends JPanel {
    private int width;
    private int length;
    public void paintComponent(Graphics p) {
        int generated_number;
        for (int i = 0; i < 20; i++) {
            generated_number = (int) (Math.random() * 4);
            switch (generated_number) {
                case 0:
                    Rectangle ob = new Rectangle();
                    p.setColor(new Color(ob.getRColor(), ob.getGColor(), ob.getBColor()));
                    ob.setX(ob.getWidth(), width);
                    ob.setY(ob.getLength(),length);
                    p.fillRect(ob.getX(), ob.getY(), ob.getWidth(), ob.getLength());
                    break;
                case 1:
                    Circle ob1 = new Circle();
                    p.setColor(new Color(ob1.getRColor(), ob1.getGColor(), ob1.getBColor()));
                    ob1.setX(ob1.getRadius(),width);
                    ob1.setY(ob1.getRadius(),length);
                    p.fillOval(ob1.getX(), ob1.getY(), ob1.getRadius(), ob1.getRadius());
                    break;
                case 2:
                    Square ob2 = new Square();
                    p.setColor(new Color(ob2.getRColor(), ob2.getGColor(), ob2.getBColor()));
                    ob2.setX(ob2.getSide(),width);
                    ob2.setY(ob2.getSide(),length);
                    p.fillRect(ob2.getX(), ob2.getY(), ob2.getSide(), ob2.getSide());
                    break;
                case 3:
                    Oval ob3 = new Oval();
                    p.setColor(new Color(ob3.getRColor(),ob3.getGColor(),ob3.getBColor()));
                    ob3.setX(ob3.getWidth(),width);
                    ob3.setY(ob3.getLength(),length);
                    p.fillOval(ob3.getX(),ob3.getY(),ob3.getWidth(),ob3.getLength());
            }
        }
    }
    public FramePainter(int width, int length) {
        this.width = width;
        this.length = length;
    }
}
