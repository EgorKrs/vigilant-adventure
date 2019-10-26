package com.loneless.dao;

import com.loneless.entity.TransactionWhipper;
import com.loneless.entity.UserPrivateData;

import java.io.*;

public class WorkWithFile {

    WorkWithFile(){}

    public void writeObject(TransactionWhipper transactionWhipper, String fileName) throws IOException {
        ObjectOutputStream outputStream=new  ObjectOutputStream(new FileOutputStream(fileName));
        outputStream.writeObject(transactionWhipper);
    }
    public TransactionWhipper readObject(String fileName) throws IOException,
            ClassNotFoundException {
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(fileName));
        TransactionWhipper transactionWhipper = (TransactionWhipper) inputStream.readObject();
        return transactionWhipper;
    }
    public void writeObject(UserPrivateData userData, String fileName) throws IOException {
        ObjectOutputStream outputStream=new  ObjectOutputStream(new FileOutputStream(fileName));
        outputStream.writeObject(userData);
    }
    public UserPrivateData readObject(UserPrivateData userData,String fileName) throws IOException,
            ClassNotFoundException {
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(fileName));
        userData=(UserPrivateData) inputStream.readObject();
        return userData;
    }



}
