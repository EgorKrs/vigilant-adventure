package com.loneless.view;

import com.loneless.dao.FactoryDAO;
import com.loneless.entity.TransactionWhipper;
import com.loneless.entity.UserPrivateData;
import com.loneless.service.DataGenerator;
import com.loneless.entity.Category;
import com.loneless.entity.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Demo {


    public void defaultTransactionAddToFile(TransactionWhipper transactionWhipper) throws IOException {
        Transaction change;
        for (int i=0;i<5;i++){
            change=createDefaultTransaction();
            transactionWhipper.getTransactions().add(change);
        }
        FactoryDAO.getFileWorker().writeObject(transactionWhipper,"someData.txt");
    }

    public Transaction createDefaultTransaction(){
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.WEEK_OF_MONTH,-1);
        return new Transaction(
                DataGenerator.getUniTransactionID().incrementAndGet(),
                new java.sql.Date(DataGenerator.getInstance().getFaker().date().between(calendar.getTime(),
                        new Date()).getTime()).toLocalDate(),
                Category.values()[DataGenerator.getInstance().getRandom().
                        nextInt(Category.values().length)],
                BigDecimal.valueOf(DataGenerator.getInstance().
                        getFaker().number().randomDouble(100000,-10000,10000)),
                DataGenerator.getInstance().getRandom().nextBoolean());
    }

    public TransactionWhipper defaultTransactionReadFromFile(String fileName,TransactionWhipper transactionWhipper) throws IOException, ClassNotFoundException {
        return FactoryDAO.getFileWorker().readObject(transactionWhipper,fileName);
    }

    public void addDefaultUserToFile() throws IOException {
        UserPrivateData userPrivateData=createDefaultUser();
        FactoryDAO.getFileWorker().writeObject(createDefaultUser(),"UserData.txt");
    }

    public UserPrivateData createDefaultUser(){
        return new UserPrivateData(
                DataGenerator.getInstance().getFaker().funnyName().name(),
                DataGenerator.getInstance().getFaker().crypto().sha1()
        );
    }


}
