package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.service.Authorization;
import com.loneless.view.Menu;

import java.io.IOException;

public class AutorisateUser implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        return Authorization.getInstance().isExist(Menu.getInstance().authorisation());
    }
}
