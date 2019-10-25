package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Menu;

import java.io.IOException;

public class DeliteTransaction implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        return TransactionWhipper.getInstance().getTransactions().remove(Menu.getInstance().chooseTransactionFromList(
                TransactionWhipper.getInstance().getTransactions()));

    }
}
