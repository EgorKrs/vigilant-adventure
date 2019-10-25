package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Menu;

import java.io.IOException;

public class AddTransaction implements Command {
    @Override
    public boolean execute() throws IOException {
        TransactionWhipper.getInstance().getTransactions().add(Menu.getInstance().receiveDataForTransaction());
        return false;
    }
}
