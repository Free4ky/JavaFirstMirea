package ru.mirea.task26;

public class CreditCard {
    private String number;
    private int cvv;
    private String name;
    private String surname;

    double balance;

    public CreditCard(String number,int cvv,String name,String surname,double balance)
    {
        this.number = number;
        this.cvv = cvv;
        this.name = name;
        this.surname = name;
        this.balance = balance;
    }
    double getBalance(){return balance;}
    void spend(double money){this.balance -= money;}
}
