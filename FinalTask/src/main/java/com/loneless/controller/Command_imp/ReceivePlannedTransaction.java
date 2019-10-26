package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;



public class ReceivePlannedTransaction implements Command {
    @Override
    public boolean execute()  {
        Menu.getInstance().printAllTransaction(Logic.getInstance().findAllPlannedTransaction(
                TransactionWhipper.getInstance().getTransactions()));
        return false;
    }
}
