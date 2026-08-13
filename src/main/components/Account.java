package main.components;

// 1.2.1 Creation of the Account class
public abstract class Account {
    protected String label;
    protected Double balance;
    protected Integer accountNumber;
    protected Client client;

    static private Integer accountsCount;

    public Account(String label, Client client) {
        this.label = label;
        this.client = client;
        this.balance = 0.0;
        this.accountNumber = Account.accountsCount;
        Account.accountsCount ++;
    }

    public Client getClient() {
        return client;
    }

    public String getLabel() {
        return label;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account n°" + this.accountNumber + "\n" 
            + "Label: " + this.label + "\n" 
            + "Client: " + this.client + "\n" 
            + "Balance: " + this.balance;
    }
}
