package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Menu;

import java.io.IOException;

public class UpdateTransaction implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        Menu.getInstance().editTransaction(Menu.getInstance().chooseTransactionFromList(
                TransactionWhipper.getInstance().getTransactions()));
        return false;
    }
}
