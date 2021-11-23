package ru.mirea.task24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EEEX {
    public static void main(String[] args) {
        String text = "Егор Алла Александр";
        Pattern pattern = Pattern.compile("А.+а");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}
