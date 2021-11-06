package ru.mirea.task18.FileException;

import java.io.*;
import java.util.Scanner;
// исключение обрабатывает открытие файла со списком рейтинга игроков
public class FileExceptionExample {
    public static void main(String[] args) throws Exception {
        FileReader reader = null;
        String path;
        Scanner sc = new Scanner(System.in);
        boolean isFileFound = true;
        path = sc.nextLine();
        try {
            reader = new FileReader(path);
            int c = 0;
            while ((c = reader.read()) != -1){
                System.out.print((char)c);
            }
        }
        catch (FileNotFoundException ex) {
            isFileFound = false;
            System.out.println("FileNotFoundException");
        }
        finally {
            if (isFileFound)
            {
                reader.close();
            }
        }
    }
}
