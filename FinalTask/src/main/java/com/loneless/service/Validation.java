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


    public LocalDate validData(String string) throws ServiceException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm", Locale.ENGLISH);
            return LocalDate.parse(string, formatter);
        }
        catch (java.time.format.DateTimeParseException e){
            throw new ServiceException("Невеный ввод даты. Пример корректного форматы даты 01-Jan-2019:20:20 "+e);
        }
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
    public BigDecimal receiveBigDecimalFromString(String num) throws ServiceException {
        try {
            return new BigDecimal(num);
        }
        catch (java.lang.NumberFormatException e){
            throw new ServiceException("Оцибка при приведении строки в BigDecimal при валидации "+e.getMessage());
        }
    }

}
