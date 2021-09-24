package ru.mirea.task8.shapes;

import javax.swing.*;

public class Frame extends JFrame{
    static private int width;
    static private int length;
    public Frame()
    {
        super("Shapes");
        this.width = 800;
        this.length = 800;
        setSize(width,length);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new FramePainter(width,length));
    }
    public static void main(String[]args)
    {
        Frame test = new Frame();
    }
}
