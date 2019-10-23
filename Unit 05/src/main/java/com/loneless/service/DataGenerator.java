package com.loneless.service;

import com.github.javafaker.Faker;
import com.loneless.entity.TransactionWhipper;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DataGenerator {
    private static final DataGenerator instance =new DataGenerator();

    private static final Faker faker =new Faker();// прикольная "генерация" объектов - это для базовых значений

    private static final Random random=new Random();

    private static  AtomicInteger uniTransactionID =new AtomicInteger();

    private static  AtomicInteger uniUserID =new AtomicInteger();

    private DataGenerator(){}

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

    public static void setUniUserID(AtomicInteger uniUserID) {
        DataGenerator.uniUserID = uniUserID;
    }

    public static AtomicInteger getUniUserID() {
        return uniUserID;
    }
}
