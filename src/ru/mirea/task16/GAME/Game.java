package ru.mirea.task16.GAME;

import javax.swing.*;

public class Game extends JFrame {
    public static void main(String[] args){
        JFrame window = new JFrame("Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setContentPane(new GamePanel()); // передача контента GamePanel

        window.pack();
        window.setVisible(true);
    }
}
