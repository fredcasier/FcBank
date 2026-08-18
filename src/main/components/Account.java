package main.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// 1.2.1 Creation of the Account class
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type"
)
@JsonSubTypes({
	    @JsonSubTypes.Type(value = CurrentAccount.class, name = "current"),
	    @JsonSubTypes.Type(value = SavingsAccount.class, name = "savings")
})
public abstract class Account {
    protected String label;
    protected Double balance;
    protected Integer accountNumber;
    protected Client client;

    static private Integer accountsCount = 1;
    
    public Account() {}

    public Account(String label, Client client) {
        this.label = label;
        this.client = client;
        this.balance = 0.0;
        this.accountNumber = Account.accountsCount;
        Account.accountsCount++;
    }

    public Account(String label, Client client, Double balance) {
        this.label = label;
        this.client = client;
        this.balance = balance;
        this.accountNumber = Account.accountsCount;
        Account.accountsCount++;
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

    // Needed for Jackson to set Balance from xml file
    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    // 1.3.5 Updating accounts
    @JsonIgnore
    public void setBalance(Flow flow) {
        if (flow.getEffect()) {
            if (flow instanceof Credit) {
                this.balance += flow.getAmount();
            } else if (flow instanceof Debit) {
                this.balance -= flow.getAmount();
            } else if (flow instanceof Transfer) {
                if (flow.getTargetAccountNumber() == this.accountNumber) {
                    this.balance += flow.getAmount();
                } else if (((Transfer) flow).getTransferingAccountNumber() == this.accountNumber) {
                    this.balance -= flow.getAmount();
                }
            }
            flow.setEffect(false);
        }
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        StringBuilder accountDescription = new StringBuilder();
        accountDescription.append("Account n°").append(this.accountNumber)
                .append(" = Label: ").append(this.label)
                .append(", Client: ").append(this.client)
                .append(", Balance: ").append(this.balance);
        return accountDescription.toString();
    }
}
