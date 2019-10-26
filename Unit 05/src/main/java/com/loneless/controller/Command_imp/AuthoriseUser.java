package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.controller.ControllerException;
import com.loneless.service.Authorization;
import com.loneless.service.ServiceException;
import com.loneless.view.Menu;
import com.loneless.view.ViewException;

public class AuthoriseUser implements Command {
    @Override
    public boolean execute() throws ViewException, ControllerException {
        try {
            return Authorization.getInstance().isExist(Menu.getInstance().authorisation());
        } catch (ServiceException e) {
            throw new ControllerException("Ошибка авторизации "+e.getMessage());
        }
    }
}
