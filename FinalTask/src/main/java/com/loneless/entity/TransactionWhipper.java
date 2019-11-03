package com.loneless.entity;

import com.loneless.PathManager;
import com.loneless.dao.DAOExeption;
import com.loneless.dao.FactoryDAO;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TransactionWhipper implements Serializable { // не entity но довольно удобно расположить его тут
    private List<Transaction> transactions =new LinkedList<>();
    private static final long serialVersionUID=33L;
    private  static TransactionWhipper instance;

    static {
        String fileName= PathManager.getInstance().getTransactionData();
        try {
            instance = FactoryDAO.getFileWorker().readObject(fileName);
        }

        catch (DAOExeption daoExeption) {
            daoExeption.printStackTrace();
        }
    }

    public TransactionWhipper()  {    }

    public static TransactionWhipper getInstance() {
        if(instance==null)
            instance=new TransactionWhipper();
        return instance;
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
