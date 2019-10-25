package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.Transaction;
import com.loneless.view.Menu;

import java.io.IOException;

public class FindTransaction implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        Transaction transaction =Menu.getInstance().receiveTransactionToFind();
        if(transaction.getID()!=0){

        }
        return false;
    }
}
