package com.loneless.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction implements Serializable {
    private int ID;
    private LocalDate date;
    private Category category;
    private BigDecimal sum;
    private boolean planned;
    private static final long serialVersionUID=32L;
    public Transaction() {
    }

    public Transaction(int ID, LocalDate date, Category category, BigDecimal sum, boolean planned) {
        this.ID = ID;
        this.date = date;
        this.category = category;
        this.sum = sum;
        this.planned = planned;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public boolean isPlanned() {
        return planned;
    }

    public void setPlanned(boolean planned) {
        this.planned = planned;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "ID=" + ID +
                ", date=" + date +
                ", category=" + category +
                ", sum=" + sum +
                ", planned=" + planned +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return ID == that.ID &&
                planned == that.planned &&
                Objects.equals(date, that.date) &&
                category == that.category &&
                Objects.equals(sum, that.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, date, category, sum, planned);
    }
}
