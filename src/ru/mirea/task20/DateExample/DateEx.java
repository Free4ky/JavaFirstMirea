package ru.mirea.task20.DateExample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class DateEx {
    public static void main(String[] args) {
        String path;
        int record = 100;
        int users_score;
        Scanner sc = new Scanner(System.in);
        path = sc.nextLine();
        users_score = sc.nextInt();
        Date when_player_set_a_record = null;
        if (users_score > record) {
            when_player_set_a_record = new Date();
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.write(users_score + " ");
                writer.write(String.valueOf(when_player_set_a_record));
                writer.append('\n');
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
//C:\Новая Папка\JavaFileTask.txt