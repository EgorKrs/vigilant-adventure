package com.loneless.service;

import com.loneless.entity.Category;

public class Validation {

    private static final Validation instance=new Validation();
    private Validation(){}
    public static Validation getInstance(){
        return instance;
    }
    public void deltaBalanceConstructorValidation(){

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

}
