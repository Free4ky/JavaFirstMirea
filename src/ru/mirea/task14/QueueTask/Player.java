package ru.mirea.task14.QueueTask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Player {
    private Queue<Card> cards = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public Player() {
        Card card;
        String str;
        str = sc.nextLine();
        //str = reverseString(str);
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            if (Character.isDigit(s[i])){
                card = new Card(s[i] - '0');
                cards.add(card);
            }
        }
    }
    public Queue<Card> getCards() {
        return cards;
    }
}
