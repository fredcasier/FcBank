package main.components;

// 1.2.1 Creation of the Account class
public abstract class Account {
    protected String label;
    protected Double balance;
    protected Integer accountNumber;
    protected Client client;

    static private Integer accountsCount = 1;

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


    // 1.3.5 Updating accounts
    public void setBalance(Flow flow) {
        if (flow instanceof Credit) {
            this.balance += flow.getAmount();
        } else if (flow instanceof Debit) {
            this.balance -= flow.getAmount();
        } else if (flow instanceof Transfer) {
            if (flow.getTargetAccountNumber() == this.accountNumber) {
                this.balance += flow.getAmount();
            } else if (((Transfer)flow).getTransferingAccountNumber() == this.accountNumber) {
                this.balance -= flow.getAmount();
            }
        }
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Account n°" + this.accountNumber + " = " 
            + "Label: " + this.label + ", " 
            + "Client: " + this.client + ", " 
            + "Balance: " + this.balance;
    }
}
