package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Menu;

import java.io.IOException;

public class GetAllTransaction implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        Menu.getInstance().printAllTransaction(TransactionWhipper.getInstance().getTransactions());
        return true;
    }
}
