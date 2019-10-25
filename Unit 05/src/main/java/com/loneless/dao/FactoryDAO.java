package com.loneless.dao;

public class FactoryDAO {
    private final static FactoryDAO instance =new FactoryDAO();
    private FactoryDAO(){}
    private final static WorkWithFile fileWorker=new WorkWithFile();

    public static FactoryDAO getInstance(){
        return instance;
    }

    public static WorkWithFile getFileWorker(){
        return fileWorker;
    }
}
