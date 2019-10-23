package com.loneless.entity;


import java.io.Serializable;

public enum Category implements Serializable {
    ENTERTAINMENT("ENTERTAINMENT"),
    CATEGORY("CATEGORY"),
    CLOTHES("CLOTHES");
    private String name;
    private static final long serialVersionUID=31L;
    Category(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

}
