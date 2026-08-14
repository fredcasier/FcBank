package main.components;

import java.util.Date;

// 1.3.3 Creation of the Transfert, Credit, Debit classes
public class Transfer extends Flow {

    private Integer transferingAccountNumber;

    public Transfer(String comment, Double amount, Integer targetAccountNumber, Integer transferingAccountNumber, Boolean effect, Date flowDate) {
        super(comment, amount, targetAccountNumber, effect, flowDate);
        this.transferingAccountNumber = transferingAccountNumber;
    }
    
    public Integer getTransferingAccountNumber() {
        return transferingAccountNumber;
    }

    public void setTransferingAccountNumber(Integer transferingAccountNumber) {
        this.transferingAccountNumber = transferingAccountNumber;
    }
    
}
