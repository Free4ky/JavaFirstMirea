package ru.mirea.task26;

import java.util.Scanner;

public class ByCreditCard implements PaymentMethod{
    public CreditCard creditCard;
    @Override
    public void setInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter card number:");
        String cardNum = sc.nextLine();
        System.out.println("Enter cvv number:");
        int cvv = sc.nextInt();
        System.out.println("Enter name:");
        String name = sc.next();
        System.out.println("Enter surname:");
        String surname = sc.next();

        creditCard = new CreditCard(cardNum,cvv,name,surname,Math.random()*50000);
    }
    @Override
    public void pay(double money){
        if (money > creditCard.balance)
        {
            System.out.println("Can't buy product, not enough money");
        }
        else
        {
            System.out.println("Operation succeed!\nYour balance changed from ");
            System.out.println(creditCard.getBalance());
            creditCard.spend(money);
            System.out.println("to ");
            System.out.println(creditCard.getBalance());
        }
    }
}
