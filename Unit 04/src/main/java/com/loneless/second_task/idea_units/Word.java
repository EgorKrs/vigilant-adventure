package com.loneless.second_task.idea_units;

import com.loneless.second_task.Idea;

public class Word implements Idea {
    private String symbols;

    public String getSymbols() {
        return symbols;
    }

    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public StringBuilder receiveIdea() {
        StringBuilder idea=new StringBuilder();
        return idea.append(getSymbols());
    }
}
