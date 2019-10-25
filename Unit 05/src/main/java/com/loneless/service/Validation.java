package com.loneless.service;

import com.loneless.entity.Category;
import com.loneless.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Validation {

    private static final Validation instance=new Validation();
    private Validation(){}
    public static Validation getInstance(){
        return instance;
    }

    public boolean isTransactionNull(Transaction transaction){
        boolean n=true;
        if(transaction==null)
            return true;
        else if(transaction.getDate()!=null)
            n=false;
        else if(transaction.getCategory()!=null){
            n=false;
        }
        else if( transaction.getSum() != null){
            n=false;
        }
        return n;
    }

    public boolean isTransactionValid(Transaction transaction){
        if(transaction==null)
            return false;
        else if(transaction.getID()<0)
            return false;
        else if(transaction.getDate()==null)
            return false;
        else if(transaction.getCategory()==null){
            return false;
        }
        else return transaction.getSum() != null;
    }


    public LocalDate validData(String string){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm", Locale.ENGLISH);
        return  LocalDate.parse(string, formatter);

    }
    public boolean isSuchCategoryExist(String name){
        for (Category category :
                Category.values()) {
            if (category.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    public BigDecimal receiveBigDecimalFromString(String num){
        return new BigDecimal(num);
    }

}
