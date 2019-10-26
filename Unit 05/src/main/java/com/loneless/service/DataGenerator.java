package com.loneless.service;

import com.github.javafaker.Faker;
import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DataGenerator {

    private static final DataGenerator instance =new DataGenerator();

    private static final Faker faker =new Faker();// прикольная "генерация" объектов - это для базовых значений

    private static final Random random=new Random();

    private static AtomicInteger uniTransactionID;

    private static  AtomicInteger uniUserID =new AtomicInteger();

    private DataGenerator(){
        uniTransactionID =new AtomicInteger();
        uniTransactionID.set(TransactionWhipper.getInstance().getTransactions().get(
                TransactionWhipper.getInstance().getTransactions().size()-1).getID());
    }

    public static DataGenerator getInstance() {
        return instance;
    }

    public Faker getFaker(){
        return faker;
    }

    public Random getRandom(){
        return random;
    }

    public static AtomicInteger getUniTransactionID() {
        return uniTransactionID;
    }

    public static int getUniTrID() {
        return uniTransactionID.incrementAndGet();
    }

    public static void setUniTransactionID(TransactionWhipper transactionWhipper) {
        uniTransactionID.set(transactionWhipper.getTransactions().size());
    }


    public static AtomicInteger getUniUserID() {
        return uniUserID;
    }
}
