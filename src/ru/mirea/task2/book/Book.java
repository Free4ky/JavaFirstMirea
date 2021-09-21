package ru.mirea.task2.book;

public class Book {
    private String author;
    private int year;
    private String name;
    public Book(String name,String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }
    public Book(){
        name = "book";
        author = "no one";
        year = 0;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear() {
        return year;
    }
    @Override
    public String toString(){
        return this.name + " " + this.author + " " + this.year;
    }
}
