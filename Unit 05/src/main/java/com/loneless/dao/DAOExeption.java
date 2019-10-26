package com.loneless.dao;

public class DAOExeption extends Exception{
    private String exception ="";
    public DAOExeption(String exception){
        this.exception +=exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}

