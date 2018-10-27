package com.Kurs;

public class Account {
    private int number;
    private static int nextNumber=1;
    private float balance;
    private Client client;

    public Account() {
        this(0);
    }

    public Account(float balance) {
        this.balance = balance;
        this.number = nextNumber;
        nextNumber++;
    }

    public void withdraw(float sum){
        if (this.balance-sum>=0){
            this.balance-=sum;
        }else {
            this.balance = 0;
        }
    }
    public void deposit(float sum){
        this.balance+=sum;
    }

    public Client getClient() {
        return client;
    }

    public float getBalance() {
        return balance;
    }
}
