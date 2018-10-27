package com.Kurs;

public class Client {
    private String name;
    private static int nextID=1;
    private int ID;
    private String password;
    private Account account;

    public Client(String name, String password, Account account) {
        this.name = name;
        this.password = password;
        this.account = account;
        this.ID = nextID;
        nextID++;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public Account getAccount() {
        return account;
    }

    public boolean checkCredentials(int id, String password){
        boolean match = (this.ID==id)&&(this.password.equals(password));
        return match;
    }
}
