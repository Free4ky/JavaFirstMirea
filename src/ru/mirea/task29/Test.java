package ru.mirea.task29;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //создаем наш объект
        String[] UserId = {"Name1", "Name2", "Name3"};
        String[] UserPassword = {"123", "321", "aaa"};
        double[] UserBalance = {2134.4,23422.1, 444.3};

        CurrencyInfo currencyInfo = new CurrencyInfo(UserId, UserPassword, UserBalance);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream("C:\\Programming projects\\Java\\TestFile.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем объект в файл
        objectOutputStream.writeObject(currencyInfo);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\Programming projects\\Java\\TestFile.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        CurrencyInfo currencyInfo2 = (CurrencyInfo) objectInputStream.readObject();

        System.out.println(currencyInfo2);
    }
}
