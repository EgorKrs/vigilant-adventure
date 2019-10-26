package com.loneless.controller;

public class ControllerException extends Exception{
    private String exception="";
    public ControllerException(String exception){
        this.exception+=exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
