package ru.mirea.task29;

import java.io.Serializable;
import java.util.Arrays;

public class CurrencyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] UserId;
    private String[] UserPassword;
    private double[] UserBalance;

    public CurrencyInfo(String[] UserId, String[] UserPassword, double[] UserBalance){
        this.UserId = UserId;
        this.UserPassword = UserPassword;
        this.UserBalance = UserBalance;
    }

    public String[] getUserId() {
        return UserId;
    }

    public void setUserId(String[] UserId) {
        this.UserId = UserId;
    }

    public String[] getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String[] UserPassword) {
        this.UserPassword = UserPassword;
    }

    public double[] getUserBalance() {
        return UserBalance;
    }

    public void setUserBalance(double[] UserBalance) {
        this.UserBalance = UserBalance;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "UserId=" + Arrays.toString(UserId) +
                ", UserPassword=" + Arrays.toString(UserPassword) +
                ", UserBalance=" + Arrays.toString(UserBalance) +
                '}';
    }
}
