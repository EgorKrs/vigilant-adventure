package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.ControllerException;
import com.loneless.entity.TransactionWhipper;
import com.loneless.service.Logic;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;

import java.io.IOException;

public class FindOllTransactionInInterval implements Command {
    @Override
    public boolean execute() throws  ControllerException {
        try {
            Menu.getInstance().printAllTransaction(Logic.getInstance().findOllTransactionInInterval(
                    Menu.getInstance().askAboutDate(), Menu.getInstance().askAboutDate(),
                    TransactionWhipper.getInstance()));
        } catch (ViewException e) {
            throw new ControllerException("Ошибка в поиске транзакций в заданном интервале "+e.getException());
        }
        return true;
    }
}
