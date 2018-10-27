package com.Kurs;

import java.util.*;

public class Bank {
    private Set<Account> accountSet = new HashSet<>();
    private Set<Client> clientSet = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank pko = new Bank();
        pko.clientSet.add(new Client("Bartosz Jażwa", "xxxx", new Account()));
        pko.clientSet.add(new Client("Jan Nowak","yyyy", new Account()));
        pko.clientSet.add(new Client("Adam Kowalski","zzz", new Account()));

        System.out.println("Podaj ID klienta");
        int clientID = pko.scanner.nextInt();
        System.out.println("Podaj haslo");
        String clientPass = pko.scanner.next();
        Client loggedClient = pko.login(clientID,clientPass);
        if (loggedClient!=null){
            System.out.println("Zalogowano "+loggedClient.getName()+" ,ID:"+loggedClient.getID());
            int accountAction;
            do {
                System.out.println("Wybierz operację do wykonania \n" +
                        "1 - sprawdz stan konta \n" +
                        "2 - wypłać \n" +
                        "3 - zdeponuj \n" +
                        "0 - wyloguj się");
                accountAction = pko.scanner.nextInt();
                switch (accountAction){
                    case 1:
                        System.out.println("Stan konta "+loggedClient.getAccount().getBalance());
                        break;

                    case 2:
                        System.out.println("Podaj kwotę do wypłacenia");
                        float withdrawAmount = pko.scanner.nextFloat();
                        loggedClient.getAccount().withdraw(withdrawAmount);
                        System.out.println("Na koncie pozostało: "+loggedClient.getAccount().getBalance());
                        break;

                    case 3:
                        System.out.println("Podaj kwotę do zdeponowania");
                        float depositAmount = pko.scanner.nextFloat();
                        loggedClient.getAccount().deposit(depositAmount);
                        System.out.println("Stan konta: "+loggedClient.getAccount().getBalance());
                        break;
                }

            }while (accountAction!=0);


        }else {
            System.out.println("Nieprawidłowy login lub hasło");
        }

    }
    public Client login(int ID, String password){
        boolean clientExist = clientSet.stream()
                .anyMatch(c->c.checkCredentials(ID,password));
        if (!clientExist){
            return null;
        }
        Client client= clientSet.stream()
                    .filter(c->c.checkCredentials(ID,password))
                    .findFirst()
                    .get();

        return client;
    }
}
