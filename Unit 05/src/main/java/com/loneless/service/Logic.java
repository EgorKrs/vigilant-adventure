package com.loneless.service;

import com.loneless.dao.DAOExeption;
import com.loneless.dao.FactoryDAO;
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

    public boolean addTransaction(TransactionWhipper transactionWhipper,Transaction transaction){
        if(Validation.getInstance().isTransactionValid(transaction)) {
            transactionWhipper.getTransactions().add(transaction);
            return true;
        }
        else return false;
    }
    public boolean removeTransactionByID(TransactionWhipper transactionWhipper, int id){
        return transactionWhipper.getTransactions().removeIf(transaction -> transaction.getID()==id);
    }
    public Transaction receiveTransactionByID(List<Transaction> transactions, int id) {
        Optional<Transaction> transactionThatWeLookingFor=transactions.stream().filter(transaction -> transaction.getID()==id).findFirst();
        return transactionThatWeLookingFor.orElseGet(Transaction::new);
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
            if(transaction.getDate().compareTo(left)>=0&&transaction.getDate().compareTo(right)<=0){
                finderTransaction.add(transaction);
            }
        }
        return finderTransaction;
    }

    public List<Transaction> findAllPlannedTransaction(List<Transaction> transactions){
        List<Transaction> transactionsWeNeed=new LinkedList<>();
        transactions.stream()
                .filter(Objects::nonNull)
                .filter(Transaction::isPlanned)
                .forEach(transactionsWeNeed::add);
        return transactionsWeNeed;

    }
    public boolean saveTransaction() throws ServiceException {
        try {
            FactoryDAO.getFileWorker().writeObject(TransactionWhipper.getInstance(),"someData.txt");
            return true;
        } catch (DAOExeption daoExeption) {
            throw new ServiceException("Невозможно сохранить транзакции"+daoExeption.getMessage());
        }
    }


}
