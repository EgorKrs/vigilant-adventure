package com.loneless;

import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Demo;
import com.loneless.view.Menu;


import java.io.*;
import java.text.ParseException;

public class Launcher {
    static TransactionWhipper transactionWhipper =new TransactionWhipper();
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        Demo demo=new Demo();
//        demo.defaultTransactionAddToFile(transactionWhipper);
       // transactionWhipper =demo.defaultTransactionReadFromFile("someData.txt", transactionWhipper);
//        for (Transaction transaction :
//                transactionWhipper.getTransactions()) {
//            System.out.println(transaction);
//        }
//        String string = "30-Jan-2016:04:13";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse(string, formatter);
//        System.out.println(date); // 2010-01-02
//        demo.addDefaultUserToFile();
//        System.out.println(FactoryDAO.getFileWorker().readObject(new UserPrivateData(),"UserData.txt"));
        Menu menu=new Menu();
        menu.startMenu();
    }
}
