package com.loneless.dao;

public class Factory {
    private final static Factory instance =new Factory();
    private Factory(){}
    private final static WorkWithFile fileWorker=new WorkWithFile();

    public static Factory getInstance(){
        return instance;
    }

    public static WorkWithFile getFileWorker(){
        return fileWorker;
    }
}
