package main.components;

import java.time.LocalDate;

// 1.3.3 Creation of the Transfert, Credit, Debit classes
public class Transfer extends Flow {

    private Integer transferingAccountNumber;

    public Transfer(String comment, Double amount, Integer targetAccountNumber, Integer transferingAccountNumber) {
        super(comment, amount, targetAccountNumber);
        this.transferingAccountNumber = transferingAccountNumber;
    }

    public Transfer(String comment, Double amount, Integer targetAccountNumber, Integer transferingAccountNumber, LocalDate flowDate) {
        super(comment, amount, targetAccountNumber, flowDate);
        this.transferingAccountNumber = transferingAccountNumber;
    }
    
    public Integer getTransferingAccountNumber() {
        return transferingAccountNumber;
    }

    public void setTransferingAccountNumber(Integer transferingAccountNumber) {
        this.transferingAccountNumber = transferingAccountNumber;
    }
    
}
