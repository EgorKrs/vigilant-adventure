package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;
import com.loneless.entity.Transaction;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.service.ServiceException;
import com.loneless.service.Validation;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;

import java.io.IOException;

public class UpdateTransaction implements Command {
    @Override
    public boolean execute() throws ControllerException {
        try {
            if(CommandProvider.getCommandProvider().getCommand("Receive_All_Transaction").execute()) {
                Transaction transaction=Logic.getInstance().receiveTransactionByID(
                        TransactionWhipper.getInstance().getTransactions(), Menu.getInstance().receiveID());
                if(Validation.getInstance().isTransactionValid(transaction)) {
                    Menu.getInstance().editTransaction(transaction);
                    CommandProvider.getCommandProvider().getCommand("Save_Transactions").execute();
                }
                else return false;
            }
            else return false;
        } catch (ViewException e) {
            throw new ControllerException("ошибка обновления записи "+e.getException());
        }
        return true;
    }
}
