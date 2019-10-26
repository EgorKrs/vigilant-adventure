package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.ControllerException;
import com.loneless.service.Logic;
import com.loneless.service.ServiceException;
import com.loneless.view.ViewException;

public class SaveTransactions implements Command {
    @Override
    public boolean execute() throws ViewException, ControllerException {
        try {
            Logic.getInstance().saveTransaction();
        } catch (ServiceException e) {
            throw new ControllerException(e.getException());
        }
        return false;
    }
}
