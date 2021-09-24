package ru.mirea.task8.image;
import ru.mirea.task8.shapes.Frame;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.imageio.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Image_class extends JPanel {
    private Image image;
    private String path;
    public Image_class()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            path = sc.next();
            image = ImageIO.read(new File(path));
            image = image.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void paintComponent(Graphics p)
    {
        super.paintComponent(p);
        p.drawImage(image,150,150,null);
    }
}

