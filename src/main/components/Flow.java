package main.components;

import java.time.LocalDate;

// 1.3.2 Creation of the Flow class
public abstract class Flow {
    private String comment;
    private Integer identifier;
    private Double amount;
    private Integer targetAccountNumber;
    private Boolean effect;
    private LocalDate flowDate;

    private static Integer flowCount = 1;

    public Flow(String comment, Double amount, Integer targetAccountNumber) {
        this.comment = comment;
        this.identifier = Flow.flowCount;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
        this.effect = true;
        this.flowDate = LocalDate.now().plusDays(2);

        Flow.flowCount++;
    }

    public Flow(String comment, Double amount, Integer targetAccountNumber, LocalDate flowDate) {
        this.comment = comment;
        this.identifier = Flow.flowCount;
        this.amount = amount;
        this.targetAccountNumber = targetAccountNumber;
        this.effect = true;
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

    public LocalDate getFlowDate() {
        return flowDate;
    }

    public void setFlowDate(LocalDate flowDate) {
        this.flowDate = flowDate;
    }

    @Override
    public String toString() {
        StringBuilder flowDescription = new StringBuilder();
        flowDescription.append("Flow n°").append(this.identifier)
                .append(" = Comment: ").append(this.comment)
                .append(", Amount: ").append(this.amount)
                .append(", Target account: ").append(this.targetAccountNumber)
                .append(", Effect: ").append(this.effect ? "to do" : "done")
                .append(", Flow date: ").append(this.flowDate);

        if (this instanceof Transfer) {
            flowDescription.append(", Transfering account: ")
                    .append(((Transfer) this).getTransferingAccountNumber());
        }

        return flowDescription.toString();
    }
}
