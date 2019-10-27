package com.loneless.dao;

import com.loneless.entity.TransactionWhipper;
import com.loneless.entity.UserPrivateData;

import java.io.*;

public class WorkWithFile {

    WorkWithFile(){}

    public void writeObject(TransactionWhipper transactionWhipper, String fileName) throws DAOExeption {

        try(ObjectOutputStream outputStream  = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(transactionWhipper);
        }
        catch (IOException e){
            throw new DAOExeption("Проблемы доступа к файлу "+fileName+"  "+e.getMessage());
        }

    }
    public TransactionWhipper readObject(String fileName) throws DAOExeption {
        try(ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream(fileName))) {
            return (TransactionWhipper) inputStream.readObject();
        }
        catch (ClassNotFoundException e){
            throw new DAOExeption("Необходимо обновить данные файла "+e.getMessage());
        }
        catch (IOException e){
            throw new DAOExeption("Проблемы доступа к файлу "+fileName+"  "+e.getMessage());
        }

    }
    public void writeObject(UserPrivateData userData, String fileName) throws DAOExeption {
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(userData);
        }
        catch (IOException e){
            throw new DAOExeption("Проблемы доступа к файлу "+fileName+"  "+e.getMessage());
        }
    }

    public UserPrivateData readObject(UserPrivateData userData,String fileName) throws DAOExeption {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            userData = (UserPrivateData) inputStream.readObject();
            return userData;
        }
        catch (ClassNotFoundException e){
            throw new DAOExeption("Необходимо обновить данные файла "+e.getMessage());
        }
        catch (IOException e){
            throw new DAOExeption("Проблемы доступа к файлу "+fileName+"  "+e.getMessage());
        }
    }



}
