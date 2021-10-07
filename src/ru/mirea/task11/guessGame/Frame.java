package ru.mirea.task11.guessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private int randomNumber;
    int AttemptCounter = 0;
    public Frame()
    {
        super("Guess game!");
        this.randomNumber = (int)(Math.random()*20);
        setSize(500,500);
        setLayout(new GridLayout(4,1));
        JPanel[] pnl = new JPanel[4];
        for(int i = 0 ; i < pnl.length ; i++)
        {
            int r = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            pnl[i] = new JPanel();
            pnl[i].setBackground(new Color(r,g,b));
            add(pnl[i]);
        }
        JLabel header = new JLabel("Guess number in range from 1 to 20!");
        pnl[0].setLayout(new BorderLayout());
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Times new Roman", Font.BOLD,30));
        pnl[0].add(header,BorderLayout.CENTER);

        JTextField GuessNumber = new JTextField(3);
        pnl[2].setLayout(new GridLayout(3,1));
        JPanel[] p = new JPanel[3];
        for (int i = 0; i < p.length; i++)
        {
            p[i] = new JPanel();
            pnl[2].add(p[i]);
            p[i].setBackground(Color.WHITE);
        }
        p[1].setLayout(new FlowLayout());
        JLabel input = new JLabel("Input your number: ");
        input.setFont(new Font("Times new Roman", Font.BOLD,20));
        p[1].add(input);
        p[1].add(GuessNumber);

        JButton enter = new JButton("Enter");
        JLabel Output = new JLabel("");
        Output.setFont(new Font("Times new Roman", Font.BOLD,20));
        pnl[1].setLayout(new BorderLayout());
        Output.setHorizontalAlignment(SwingConstants.CENTER);
        pnl[1].add(Output);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int UserNumber = Integer.parseInt(GuessNumber.getText());

                    if (UserNumber < randomNumber)
                    {
                        Output.setText("Nope, your number is less than my");
                    }
                    else if (UserNumber > randomNumber)
                    {
                        Output.setText("Wow, slow down boy, yor number is too big ;)");
                    }
                    else{
                        Output.setText("Nahhh, you won ;(");
                        AttemptCounter = 0;
                    }
                    if (AttemptCounter >= 3)
                    {
                        Output.setText("Game Over, looooser ;) My number is " + randomNumber);
                    }
                    AttemptCounter++;
                }
                catch (Exception ae)
                {
                    AttemptCounter = 0;
                }
            }
        });
        pnl[3].setLayout(new GridLayout(3,1));
        JPanel[] q = new JPanel[3];
        for (int i = 0; i < q.length; i++)
        {
            q[i] = new JPanel();
            pnl[3].add(q[i]);
            q[i].setBackground(Color.YELLOW);
        }
        q[1].add(enter);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args)
    {
        Frame example = new Frame();
    }
}