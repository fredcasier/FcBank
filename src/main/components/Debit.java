package main.components;

import java.util.Date;

// 1.3.3 Creation of the Transfert, Credit, Debit classes
public class Debit extends Flow {

    public Debit(String comment, Double amount, Integer targetAccountNumber, Boolean effect, Date flowDate) {
        super(comment, amount, targetAccountNumber, effect, flowDate);
    }

}
