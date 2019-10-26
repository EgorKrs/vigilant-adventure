package com.loneless.view;

public class ViewException extends Exception{
    private String exception="";
    ViewException(String exception){
        this.exception+=exception;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
