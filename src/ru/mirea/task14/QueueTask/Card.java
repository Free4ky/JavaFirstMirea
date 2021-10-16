package ru.mirea.task14.QueueTask;

public class Card {
    private int value;
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Card(int value)
    {
        this.value = value;
    }
    public static boolean comparator(Card first, Card second) {
        if (first.getValue() == 0 && second.getValue() == 9) {
            return true;
        } else if (first.getValue() > second.getValue()) {
            return true;
        }
        return false;
    }
}
