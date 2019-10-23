package com.loneless.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TransactionWhipper implements Serializable {
    private List<Transaction> transactions =new LinkedList<>();
    private static final long serialVersionUID=33L;
    public TransactionWhipper(){

    }

    public TransactionWhipper(List<Transaction> transactionList) {
        this.transactions = transactionList;
    }

    public Transaction getDeltaBalance(int index){
        return transactions.get(index);
    }

    public void setDeltaBalance(Transaction balance){
        transactions.add(balance);
    }

    public void setDeltaBalance(Transaction balance, int pos){
        transactions.set(pos,balance);
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
