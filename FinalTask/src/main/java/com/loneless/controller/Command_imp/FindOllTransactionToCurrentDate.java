package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.ControllerException;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;

import java.io.IOException;

public class FindOllTransactionToCurrentDate implements Command {
    @Override
    public boolean execute() throws  ControllerException {
        try {
            Menu.getInstance().printAllTransaction(Logic.getInstance().findOllTransactionToCurrentDate(
                    Menu.getInstance().askAboutDate(), TransactionWhipper.getInstance()));
        } catch (ViewException e) {
            throw new ControllerException("Ошибка выполнения поиска транзакций до текущей даты "+e.getException());
        }
        return true;
    }
}
