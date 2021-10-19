package ru.mirea.task15.FileTask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWork {
    public static void main(String[] args){
        //1. Реализовать запись в файл введённой с клавиатуры информации.
        String UserText;
        Scanner sc = new Scanner(System.in);
        UserText = sc.nextLine();
        try(FileWriter writer = new FileWriter("C:\\Новая Папка\\JavaFileTask.txt", false)) {
            writer.write(UserText);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //2. Реализовать вывод информации из файла на экран.
        try(FileReader reader = new FileReader("C:\\Новая Папка\\JavaFileTask.txt")){
            int c = 0;
            while ((c = reader.read()) != -1){
                System.out.print((char)c);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        //3. Заменить информацию в файле на информацию, введённую с клавиатуры.
        UserText = sc.nextLine();
        try(FileWriter writer = new FileWriter("C:\\Новая Папка\\JavaFileTask.txt", false)) {
            writer.write(UserText);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //4. Добавить в конец исходного файла текст, введённый с клавиатуры.
        UserText = sc.nextLine();
        try(FileWriter writer = new FileWriter("C:\\Новая Папка\\JavaFileTask.txt", true)) {
            writer.write(UserText);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
