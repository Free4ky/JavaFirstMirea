package ru.mirea.task8.image;

import ru.mirea.task8.shapes.FramePainter;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame()
    {
        super("Shapes");
        add(new Image_class());
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args)
    {
        Frame example = new Frame();
    }
}
