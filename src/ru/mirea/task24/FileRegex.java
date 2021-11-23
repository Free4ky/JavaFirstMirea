package ru.mirea.task24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRegex {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter player's place:");
        String place = sc.next();
        Pattern pattern = Pattern.compile("^"+ "place: " + place + ".*");
        Matcher matcher;
        try(FileReader reader = new FileReader("C:\\Новая папка\\PlayersScore.txt")){

            BufferedReader breader = new BufferedReader(reader);
            String line = breader.readLine();
            while (line != null)
            {
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(line.substring(matcher.start(), matcher.end()));
                }
                line = breader.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

//Поиск информации в файле, содержащем информацию о рекордах игроков. Поиск производится по позиции игрока в текущем рейтинге.

// Содержание файла:

//place: 1 Score: 777888 Name: Danil
//place: 2 Score: 77788 Name: Ivan
//place: 3 Score: 7778 Name: Dmitry
//place: 4 Score: 777 Name: Vova