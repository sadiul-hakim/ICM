package xyz.sadiulhakim.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String username;
    private String password;
    private double balance;
    private int index;
    private List<Transaction> transactions = new ArrayList<>();

    public Data() {
    }

    public Data(String username, String password, double balance, int index, List<Transaction> transactions) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.index = index;
        this.transactions = transactions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
