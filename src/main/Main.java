package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Optional;
import java.util.function.Predicate;

import main.components.*;

public class Main {
    static private ArrayList<Client> clients;
    static private ArrayList<Account> accounts;
    static private Hashtable<Integer, Account> accountsHashtable;
    static private ArrayList<Flow> flows;

    public static void main(String[] args) {

        clients = generateClients(4);
        accounts = generateAccounts(clients);
        accountsHashtable = genenateAccountHashtable(accounts);
        flows = generateFlows();
        updateAccount(flows, accountsHashtable);


        displayClient(clients);
        displayAccounts(accounts);
        displayAccountsHastable(accountsHashtable);

    }

    // 1.1.2 Creation of Main class for tests
    public static ArrayList<Client> generateClients(int number) {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            Client newClient = new Client("name" + i, "firstName" + i);
            clients.add(newClient);
        }
        return clients;
    }

    public static void displayClient(ArrayList<Client> clients) {
        clients.stream().forEach(System.out::println);
    }


    // 1.2.3 Creation of the tablea account
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

    public static void displayAccounts(ArrayList<Account> accounts) {
        accounts.stream().forEach(System.out::println);
    }

    // 1.3.1 Adaptation of the table of accounts
    public static Hashtable<Integer, Account> genenateAccountHashtable(ArrayList<Account> accounts) {
        Hashtable<Integer, Account> accountsHashtable = new Hashtable<>();
        for (Account account : accounts) {
            accountsHashtable.put(account.getAccountNumber(), account);
        }
        return accountsHashtable;
    }

    public static void displayAccountsHastable(Hashtable<Integer, Account> accountsHashtable) {
        accountsHashtable.entrySet().stream()
            .sorted((account1, account2) -> account1.getValue().getBalance().compareTo(account2.getValue().getBalance()))
            .forEach(System.out::println);
    }

    // 1.3.4 Creation of the flow array
    public static ArrayList<Flow> generateFlows() {
        ArrayList<Flow> flows = new ArrayList<>();
        
        flows.add(new Debit("Debit of 50€", 50.0, 1, false, LocalDate.now().plusDays(2)));
        accounts.stream().forEach((accounts) -> flows.add(_generateCreditFlow(accounts)));
        flows.add(new Transfer("Transfert of 50€ from 1 to 2", 50.00, 2, 1, false, LocalDate.now().plusDays(2)));

        return flows;
    }

    private static Credit _generateCreditFlow(Account account){
        if (account instanceof CurrentAccount) {
            return new Credit("Credit of 100.50€", 100.50, account.getAccountNumber(), false, LocalDate.now().plusDays(2));
        } else if (account instanceof SavingsAccount) {
            return new Credit("Credit of 1500€", 1500.00, account.getAccountNumber(), false, LocalDate.now().plusDays(2));
        } else {
            return null;
        }
    }

    // 1.3.5 Updating accounts
    public static void updateAccount(ArrayList<Flow> flows, Hashtable<Integer, Account> accountsHashtable) {
        for (Flow flow : flows) {
            accountsHashtable.get(flow.getTargetAccountNumber()).setBalance(flow);
            if (flow instanceof Transfer) {
                accountsHashtable.get(((Transfer)flow).getTransferingAccountNumber()).setBalance(flow);
            }
        }

        Predicate<Account> hasNegativeBalance = account -> account.getBalance() < 0;
        Optional<Account> hasNegativeAccount = accountsHashtable.values().stream().filter(hasNegativeBalance).findFirst();

        hasNegativeAccount.ifPresent(account -> System.out.println("There is an account with a negative balance."));
    }
}
