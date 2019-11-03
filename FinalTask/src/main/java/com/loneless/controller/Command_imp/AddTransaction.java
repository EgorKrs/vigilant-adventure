package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.CommandProvider;
import com.loneless.controller.ControllerException;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;

public class AddTransaction implements Command {
    @Override
    public boolean execute() throws ControllerException {
        try {
            if( Logic.getInstance().addTransaction(TransactionWhipper.getInstance(),
                    Menu.getInstance().receiveDataForTransaction())){
                CommandProvider.getCommandProvider().getCommand("Save_Transactions").execute();
                return true;
            }
        } catch (ViewException e) {
           throw new ControllerException("Ошибка при добавлении транзакции "+e.getException());
        }
        return false;
    }
}
