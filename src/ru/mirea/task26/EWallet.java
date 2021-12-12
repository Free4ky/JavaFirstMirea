package ru.mirea.task26;

public class EWallet {
    private String login;
    private String password;

    double balance;

    public EWallet(String login, String password, double balance) {
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    void spend(double money){this.balance -= money;}
}
