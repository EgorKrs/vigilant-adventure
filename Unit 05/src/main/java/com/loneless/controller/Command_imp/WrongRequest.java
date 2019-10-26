package com.loneless.controller.Command_imp;

import com.loneless.controller.Command;
import com.loneless.view.Menu;

import java.io.IOException;

public class WrongRequest implements Command {
    @Override
    public boolean execute() throws IOException, ClassNotFoundException {
        Menu.getInstance().printError("данная функция пока не доступна");
        return true;
    }
}
