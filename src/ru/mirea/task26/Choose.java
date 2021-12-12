package ru.mirea.task26;

public class Choose {
    PaymentMethod paymentMethod;
    void setPaymentMethod(int payment_method)
    {
        switch (payment_method){
            case 1:
                paymentMethod = new ByCreditCard();
                paymentMethod.setInfo();
                break;
            case 2:
                paymentMethod = new ByEWallet();
                paymentMethod.setInfo();
                break;
        }
    }
    void pay(double money) {
        paymentMethod.pay(money);
    }
}
