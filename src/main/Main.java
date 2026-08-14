package main;

import java.util.ArrayList;
import java.util.Hashtable;

import main.components.*;

// 1.1.2 Creation of Main class for tests
// 1.2.3 Creation of the tablea account
// 1.3.1 Adaptation of the table of accounts
public class Main {


    public static void main(String[] args) {
        ArrayList<Client> clients;
        ArrayList<Account> accounts;
        Hashtable<Integer, Account> accountsHashtable;

        clients = generateClients(4);
        displayClient(clients);

        accounts = generateAccounts(clients);
        displayAccounts(accounts);

        accountsHashtable = genenateAccountHashtable(accounts);
        displayAccountsHastable(accountsHashtable);

    }

    public static ArrayList<Client> generateClients(int number) {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            Client newClient = new Client("name" + i, "firstName" + i);
            clients.add(newClient);
        }
        return clients;
    }

    public static ArrayList<Account> generateAccounts(ArrayList<Client> clients) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Client client : clients) {
            Account newCurrentAccount = new CurrentAccount("Current", client);
            Account newSavingsAccount = new SavingsAccount("Savings", client);

            accounts.add(newCurrentAccount);
            accounts.add(newSavingsAccount);
        }
        return accounts;
    }

    public static Hashtable<Integer, Account> genenateAccountHashtable(ArrayList<Account> accounts) {
        Hashtable<Integer, Account> accountsHashtable = new Hashtable<>();
        for (Account account : accounts) {
            accountsHashtable.put(account.getAccountNumber(), account);
        }
        return accountsHashtable;
    }

    public static void displayClient(ArrayList<Client> clients) {
        clients.stream().forEach(System.out::println);
    }

    public static void displayAccounts(ArrayList<Account> accounts) {
        accounts.stream().forEach(System.out::println);
    }

    public static void displayAccountsHastable(Hashtable<Integer, Account> accountsHashtable) {
        accountsHashtable.entrySet().stream()
            .sorted((account1, account2) -> account1.getValue().getBalance().compareTo(account2.getValue().getBalance()))
            .forEach(System.out::println);
    }
}
