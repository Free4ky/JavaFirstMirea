package ru.mirea.task14.DoubleListTask;

import ru.mirea.task14.DequeueTask.Player;
import ru.mirea.task14.QueueTask.Card;

public class Game {
    private int steps_counter = 0;

    public Game() {
    }

    public void execute() {
        Player player1 = new Player();
        Player player2 = new Player();
        Card f_card;
        Card s_card;
        while (true) {
            f_card = player1.getCards().poll();
            s_card = player2.getCards().poll();
            steps_counter++;
            if (steps_counter > 106) {
                System.out.println("botva");
                break;
            }
            if (player1.getCards().size() == 0) {
                System.out.print("second ");
                System.out.print(steps_counter);
                break;
            }
            if (player2.getCards().size() == 0) {
                System.out.print("first ");
                System.out.print(steps_counter);
                break;
            }
            if (Card.comparator(f_card, s_card)) {
                player1.getCards().add(f_card);
                player1.getCards().add(s_card);
            } else {
                player2.getCards().add(f_card);
                player2.getCards().add(s_card);
            }
        }
    }

    public static void main(String[] args) {
        Game start = new Game();
        start.execute();
    }
}
