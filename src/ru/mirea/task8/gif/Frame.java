package ru.mirea.task8.gif;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import javax.swing.*;

public class Frame extends JFrame {
    public Frame()
    {
        super("Gif");
        add(new Image_class());
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}