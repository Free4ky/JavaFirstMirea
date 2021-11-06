package ru.mirea.task17.places;

enum PLACE {
    FIRST,SECOND,THIRD
}
public class PlayersPlaces {
    public static void main(String[] args) {
        PLACE pl;
        pl = PLACE.FIRST;
        System.out.println("Значение pl: " + pl);
        System.out.println();

        pl = PLACE.SECOND;

        if (pl == PLACE.SECOND)
        {
            System.out.println("Переменная pl содержит SECOND");
        }
        pl = PLACE.THIRD;
        switch (pl)
        {
            case FIRST:
                System.out.println("Игрок занимает первое место в рейтинге");
                break;
            case SECOND:
                System.out.println("Игрок занимает второе место в рейтинге");
                break;
            case THIRD:
                System.out.println("Игрок занимает третье место в рейтинге");
                break;
        }
    }
}
