package main;

import java.util.ArrayList;

import main.components.*;


// 1.1.2 Creation of Main class for tests
// 1.2.3 Creation of the tablea account
public class Main {
    static ArrayList<Client> clients;
    static ArrayList<Account> accounts;
    public static void main(String[] args) {
        Main.clients = generateClients(4);
        displayClient(Main.clients);

        Main.accounts = generateAccounts(Main.clients);
        displayAccounts(Main.accounts);
    }

    public static ArrayList<Client> generateClients (int number) {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            Client newClient = new Client("name"+i, "firstName"+i);
            clients.add(newClient);
        }
        return clients;
    }

    public static ArrayList<Account> generateAccounts (ArrayList<Client> clients) {
        ArrayList<Account> accounts = new ArrayList<>();
        for (Client client : clients) {
            Account newCurrentAccount = new CurrentAccount("Current", client);
            Account newSavingsAccount = new SavingsAccount("Savings", client);

            accounts.add(newCurrentAccount);
            accounts.add(newSavingsAccount);
        }
        return accounts;
    }

    public static void displayClient(ArrayList<Client> clients) {
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public static void displayAccounts(ArrayList<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
