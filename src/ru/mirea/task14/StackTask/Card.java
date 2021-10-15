package ru.mirea.task14.StackTask;

public class Card {
    private int value;
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Card(int value) {
        this.value = value;
    }
    public boolean comparator(Card first, Card second){
        if (first.getValue() == 0 && second.getValue() == 9){
            return true;
        }
        else if(first.getValue() > second.getValue()){
            return true;
        }
        return  false;
    }
}
