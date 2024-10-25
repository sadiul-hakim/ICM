package xyz.sadiulhakim.data;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private String id;
    private TransactionType type;
    private double amount;
    private String description;
    private LocalDateTime localDateTime;

    public Transaction() {
    }

    public Transaction(String id, TransactionType type, double amount, String description, LocalDateTime localDateTime) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.localDateTime = localDateTime;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Double.compare(amount, that.amount) == 0 && type == that.type && Objects.equals(description, that.description) && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, description, localDateTime);
    }

}
