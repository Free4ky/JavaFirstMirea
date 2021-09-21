package ru.mirea.task4.author;

import java.util.Scanner;
public class Author
{
    private String name;
    private String email;
    private char gender;
    public Author (String name, String email, char gender)
    {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public char getGender()
    {
        return this.gender;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    @Override
    public String toString ()
    {
        return name + "(" + gender + ") at " + email;
    }
}
