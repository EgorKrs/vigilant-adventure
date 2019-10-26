package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.view.Menu;

import java.io.IOException;

public class ReceiveAllTransaction implements Command {
    @Override
    public boolean execute()  {
        Menu.getInstance().printAllTransaction(TransactionWhipper.getInstance().getTransactions());
        return true;
    }
}
