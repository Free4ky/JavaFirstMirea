package ru.mirea.task8.gif;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
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
}