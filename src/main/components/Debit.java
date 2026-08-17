package main.components;

import java.time.LocalDate;

// 1.3.3 Creation of the Transfert, Credit, Debit classes
public class Debit extends Flow {

    public Debit(String comment, Double amount, Integer targetAccountNumber) {
        super(comment, amount, targetAccountNumber);
    }

    public Debit(String comment, Double amount, Integer targetAccountNumber, LocalDate flowDate) {
        super(comment, amount, targetAccountNumber, flowDate);
    }

}
