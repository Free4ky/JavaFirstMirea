package ru.mirea.task26;

import java.util.Scanner;

public class ByEWallet implements PaymentMethod{
    public EWallet eWallet;
    public void setInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter login:");
        String login = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.next();

        eWallet = new EWallet(login,password,Math.random()*50000);
    }
    @Override
    public void pay(double money){
        if (money > eWallet.balance)
        {
            System.out.println("Can't buy product, not enough money");
        }
        else
        {
            System.out.println("Operation succeed!\nYour balance changed from ");
            System.out.println(eWallet.getBalance());
            eWallet.spend(money);
            System.out.println("to ");
            System.out.println(eWallet.getBalance());
        }
    }
}
