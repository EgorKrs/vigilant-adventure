package com.loneless.service;

public class ServiceException extends Exception{
    private String exception="";
    ServiceException(String exception){
        this.exception+=exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
