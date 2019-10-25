package com.loneless.service;

import com.loneless.entity.Category;
import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logic {
    private static Logic ourInstance = new Logic();

    public static Logic getInstance() {
        return ourInstance;
    }

    private Logic() {
    }

    public BigDecimal countSumOfMoney(TransactionWhipper transactionWhipper){
        BigDecimal currentSum=new BigDecimal(0.0);
        for (Transaction transaction :
                transactionWhipper.getTransactions()) {
            currentSum=currentSum.add(transaction.getSum());
        }
        return currentSum;
    }

    public Transaction createTransaction(String date,String category,String sum, String planned) {
        return new Transaction(
                DataGenerator.getUniTrID(),
                LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm", Locale.ENGLISH)),
                Category.valueOf(category.toUpperCase()),
                new BigDecimal(sum),
                Boolean.valueOf(planned));
    }

    public void addTransaction(TransactionWhipper transactionWhipper,Transaction transaction){
        transactionWhipper.getTransactions().add(transaction);
    }
    public boolean removeTransactionByID(TransactionWhipper transactionWhipper, int id){
        return transactionWhipper.getTransactions().removeIf(transaction -> transaction.getID()==id);
    }
    public boolean changeTransactionByID(TransactionWhipper transactionWhipper,Transaction newTransaction,
                                      Transaction oldTransaction){
        return Collections.replaceAll(transactionWhipper.getTransactions(),oldTransaction,newTransaction);
    }
    public List<Transaction> findOllTransactionToCurrentDate(LocalDate dataToFind,
                                                             TransactionWhipper transactionWhipper){
        List<Transaction> finderTransaction=new LinkedList<>();
        for (Transaction transaction:
             transactionWhipper.getTransactions()) {
            if(transaction.getDate().compareTo(dataToFind) > 0){
                finderTransaction.add(transaction);
            }
        }
        return finderTransaction;
    }

    public List<Transaction> findOllTransactionInInterval(LocalDate left,LocalDate right,
                                                          TransactionWhipper transactionWhipper){
        List<Transaction> finderTransaction=new LinkedList<>();
        for (Transaction transaction:
                transactionWhipper.getTransactions()) {
            if(transaction.getDate().compareTo(left)>0&&transaction.getDate().compareTo(right)<0){
                finderTransaction.add(transaction);
            }
        }
        return finderTransaction;
    }

    public List<Transaction> filterTransaction(Transaction transactionToFind,List<Transaction> transactions){
        List<Transaction> finedTransaction=new LinkedList<>();
       transactions.stream()
               .filter(Objects::nonNull)
               .filter(transaction -> transaction.getSum().equals(transactionToFind.getSum()))
               .filter(transaction -> transaction.getCategory().equals(transactionToFind.getCategory()))
               .filter(transaction -> transaction.getDate().equals(transactionToFind.getDate()))
               .filter(transaction -> transaction.isPlanned()==(transactionToFind.isPlanned()))
                .forEach(finedTransaction::add);
       return finedTransaction;
    }
}
