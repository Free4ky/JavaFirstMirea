package ru.mirea.task9.table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private int FirstCommandGoals;
    private int SecondCommandGoals;
    private String FirstCommandName;
    private String SecondCommandName;
    private String LastSoccer;
    public String isWinner()
    {
        if (this.FirstCommandGoals > this.SecondCommandGoals)
        {
            return this.FirstCommandName;
        }
        else if (this.FirstCommandGoals < this.SecondCommandGoals)
        {
            return this.SecondCommandName;
        }
        else
        {
            return "DRAW";
        }
    }
    //JTextField score = new JTextField(10);

    public Frame()
    {
        super("Table");
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

        this.FirstCommandName = "CSK";
        this.SecondCommandName = "Spartak";
        this.SecondCommandGoals = 0;
        this.SecondCommandGoals = 0;
        JButton FirstCommand = new JButton(this.FirstCommandName + " golas!");
        JButton SecondCommand = new JButton(this.SecondCommandName + " golas!");
        JLabel score = new JLabel(this.FirstCommandGoals + " X " + this.SecondCommandGoals);
        JLabel LstScr = new JLabel("Last Soccer: N/A");
        JLabel Wnr = new JLabel("Winner: " + isWinner());
        score.setFont(new Font("Times new Roman", Font.BOLD,40));
        LstScr.setFont(new Font("Times new Roman", Font.BOLD,20));
        Wnr.setFont(new Font("Times new Roman", Font.BOLD,20));
        setSize(500,500);
        pnl[0].setLayout(new BorderLayout());
        score.setHorizontalAlignment(SwingConstants.CENTER);
        pnl[0].add(score, BorderLayout.CENTER);
        FirstCommand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstCommandGoals++;
                LastSoccer = FirstCommandName;
                score.setText(FirstCommandGoals + " X " + SecondCommandGoals);
                LstScr.setText("Last Soccer: " + LastSoccer);
                Wnr.setText("Winner: " + isWinner());
            }
        });
        SecondCommand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecondCommandGoals++;
                LastSoccer = SecondCommandName;
                score.setText(FirstCommandGoals + " X " + SecondCommandGoals);
                LstScr.setText("Last Soccer: " + LastSoccer);
                Wnr.setText("Winner: " + isWinner());
            }
        });
        pnl[1].setLayout(new GridLayout(3,1));
        JPanel[] p = new JPanel[3];
        for (int i = 0; i < p.length; i++)
        {
            p[i] = new JPanel();
            pnl[1].add(p[i]);
        }
        p[1].setLayout(new FlowLayout());
        FirstCommand.setPreferredSize(new Dimension(200,30));
        SecondCommand.setPreferredSize(new Dimension(200,30));
        p[1].add(FirstCommand);
        p[1].add(SecondCommand);
        pnl[2].setLayout(new BorderLayout());
        LstScr.setHorizontalAlignment(SwingConstants.CENTER);
        pnl[2].add(LstScr,BorderLayout.CENTER);
        pnl[3].setLayout(new BorderLayout());
        Wnr.setHorizontalAlignment(SwingConstants.CENTER);
        pnl[3].add(Wnr,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[]args)
    {
       Frame example = new Frame();
    }
}
