package ru.mirea.task14.StackTask;

import java.util.Scanner;
import java.util.Stack;

public class Player {
    private Stack<Card> cards;
    Scanner sc = new Scanner(System.in);
    public Player() {
        Card card;
        String str;
        str = sc.nextLine();
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            if (Character.isDigit(s[i])){
                card = new Card(s[i]);
                cards.push(card);
            }
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
