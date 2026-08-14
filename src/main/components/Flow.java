package main.components;

import java.util.Date;

// 1.3.2 Creation of the Flow class
public abstract class Flow {
    private String comment;
    private Integer identifier;
    private Double amount;
    private Integer targetAccountNumber;
    private Boolean effect;
    private Date flowDate;

    private static Integer flowCount = 0;

    public Flow(String comment, Double amount, Integer targetAccountNumber, Boolean effect, Date flowDate) {
        this.comment = comment;
        this.identifier = Flow.flowCount;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
        this.effect = effect;
        this.flowDate = flowDate;

        Flow.flowCount++;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

        public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public void setTargetAccountNumber(Integer targetAccountNumber) {
        this.targetAccountNumber = targetAccountNumber;
    }

    public Boolean getEffect() {
        return effect;
    }

    public void setEffect(Boolean effect) {
        this.effect = effect;
    }

    public Date getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(Date flowDate) {
        this.flowDate = flowDate;
    }
}
