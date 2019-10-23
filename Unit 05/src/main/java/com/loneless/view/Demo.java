package com.loneless.view;

import com.loneless.dao.WorkWithfile;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.DataGenerator;
import com.loneless.entity.Category;
import com.loneless.entity.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Demo {


    public void defaultTransactionAddToFile(TransactionWhipper transactionWhipper) throws IOException {
        Transaction change;
        for (int i=0;i<5;i++){
            change=new Transaction();
            change.setID(DataGenerator.getUniTransactionID().incrementAndGet());
            change.setCategory(Category.values()[DataGenerator.getInstance().getRandom().
                    nextInt(Category.values().length)]);
            Calendar calendar = new GregorianCalendar();
            calendar.add(calendar.WEEK_OF_MONTH,-1);
            change.setDate(new java.sql.Date(DataGenerator.getInstance().getFaker().date().between(calendar.getTime(),
                    new Date()).getTime()).toLocalDate());
            change.setPlanned(DataGenerator.getInstance().getRandom().nextBoolean());
            change.setSum(BigDecimal.valueOf(DataGenerator.getInstance().
                    getFaker().number().randomDouble(100000,-10000,10000)));
            System.out.println("data: "+change+"was add");
            transactionWhipper.getTransactions().add(change);
        }
        WorkWithfile.getInstance().writeObject(transactionWhipper,"someData.txt");
    }
    public TransactionWhipper defaultTransactionReadFromFile(String fileName,TransactionWhipper transactionWhipper) throws IOException, ClassNotFoundException {
        return WorkWithfile.getInstance().readObject(transactionWhipper,fileName);
    }

}
