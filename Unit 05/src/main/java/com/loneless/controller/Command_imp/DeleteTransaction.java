package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;


public class DeleteTransaction implements Command {
    @Override
    public boolean execute() throws ControllerException, ViewException {
        if (CommandProvider.getCommandProvider().getCommand("Receive_All_Transaction").execute()) {
            if (Logic.getInstance().removeTransactionByID(TransactionWhipper.getInstance(), Menu.getInstance().receiveID())) {
                CommandProvider.getCommandProvider().getCommand("Save_Transactions").execute();
                return true;
            }
        } else return false;
        return false;
    }
}
