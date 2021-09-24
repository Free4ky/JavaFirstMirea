package ru.mirea.task8.gif;

import ru.mirea.task8.shapes.Frame;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.imageio.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;

public class Image_class extends JPanel {
    private Image image;
    public Image_class() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                try {
                    switch (i) {
                        case 0:
                            image = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок.PNG"));
                        case 1:
                            image = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок1.PNG"));
                            break;
                        case 2:
                            image = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок2.PNG"));
                            break;
                        case 3:
                            image = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок3.PNG"));
                            break;
                        case 4:
                            image = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок4.PNG"));
                            break;
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                image = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                i++;
                if(i == 5)
                {
                    i = 0;
                }
                repaint();
            }
        };
        timer.schedule(task,1,100);
    }
    public void paintComponent(Graphics p)
    {
        super.paintComponent(p);
        p.drawImage(image,150,150,null);
    }
}