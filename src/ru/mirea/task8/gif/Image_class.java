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
    private Image image1;
    public Image_class() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int k = 0;
            @Override
            public void run() {
                    try {
                        switch (k) {
/*                          case 0:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\1r.jpg"));
                                break;
                            case 1:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\2r.jpg"));
                                break;
                            case 2:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\3r.jpg"));
                                break;
                            case 3:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\4r.jpg"));
                                break;
                            case 4:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\5r.jpg"));
                                break;
                            case 5:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\6r.jpg"));
                                break;
                            case 6:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\7r.jpg"));
                                break;
                            case 7:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\8r.jpg"));
                                break;
                            case 8:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\9r.jpg"));
                                break;
                            case 9:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\10r.jpg"));
                                break;
                            case 10:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\11r.jpg"));
                                break;
                            case 11:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\12r.jpg"));
                                break;
                            case 12:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\13r.jpg"));
                                break;
                            case 13:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\14r.jpg"));
                                break;
                            case 14:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\15r.jpg"));
                                break;
                            case 15:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\16r.jpg"));
                                break;
                            case 16:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\17r.jpg"));
                                break;
                            case 17:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\18r.jpg"));
                                break;
                            case 18:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\19r.jpg"));
                                break;
                            case 19:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images2\\20r.jpg"));
                                break;
                       */
                            case 0:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок.PNG"));
                                break;
                            case 1:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок1.PNG"));
                                break;
                            case 2:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок2.PNG"));
                                break;
                            case 3:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок3.PNG"));
                                break;
                            case 4:
                                image1 = ImageIO.read(new File("C:\\Users\\Den\\IdeaProjects\\JavaFirstMirea\\src\\images\\Снимок4.PNG"));
                                break;
                        }
                } catch (IOException e){
                    e.printStackTrace();
                }
                image1 = image1.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
                k++;
                if (k == 5)
                {
                    k = 0;
                }
                repaint();
            }
        };
        timer.schedule(task,1,150);
    }
    public void paintComponent(Graphics p)
    {
        super.paintComponent(p);
        //p.drawImage(image1,150,150,null);
        p.drawImage(image1,0,0,null);
    }
}

