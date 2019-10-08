package com.loneless;
/*Написать программу, которая по заданным трем числам определяет, является ли сумма каких-либо
двух из них положительной. */
public class Task32 {
    public boolean execute(int a,int b,int c){
        boolean isPos=false;
        if(a>=0){
            isPos=true;
        }
        if(b>=0){
            if(isPos){
                return true;
            }
            else {
                isPos=true;
            }
        }
        if(c>=0){
            if(isPos){
                return true;
            }
        }
        if(a+b>=0||a+c>=0||b+c>=0){
            return true;
        }
        else return false;
    }
}
