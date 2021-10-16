package ru.mirea.task14.StackTask;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int steps_counter = 0;
    private ArrayList<Card> buffer = new ArrayList<>();
    public Game() {}

    public void execute() {
        Player player1 = new Player();
        Player player2 = new Player();
        Card f_card;
        Card s_card;
        while (true)
        {
            if (steps_counter > 106)
            {
                System.out.println("botva");
                break;
            }
            if (player1.getCards().size() == 0)
            {
                System.out.print("second ");
                System.out.println(steps_counter);
                break;
            }
            if(player2.getCards().size() == 0)
            {
                System.out.print("first ");
                System.out.println(steps_counter);
                break;
            }
            f_card = player1.getCards().pop();
            s_card = player2.getCards().pop();
            if (Card.comparator(f_card,s_card))
            {
                receiveCard(player1, f_card,s_card);
            }
            else
            {
                receiveCard(player2, f_card,s_card);
            }
            steps_counter++;
        }
    }
    public void receiveCard(Player player, Card f_card, Card s_card)
    {
        if (player.getCards().isEmpty()){return;}
        while (player.getCards().size() > 0)
        {
            buffer.add(player.getCards().pop());
        }
        player.getCards().push(s_card);
        player.getCards().push(f_card);
        Card[] deck = buffer.toArray(new Card[0]);
        for (int i = deck.length - 1; i >= 0; i--)
        {
            player.getCards().push(deck[i]);
        }
        buffer.clear();
    }
    public  static void main(String[] args)
    {
        Game start = new Game();
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Start a game? Input 'yes' if you want to start: ");
        s = sc.nextLine();
        if (s.equals("yes") || s.equals("Yes"))
        {
            while (!s.equals("exit"))
            {
                System.out.println("New game!");
                start.execute();
                System.out.print("Input 'exit' if you want to stop: ");
                s = sc.nextLine();
            }
        }
        else
        {
            System.out.print("Bye!");
        }
    }
}