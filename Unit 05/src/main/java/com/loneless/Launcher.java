package com.loneless;

import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Demo;


import java.io.*;

public class Launcher {
    static TransactionWhipper changes=new TransactionWhipper();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Demo demo=new Demo();
       // demo.defaultTransactionAddToFile(changes);
        changes=demo.defaultTransactionReadFromFile("someData.txt",changes);
        for (Transaction transaction :
                changes.getTransactions()) {
            System.out.println(transaction);
        }

    }
}
